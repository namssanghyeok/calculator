package spartar.caculator;

import spartar.helper.InputParser;

public class CircleCalculator extends AbstractCalculator {
    private final InputParser parser;

    public CircleCalculator(InputParser parser) {
        super(parser);
        this.parser = parser;
    }

    @Override
    public Double calculate() {
        double radius = parser.parse("반지름: ", Double::parseDouble);
        return radius * radius * Math.PI;
    }

    @Override
    public boolean supports(CalculatorType calculatorType) {
        return CalculatorType.CIRCLE.equals(calculatorType);
    }

    @Override
    public void inquiryResult() {

    }
}
