package spartar.caculator;

import spartar.constants.CalculatorType;

public class ArithmeticCalculator implements Calculator {
    @Override
    public Number calculate() {
        return 10;
    }

    @Override
    public boolean supports(CalculatorType calculatorType) {
        return CalculatorType.ARITHMETIC.equals(calculatorType);
    }

    @Override
    public Number show() {
        return null;
    }


}
