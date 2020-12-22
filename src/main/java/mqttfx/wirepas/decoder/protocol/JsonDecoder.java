
package mqttfx.wirepas.decoder.protocol;

import org.apache.commons.codec.binary.Hex;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import java.io.IOException;
import java.util.Date;

import java.nio.charset.StandardCharsets;
import mqttfx.wirepas.decoder.DecoderResult;
import mqttfx.wirepas.decoder.payload.PayloadDecoder;


public final class JsonDecoder extends ProtocolDecoder {


    @Override
    public DecoderResult decode(byte[] protocolPayload, boolean decodeDataPayload) throws IOException {
        // Convert byte to string
        final String jsonStr = new String(protocolPayload, StandardCharsets.UTF_8);

        // JSON string to JSON Node, to be able to alter it
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = (ObjectNode)objectMapper.readTree(jsonStr);

        String payloadName = "";
        if (decodeDataPayload) {
            // Modify some fields
            JsonNode timestampNode = rootNode.get("tx_time_ms_epoch");
            if (timestampNode != null) {
                // Convert timestamp as date
                Long timestamp = timestampNode.getLongValue();
                rootNode.put("tx_time_ms_epoch", DEFAULT_DATE_FORMAT.format(new Date(timestamp)));

                JsonNode dataNode = rootNode.get("data");
                if ((dataNode != null) && (dataNode.isTextual())) {
                    try {
                        final byte[] data = Hex.decodeHex(dataNode.getTextValue().toCharArray());
                        final int srcEp = (int)rootNode.get("source_endpoint").asLong();
                        final int dstEp = (int)rootNode.get("destination_endpoint").asLong();

                        DecoderResult result = PayloadDecoder.decodeDataPayload(srcEp, dstEp, data);

                        if (result != null) {
                            payloadName = "/" + result.decoderName;
                            rootNode.put("data", result.rootNode);
                        } else {
                            // Nothing to do
                        }
                    } catch (Exception e) {
                        // Nothing to do
                        e.printStackTrace(); // FIXME
                    }
                }
            }
        }

        return new DecoderResult("json"+payloadName, rootNode);
    }
}
