
package mqttfx.wirepas.decoder;


public class WirepasMultiDecoderRaw extends WirepasMultiDecoder {

    /**
     * Default Constructor.
     */
    public WirepasMultiDecoderRaw() {
        super(false);
    }

    @Override
    public String getName() {
        return "Multi-protocol Wirepas Decoder (Raw values)";
    }

    @Override
    public String getId() {
        return "wp_multi_decoder_raw";
    }
    
        @Override
    public String getDescription() {
        return "Decode Wirepas messages into JSON format";
    }

}
