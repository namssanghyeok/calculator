package spartar.exceptions;

public class BadOperatorException extends RuntimeException{
    public BadOperatorException() {
        super("연산자는 +, -, *, / 만 가능합니다.");
    }
}
