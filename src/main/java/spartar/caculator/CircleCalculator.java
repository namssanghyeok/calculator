package spartar.caculator;

import spartar.constants.CalculatorType;
import spartar.constants.OperatorType;

public class CircleCalculator implements Calculator {
    @Override
    public Number calculate() {
        // 반지름을 전달 받고, 원의 넓이를 계산하고 반환
        return 0;
    }

    @Override
    public boolean supports(CalculatorType calculatorType) {
        return CalculatorType.CIRCLE.equals(calculatorType);
    }

    @Override
    public Number show() {
        return null;
    }

}
