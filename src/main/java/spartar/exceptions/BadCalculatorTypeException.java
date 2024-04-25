package spartar.exceptions;

public class BadCalculatorTypeException extends RuntimeException {
    public BadCalculatorTypeException() {
        super("1, 2 중 선택해주세요");
    }
}
