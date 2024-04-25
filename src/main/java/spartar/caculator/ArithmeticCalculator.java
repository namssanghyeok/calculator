package spartar.caculator;

import spartar.constants.CalculatorType;
import spartar.constants.OperatorType;
import spartar.helper.InputParser;

public class ArithmeticCalculator implements Calculator {
    private final InputParser parser;

    public ArithmeticCalculator(InputParser parser) {
        this.parser = parser;
    }

    @Override
    public Number calculate() {
        Integer operand = parser.parse("첫 번째 숫자를 입력해주세요: ", Integer::parseInt);

        Integer otherOperand = parser.parse("두 번째 숫자를 입력해주세요: ", Integer::parseInt);
        OperatorType operatorType = parser.parse("사칙연산을: ", OperatorType::fromValue);
        System.out.printf("%d %s %d\n", operand, operatorType, otherOperand);
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
