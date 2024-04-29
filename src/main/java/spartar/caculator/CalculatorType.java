package spartar.caculator;

import spartar.exceptions.BadCalculatorTypeException;

public enum CalculatorType {
    ARITHMETIC(1),
    CIRCLE(2);

    private final int type;

    CalculatorType(int type) {
        this.type = type;
    }

    public static CalculatorType fromType(int type) {
        for (CalculatorType calculatorType : CalculatorType.values()) {
            if (calculatorType.type == type) {
                return calculatorType;
            }
        }
        throw new BadCalculatorTypeException();
    }
}
