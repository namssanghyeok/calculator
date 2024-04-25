package spartar.caculator;

import spartar.constants.CalculatorType;

public interface Calculator {
    Double calculate();
    boolean supports(CalculatorType calculatorType);
    void inquiryResult();
    void removeResult();
    void saveResult(Double result);
}
