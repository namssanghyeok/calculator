package spartar.caculator;

/**
 * Calculator 인터페이스.
 */
public interface Calculator {
    Double calculate();
    boolean supports(CalculatorType calculatorType);
    // 저장된 결과 출력
    void inquiryResult();
    void removeResult();
    void saveResult(Double result);
}
