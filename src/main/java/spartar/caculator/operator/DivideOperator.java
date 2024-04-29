package spartar.caculator.operator;

public class DivideOperator implements Operator{
    private final OperatorType supportOperatorType = OperatorType.DIVIDE;

    @Override
    public boolean supports(OperatorType op) {
        return this.supportOperatorType.equals(op);
    }

    @Override
    public Double operate(Double operand, Double otherOperand) {
        return operand / otherOperand;
    }
}
