package spartar.caculator;

import spartar.constants.CalculatorType;
import spartar.constants.OperatorType;

public interface Calculator {
    Number calculate();
    boolean supports(CalculatorType calculatorType);
    Number show();
}
