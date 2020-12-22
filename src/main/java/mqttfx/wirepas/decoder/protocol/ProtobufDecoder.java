
package mqttfx.wirepas.decoder.protocol;

import com.google.protobuf.util.JsonFormat;

import org.apache.commons.codec.binary.Hex;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ObjectNode;

import java.io.IOException;
import java.util.Date;
import java.util.Base64;
import mqttfx.wirepas.decoder.DecoderResult;
import mqttfx.wirepas.decoder.payload.PayloadDecoder;

import wirepas.proto.gateway_api.GenericMessageOuterClass.GenericMessage;

public final class ProtobufDecoder extends ProtocolDecoder {

    @Override
    public DecoderResult decode(byte[] protocolPayload, boolean decodeDataPayload) throws IOException {
        // Convert protobuf to JSON string
        GenericMessage genMessage = GenericMessage.parseFrom(protocolPayload);
        String jsonStr = JsonFormat.printer().print(genMessage);

        // JSON string to JSON Node, to be able to alter it
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectNode rootNode = (ObjectNode)objectMapper.readTree(jsonStr);

        // Sanity check
        JsonNode wirepasNode = rootNode.get("wirepas");
        if (wirepasNode == null) {
            throw new IOException("*** Packet do not have Wirepas field set ***");
        }

        String payloadName = "";
        if (decodeDataPayload) {
            // Modify some fields
            ObjectNode eventNode = (ObjectNode)wirepasNode.get("packetReceivedEvent");
            if (eventNode != null) {
                // Convert timestamp as date
                Long timestamp = new Long(eventNode.get("rxTimeMsEpoch").getTextValue());
                eventNode.put("rxTimeMsEpoch", DEFAULT_DATE_FORMAT.format(new Date(timestamp)));

                // Decode Payload with decoders
                String payload = eventNode.get("payload").getTextValue();
                final byte[] payloadBytes = Base64.getDecoder().decode(payload);
                final int srcEp = (int)eventNode.get("sourceEndpoint").asLong();
                final int dstEp = (int)eventNode.get("destinationEndpoint").asLong();

                DecoderResult result = PayloadDecoder.decodeDataPayload(srcEp, dstEp, payloadBytes);

                if (result != null) {
                    payloadName = "/" + result.decoderName;
                    eventNode.put("payload", result.rootNode);
                } else {
                    // Default is to convert payload to Hex format
                    payloadName = "/default";
                    eventNode.put("payload", Hex.encodeHexString(payloadBytes));
                }
            }
        }

        return new DecoderResult("protobuf"+payloadName, rootNode);
    }
}
