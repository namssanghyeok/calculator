package spartar.caculator.operator;

import spartar.constants.OperatorType;

public class ModOperator implements Operator{
    @Override
    public boolean supports(OperatorType op) {
        return OperatorType.MOD.equals(op);
    }

    @Override
    public Double operate(Double operand, Double otherOperand) {
        return operand % otherOperand;
    }
}
