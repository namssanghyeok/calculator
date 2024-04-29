package spartar.caculator.operator;

public class SubtractOperator implements Operator{
    private final OperatorType supportOperatorType = OperatorType.SUBTRACT;

    @Override
    public boolean supports(OperatorType op) {
        return this.supportOperatorType.equals(op);
    }

    @Override
    public Double operate(Double operand, Double otherOperand) {
        return operand - otherOperand;
    }
}
