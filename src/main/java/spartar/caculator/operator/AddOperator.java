package spartar.caculator.operator;

public class AddOperator implements Operator {
    @Override
    public boolean supports(OperatorType op) {
        return OperatorType.ADD.equals(op);
    }

    @Override
    public Double operate(Double operand, Double otherOperand) {
        return operand + otherOperand;
    }
}
