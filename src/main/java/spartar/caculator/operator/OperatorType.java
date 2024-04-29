package spartar.caculator.operator;

import spartar.exceptions.BadOperatorException;

import java.util.Arrays;

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
        throw new BadOperatorException(
                String.join(", ", Arrays.stream(OperatorType.values()).map(value -> value.value).toList())
        );
    }
}
