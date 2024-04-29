package spartar.caculator.operator;

public class MultiplyOperator implements Operator{
    @Override
    public boolean supports(OperatorType op) {
        return OperatorType.MULTIPLY.equals(op);
    }

    @Override
    public Double operate(Double operand, Double otherOperand) {
        return operand * otherOperand;
    }
}
