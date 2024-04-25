package spartar.constants;

import spartar.exceptions.BadOperatorException;

public enum OperatorType {
    PLUS("+"),
    MINUS("-"),
    MULTIPLY("*"),
    DIVIDE("/"),
    MODE("%");

    private final String value;

    OperatorType(String value) {
        this.value = value;
    }

    public static OperatorType getOperatorTypeByValue(String v)
            throws BadOperatorException {
        for (OperatorType operator : OperatorType.values()) {
            if (operator.value.equals(v)) {
                return operator;
            }
        }
        throw new BadOperatorException();
    }
}
