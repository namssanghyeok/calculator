package spartar.caculator.operator;

/**
 * Operator 인터페이스.
 * supports를 통해 지원하는 연산자 타입인지 확인
 * operate를 통해 계산
 */
public interface Operator {
    boolean supports(OperatorType op);
    Double operate(Double operand, Double otherOperand);
}
