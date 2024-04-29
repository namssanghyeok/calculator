package spartar.caculator.operator;

public interface Operator {
    boolean supports(OperatorType op);
    Double operate(Double operand, Double otherOperand);
}
