
package mqttfx.wirepas.decoder.protocol;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import mqttfx.wirepas.decoder.DecoderResult;

public abstract class ProtocolDecoder {
    protected static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("MMMM dd yyyy, HH:mm:ss.SSS");

    public abstract DecoderResult decode(byte[] protocolPayload, boolean decodeDataPayload) throws IOException;
    
    /* ********************************************************************** */
    private static final List<ProtocolDecoder> PROTOCOL_DECODERS
            = Arrays.asList(
                    new ProtobufDecoder(),
                    new JsonDecoder()
            );
    
    public static DecoderResult decodeProtocol(byte[] payload, boolean decodeDataPayload) {
        DecoderResult message = null;
        for (ProtocolDecoder protocolDecoder : PROTOCOL_DECODERS) {
            try {
                message = protocolDecoder.decode(payload, decodeDataPayload);
                break; // stop here if no error

            } catch (IOException e) {
                // Try next one
            }
        }
        return message;
    }
}
