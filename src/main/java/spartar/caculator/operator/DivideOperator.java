package spartar.caculator.operator;

import spartar.constants.OperatorType;

public class DivideOperator implements Operator{
    @Override
    public boolean supports(OperatorType op) {
        return OperatorType.DIVIDE.equals(op);
    }

    @Override
    public Double operate(Double operand, Double otherOperand) {
        return operand / otherOperand;
    }
}
