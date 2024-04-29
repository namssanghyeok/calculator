package spartar.exceptions;

import java.util.List;

public class BadOperatorException extends RuntimeException{
    public BadOperatorException(String operators) {
        super(String.format("연산자는 %s 만 가능합니다.", operators));
    }
}
