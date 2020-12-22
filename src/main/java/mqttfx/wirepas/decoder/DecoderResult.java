
package mqttfx.wirepas.decoder;

import org.codehaus.jackson.node.ObjectNode;

public final class DecoderResult {
    public final String decoderName;
    public final ObjectNode rootNode;

    public DecoderResult(String decoderName, ObjectNode rootNode) {
        this.decoderName = decoderName;
        this.rootNode = rootNode;
    }
}
