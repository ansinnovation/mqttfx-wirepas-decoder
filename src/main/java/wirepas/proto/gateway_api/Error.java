// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: error.proto

package wirepas.proto.gateway_api;

public final class Error {
  private Error() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  /**
   * Protobuf enum {@code wirepas.proto.gateway_api.ErrorCode}
   */
  public enum ErrorCode
      implements com.google.protobuf.ProtocolMessageEnum {
    /**
     * <code>OK = 0;</code>
     */
    OK(0),
    /**
     * <code>INTERNAL_ERROR = 1;</code>
     */
    INTERNAL_ERROR(1),
    /**
     * <code>INVALID_SINK_ID = 2;</code>
     */
    INVALID_SINK_ID(2),
    /**
     * <code>INVALID_ROLE = 3;</code>
     */
    INVALID_ROLE(3),
    /**
     * <code>INVALID_NETWORK_ADDRESS = 4;</code>
     */
    INVALID_NETWORK_ADDRESS(4),
    /**
     * <code>INVALID_NETWORK_CHANNEL = 5;</code>
     */
    INVALID_NETWORK_CHANNEL(5),
    /**
     * <code>INVALID_CHANNEL_MAP = 6;</code>
     */
    INVALID_CHANNEL_MAP(6),
    /**
     * <code>INVALID_NETWORK_KEYS = 7;</code>
     */
    INVALID_NETWORK_KEYS(7),
    /**
     * <code>INVALID_AC_RANGE = 8;</code>
     */
    INVALID_AC_RANGE(8),
    /**
     * <code>INVALID_SINK_STATE = 9;</code>
     */
    INVALID_SINK_STATE(9),
    /**
     * <code>INVALID_DEST_ADDRESS = 10;</code>
     */
    INVALID_DEST_ADDRESS(10),
    /**
     * <code>INVALID_DEST_ENDPOINT = 11;</code>
     */
    INVALID_DEST_ENDPOINT(11),
    /**
     * <code>INVALID_SRC_ENDPOINT = 12;</code>
     */
    INVALID_SRC_ENDPOINT(12),
    /**
     * <code>INVALID_QOS = 13;</code>
     */
    INVALID_QOS(13),
    /**
     * <code>INVALID_DATA_PAYLOAD = 14;</code>
     */
    INVALID_DATA_PAYLOAD(14),
    /**
     * <code>INVALID_SCRATCHPAD = 15;</code>
     */
    INVALID_SCRATCHPAD(15),
    /**
     * <code>INVALID_SCRATCHPAD_SIZE = 16;</code>
     */
    INVALID_SCRATCHPAD_SIZE(16),
    /**
     * <code>INVLAID_SEQUENCE_NUMBER = 17;</code>
     */
    INVLAID_SEQUENCE_NUMBER(17),
    /**
     * <code>INVALID_REBOOT_DELAY = 18;</code>
     */
    INVALID_REBOOT_DELAY(18),
    /**
     * <code>INVALID_DIAG_INTERVAL = 19;</code>
     */
    INVALID_DIAG_INTERVAL(19),
    /**
     * <code>INVALID_APP_CONFIG = 20;</code>
     */
    INVALID_APP_CONFIG(20),
    /**
     * <code>INVALID_PARAM = 21;</code>
     */
    INVALID_PARAM(21),
    /**
     * <code>NO_SCRATCHPAD_PRESENT = 22;</code>
     */
    NO_SCRATCHPAD_PRESENT(22),
    /**
     * <code>ACCESS_DENIED = 23;</code>
     */
    ACCESS_DENIED(23),
    /**
     * <code>REQUEST_NEEDS_SINK_ID = 24;</code>
     */
    REQUEST_NEEDS_SINK_ID(24),
    /**
     * <code>INVALID_MAX_HOP_COUNT = 25;</code>
     */
    INVALID_MAX_HOP_COUNT(25),
    ;

    /**
     * <code>OK = 0;</code>
     */
    public static final int OK_VALUE = 0;
    /**
     * <code>INTERNAL_ERROR = 1;</code>
     */
    public static final int INTERNAL_ERROR_VALUE = 1;
    /**
     * <code>INVALID_SINK_ID = 2;</code>
     */
    public static final int INVALID_SINK_ID_VALUE = 2;
    /**
     * <code>INVALID_ROLE = 3;</code>
     */
    public static final int INVALID_ROLE_VALUE = 3;
    /**
     * <code>INVALID_NETWORK_ADDRESS = 4;</code>
     */
    public static final int INVALID_NETWORK_ADDRESS_VALUE = 4;
    /**
     * <code>INVALID_NETWORK_CHANNEL = 5;</code>
     */
    public static final int INVALID_NETWORK_CHANNEL_VALUE = 5;
    /**
     * <code>INVALID_CHANNEL_MAP = 6;</code>
     */
    public static final int INVALID_CHANNEL_MAP_VALUE = 6;
    /**
     * <code>INVALID_NETWORK_KEYS = 7;</code>
     */
    public static final int INVALID_NETWORK_KEYS_VALUE = 7;
    /**
     * <code>INVALID_AC_RANGE = 8;</code>
     */
    public static final int INVALID_AC_RANGE_VALUE = 8;
    /**
     * <code>INVALID_SINK_STATE = 9;</code>
     */
    public static final int INVALID_SINK_STATE_VALUE = 9;
    /**
     * <code>INVALID_DEST_ADDRESS = 10;</code>
     */
    public static final int INVALID_DEST_ADDRESS_VALUE = 10;
    /**
     * <code>INVALID_DEST_ENDPOINT = 11;</code>
     */
    public static final int INVALID_DEST_ENDPOINT_VALUE = 11;
    /**
     * <code>INVALID_SRC_ENDPOINT = 12;</code>
     */
    public static final int INVALID_SRC_ENDPOINT_VALUE = 12;
    /**
     * <code>INVALID_QOS = 13;</code>
     */
    public static final int INVALID_QOS_VALUE = 13;
    /**
     * <code>INVALID_DATA_PAYLOAD = 14;</code>
     */
    public static final int INVALID_DATA_PAYLOAD_VALUE = 14;
    /**
     * <code>INVALID_SCRATCHPAD = 15;</code>
     */
    public static final int INVALID_SCRATCHPAD_VALUE = 15;
    /**
     * <code>INVALID_SCRATCHPAD_SIZE = 16;</code>
     */
    public static final int INVALID_SCRATCHPAD_SIZE_VALUE = 16;
    /**
     * <code>INVLAID_SEQUENCE_NUMBER = 17;</code>
     */
    public static final int INVLAID_SEQUENCE_NUMBER_VALUE = 17;
    /**
     * <code>INVALID_REBOOT_DELAY = 18;</code>
     */
    public static final int INVALID_REBOOT_DELAY_VALUE = 18;
    /**
     * <code>INVALID_DIAG_INTERVAL = 19;</code>
     */
    public static final int INVALID_DIAG_INTERVAL_VALUE = 19;
    /**
     * <code>INVALID_APP_CONFIG = 20;</code>
     */
    public static final int INVALID_APP_CONFIG_VALUE = 20;
    /**
     * <code>INVALID_PARAM = 21;</code>
     */
    public static final int INVALID_PARAM_VALUE = 21;
    /**
     * <code>NO_SCRATCHPAD_PRESENT = 22;</code>
     */
    public static final int NO_SCRATCHPAD_PRESENT_VALUE = 22;
    /**
     * <code>ACCESS_DENIED = 23;</code>
     */
    public static final int ACCESS_DENIED_VALUE = 23;
    /**
     * <code>REQUEST_NEEDS_SINK_ID = 24;</code>
     */
    public static final int REQUEST_NEEDS_SINK_ID_VALUE = 24;
    /**
     * <code>INVALID_MAX_HOP_COUNT = 25;</code>
     */
    public static final int INVALID_MAX_HOP_COUNT_VALUE = 25;


    public final int getNumber() {
      return value;
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static ErrorCode valueOf(int value) {
      return forNumber(value);
    }

    /**
     * @param value The numeric wire value of the corresponding enum entry.
     * @return The enum associated with the given numeric wire value.
     */
    public static ErrorCode forNumber(int value) {
      switch (value) {
        case 0: return OK;
        case 1: return INTERNAL_ERROR;
        case 2: return INVALID_SINK_ID;
        case 3: return INVALID_ROLE;
        case 4: return INVALID_NETWORK_ADDRESS;
        case 5: return INVALID_NETWORK_CHANNEL;
        case 6: return INVALID_CHANNEL_MAP;
        case 7: return INVALID_NETWORK_KEYS;
        case 8: return INVALID_AC_RANGE;
        case 9: return INVALID_SINK_STATE;
        case 10: return INVALID_DEST_ADDRESS;
        case 11: return INVALID_DEST_ENDPOINT;
        case 12: return INVALID_SRC_ENDPOINT;
        case 13: return INVALID_QOS;
        case 14: return INVALID_DATA_PAYLOAD;
        case 15: return INVALID_SCRATCHPAD;
        case 16: return INVALID_SCRATCHPAD_SIZE;
        case 17: return INVLAID_SEQUENCE_NUMBER;
        case 18: return INVALID_REBOOT_DELAY;
        case 19: return INVALID_DIAG_INTERVAL;
        case 20: return INVALID_APP_CONFIG;
        case 21: return INVALID_PARAM;
        case 22: return NO_SCRATCHPAD_PRESENT;
        case 23: return ACCESS_DENIED;
        case 24: return REQUEST_NEEDS_SINK_ID;
        case 25: return INVALID_MAX_HOP_COUNT;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<ErrorCode>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        ErrorCode> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<ErrorCode>() {
            public ErrorCode findValueByNumber(int number) {
              return ErrorCode.forNumber(number);
            }
          };

    public final com.google.protobuf.Descriptors.EnumValueDescriptor
        getValueDescriptor() {
      return getDescriptor().getValues().get(ordinal());
    }
    public final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptorForType() {
      return getDescriptor();
    }
    public static final com.google.protobuf.Descriptors.EnumDescriptor
        getDescriptor() {
      return wirepas.proto.gateway_api.Error.getDescriptor().getEnumTypes().get(0);
    }

    private static final ErrorCode[] VALUES = values();

    public static ErrorCode valueOf(
        com.google.protobuf.Descriptors.EnumValueDescriptor desc) {
      if (desc.getType() != getDescriptor()) {
        throw new java.lang.IllegalArgumentException(
          "EnumValueDescriptor is not for this type.");
      }
      return VALUES[desc.getIndex()];
    }

    private final int value;

    private ErrorCode(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:wirepas.proto.gateway_api.ErrorCode)
  }


  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\013error.proto\022\031wirepas.proto.gateway_api" +
      "*\371\004\n\tErrorCode\022\006\n\002OK\020\000\022\022\n\016INTERNAL_ERROR" +
      "\020\001\022\023\n\017INVALID_SINK_ID\020\002\022\020\n\014INVALID_ROLE\020" +
      "\003\022\033\n\027INVALID_NETWORK_ADDRESS\020\004\022\033\n\027INVALI" +
      "D_NETWORK_CHANNEL\020\005\022\027\n\023INVALID_CHANNEL_M" +
      "AP\020\006\022\030\n\024INVALID_NETWORK_KEYS\020\007\022\024\n\020INVALI" +
      "D_AC_RANGE\020\010\022\026\n\022INVALID_SINK_STATE\020\t\022\030\n\024" +
      "INVALID_DEST_ADDRESS\020\n\022\031\n\025INVALID_DEST_E" +
      "NDPOINT\020\013\022\030\n\024INVALID_SRC_ENDPOINT\020\014\022\017\n\013I" +
      "NVALID_QOS\020\r\022\030\n\024INVALID_DATA_PAYLOAD\020\016\022\026" +
      "\n\022INVALID_SCRATCHPAD\020\017\022\033\n\027INVALID_SCRATC" +
      "HPAD_SIZE\020\020\022\033\n\027INVLAID_SEQUENCE_NUMBER\020\021" +
      "\022\030\n\024INVALID_REBOOT_DELAY\020\022\022\031\n\025INVALID_DI" +
      "AG_INTERVAL\020\023\022\026\n\022INVALID_APP_CONFIG\020\024\022\021\n" +
      "\rINVALID_PARAM\020\025\022\031\n\025NO_SCRATCHPAD_PRESEN" +
      "T\020\026\022\021\n\rACCESS_DENIED\020\027\022\031\n\025REQUEST_NEEDS_" +
      "SINK_ID\020\030\022\031\n\025INVALID_MAX_HOP_COUNT\020\031"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
