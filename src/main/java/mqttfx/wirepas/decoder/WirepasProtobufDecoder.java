/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package mqttfx.wirepas.decoder;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import org.json.*;
import java.util.Base64;
import java.util.Date;

import de.jensd.addon.decoder.AbstractPayloadDecoder;
import wirepas.proto.gateway_api.GenericMessageOuterClass.GenericMessage;

public class WirepasProtobufDecoder extends AbstractPayloadDecoder {

	/**
	 * Constructor.
	 */
	public WirepasProtobufDecoder() {
		super();
	}

	@Override
	public String getName() {
		return "Wirepas Generic Protobuf decoder";
	}

	@Override
	public String getId() {
		return "wp_protobuf_decoder";
	}

	@Override
	public String getVersion() {
		return "1.1.0";
	}

	@Override
	public String getDescription() {
		return "Decode Wirepas protobuf into JSON format";
	}

	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();

	private static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}

	private String modifyJsonFormat(String jsonStr) {
		String result = jsonStr;
		JSONObject jsonObj, wirepasJsonObj;
		try {
			jsonObj = new JSONObject(jsonStr);
			wirepasJsonObj = jsonObj.getJSONObject("wirepas");

			// Try to see if it is a PacketReceived
			try {
				JSONObject rxEventObj = wirepasJsonObj.getJSONObject("packetReceivedEvent");

				// Convert timestamp as date
				Long timestamp = rxEventObj.getLong("rxTimeMsEpoch");
				rxEventObj.put("rxTimeMsEpoch", (new java.util.Date((long)timestamp).toString()));

				// Convert payload to Hex format
				String payload = rxEventObj.getString("payload");
				byte[] decoded = Base64.getDecoder().decode(payload);
				rxEventObj.put("payload", bytesToHex(decoded));
			} catch (JSONException e) {
				// Nothing to do
			}

			result = jsonObj.toString(4);
		} catch (JSONException e) {
			result = "*** Packet do not have Wirepas field set ***";
		}

		return result;
	}

	@Override
	public String decode(byte[] payload) {
		String result;
		String jsonStr;

		try {
			GenericMessage genMessage = GenericMessage.parseFrom(payload);
			jsonStr = JsonFormat.printer().print(genMessage);

			result = modifyJsonFormat(jsonStr);
		} catch (InvalidProtocolBufferException e) {
			result = "*** PAYLOAD IS NOT VALID WIREPAS PROTOBUF DATA *** \n\n";
		}
		
		return result;
	}
}
