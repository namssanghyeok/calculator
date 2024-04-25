package spartar.constants;

public enum CommandType {
    DEFAULT,
    EXIT,
    INQUIRY;

    public static CommandType fromString(String string) {
        for (CommandType commandType : CommandType.values()) {
            if (commandType.name().equals(string.toUpperCase())) {
                return commandType;
            }
        }
        return DEFAULT;
    }
}
