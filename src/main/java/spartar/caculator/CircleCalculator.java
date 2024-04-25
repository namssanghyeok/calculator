package spartar.caculator;

import spartar.constants.CalculatorType;
import spartar.helper.InputParser;

public class CircleCalculator implements Calculator {
    private final InputParser parser;

    public CircleCalculator(InputParser parser) {
        this.parser = parser;
    }

    @Override
    public Number calculate() {
        double radius = parser.parse("반지름: ", Double::parseDouble);
        return radius * radius * Math.PI;
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
