
package mqttfx.wirepas.decoder;

import mqttfx.wirepas.decoder.protocol.ProtocolDecoder;
import de.jensd.addon.decoder.AbstractPayloadDecoder;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class WirepasMultiDecoder extends AbstractPayloadDecoder {
    private final boolean decodePayload;

    /**
     * Default Constructor.
     */
    public WirepasMultiDecoder() {
        this(true);
    }

    public WirepasMultiDecoder(boolean decodePayload) {
        super();
        this.decodePayload = decodePayload;
    }

    /* DECODER API */

    @Override
    public String getName() {
        return "Multi-protocol Wirepas Decoder";
    }

    @Override
    public String getId() {
        return "wp_multi_decoder";
    }

    @Override
    public String getVersion() {
        return "0.9.0";
    }

    @Override
    public String getDescription() {
        return "Decode Wirepas messages & payloads into JSON format";
    }


    @Override
    public String decode(byte[] payload) {

        // call decoders
        final DecoderResult message = ProtocolDecoder.decodeProtocol(payload, decodePayload);
        if (message == null) {
            return "*** PAYLOAD IS NOT VALID WIREPAS DATA *** \n\n";
        }

        // add decoders name
        message.rootNode.put("$decoder", message.decoderName);

        // Pretty print result
        try {
            final ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectMapper.readValue(message.rootNode.toString(), Object.class));
        } catch (IOException e) {
            return "*** PAYLOAD IS NOT VALID *** \n\n";
        }
    }
}
