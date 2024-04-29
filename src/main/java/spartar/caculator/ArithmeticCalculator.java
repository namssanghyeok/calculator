package spartar.caculator;

import spartar.caculator.operator.Operator;
import spartar.caculator.operator.OperatorType;
import spartar.helper.InputParser;

import java.util.List;

/**
 * 사칙연산 계산기.
 * supports 로 지원하는 계산기 타입인지 확인.
 * 생성자를 통해 List<Operator> 를 받는다.
 */
public class ArithmeticCalculator extends AbstractCalculator {
    private final InputParser parser;
    private final List<Operator> operators;

    public ArithmeticCalculator(InputParser parser, List<Operator> operators) {
        super(parser);
        this.parser = parser;
        this.operators = operators;
    }

    @Override
    public Double calculate() {
        Double operand = parser.parse("첫 번째 숫자를 입력해주세요: ", Double::parseDouble);

        Double otherOperand = parser.parse("두 번째 숫자를 입력해주세요: ", Double::parseDouble);
        OperatorType operatorType = parser.parse("사칙연산 기호를 입력하세요: ", OperatorType::fromValue);

        Operator currentOperator = operators.get(0);
        for (Operator operator : this.operators) {
            if(operator.supports(operatorType)) {
                currentOperator = operator;
                break;
            }
        }
        return currentOperator.operate(operand, otherOperand);
    }

    @Override
    public boolean supports(CalculatorType calculatorType) {
        return CalculatorType.ARITHMETIC.equals(calculatorType);
    }
}
