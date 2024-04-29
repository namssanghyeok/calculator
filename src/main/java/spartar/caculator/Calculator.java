package spartar.caculator;

public interface Calculator {
    Double calculate();
    boolean supports(CalculatorType calculatorType);
    void inquiryResult();
    void removeResult();
    void saveResult(Double result);
}
