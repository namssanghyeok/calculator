package spartar.caculator.operator;

import spartar.constants.OperatorType;

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
