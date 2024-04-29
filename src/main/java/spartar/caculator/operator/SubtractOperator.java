package spartar.caculator.operator;

public class SubtractOperator implements Operator{
    @Override
    public boolean supports(OperatorType op) {
        return OperatorType.SUBTRACT.equals(op);
    }

    @Override
    public Double operate(Double operand, Double otherOperand) {
        return operand - otherOperand;
    }
}
