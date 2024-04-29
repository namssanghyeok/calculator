package spartar.caculator.operator;

import spartar.exceptions.BadOperatorException;

public enum OperatorType {
    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MOD("%");

    private final String value;

    OperatorType(String value) {
        this.value = value;
    }

    public static OperatorType fromValue(String v)
            throws BadOperatorException {
        for (OperatorType operator : OperatorType.values()) {
            if (operator.value.equals(v)) {
                return operator;
            }
        }
        throw new BadOperatorException();
    }
}
