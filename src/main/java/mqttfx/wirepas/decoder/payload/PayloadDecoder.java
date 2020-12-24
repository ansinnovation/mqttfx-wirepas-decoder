
package mqttfx.wirepas.decoder.payload;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import mqttfx.wirepas.decoder.DecoderResult;

import org.codehaus.jackson.map.ObjectMapper;

public abstract class PayloadDecoder {

    protected final ObjectMapper objectMapper = new ObjectMapper();
    protected ByteBuffer wrappedBuffer;

    protected void initBuffer(byte[] payload) {
        wrappedBuffer = ByteBuffer.wrap(payload);
        wrappedBuffer.order(ByteOrder.LITTLE_ENDIAN);
    }

    protected int getUnsignedShort() {
        int result = wrappedBuffer.getShort();
        return result & 0xFFFF;
    }
    protected int getSignedShort() {
        return wrappedBuffer.getShort();
    }

    protected int getUnsignedByte() {
        int result = wrappedBuffer.get();
        return result & 0xFF;
    }
    protected int getSignedByte() {
        return wrappedBuffer.get();
    }

    protected long getUnsignedInt() {
        long result = wrappedBuffer.getInt();
        return result & 0xFFFFFFFF;
    }
    protected int getSignedInt() {
        return wrappedBuffer.getInt();
    }

    protected boolean hasRemaining() {
        return wrappedBuffer.hasRemaining();
    }

    public abstract DecoderResult decode(int srcEp, int dstEp, byte[] payload) throws Exception;
    
    /* ********************************************************************** */
    private static final List<PayloadDecoder> PAYLOAD_DECODERS
            = Arrays.asList(
                    new PositioningDecoder()
            );

    public static DecoderResult decodeDataPayload(int srcEp, int dstEp, byte[] dataPayload) {
        for (PayloadDecoder decoder : PAYLOAD_DECODERS) {
            try {
                DecoderResult result = decoder.decode(srcEp, dstEp, dataPayload);
                if (result != null) {
                    return result;
                }
            } catch (Exception e) {
                // Nothing to do - try next one
            }
        }
        return null;
    }
}
