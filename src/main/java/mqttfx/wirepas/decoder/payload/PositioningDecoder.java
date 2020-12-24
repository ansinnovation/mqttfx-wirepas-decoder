
package mqttfx.wirepas.decoder.payload;

import java.util.ArrayList;
import mqttfx.wirepas.decoder.DecoderResult;
import org.codehaus.jackson.node.ObjectNode;
import org.codehaus.jackson.node.ArrayNode;


public class PositioningDecoder extends PayloadDecoder {
    private static final String NAME = "positioning";

    public static final int MEAS_V4 = 0;
    public static final int MEAS_V5 = 5;
    public static final int VOLTAGE = 4;


    private class Measurement {
        long address;
        int rssi;

        public Measurement(int type) {
            address  = getUnsignedByte();
            address |= getUnsignedByte() << 8;
            address |= getUnsignedByte() << 16;

            if (type == MEAS_V5) {
                address |= getUnsignedByte() << 24;
            }

            rssi = getSignedByte();
        }

        public void updateArray(ArrayNode array) {
            ObjectNode val = objectMapper.createObjectNode();
            val.put("address", address);
            val.put("rssi", rssi);
            array.add(val);
        }
    }

    private class Voltage {
        int voltage;

        public Voltage() {
            voltage = getUnsignedShort();
        }

        public void updateRoot(ObjectNode root) {
            root.put("voltage", voltage);
        }
    }


    @Override
    public DecoderResult decode(int srcEp, int dstEp, byte[] payload) throws Exception {
        /* EP filtering */
        if ((srcEp != 238) || (dstEp != 238)) {
            return null;
        }

        /* payload processing */
        initBuffer(payload);
        final int seq_id = getUnsignedShort();
        final ArrayList<Measurement> meas = new ArrayList<>();
        Voltage voltage = null;

        while (hasRemaining()) {
            int mType = getUnsignedByte();
            int mLength = getUnsignedByte();

            if ((mType == MEAS_V4) || (mType == MEAS_V5)) {
                meas.add(new Measurement(mType));
            } else if (mType == VOLTAGE) {
                voltage = new Voltage();
            } else {
                wrappedBuffer.position(wrappedBuffer.position() + mLength);
            }
        }

        /* build json data object */
        final ObjectNode root = objectMapper.createObjectNode();
        root.put("sequence_id", seq_id);
        ArrayNode measArray = objectMapper.createArrayNode();
        root.put("measurements", measArray);
        for (Measurement m : meas) {
            m.updateArray(measArray);
        }
        if (voltage != null) {
            voltage.updateRoot(root);
        }

        return new DecoderResult(NAME, root);
    }

}
