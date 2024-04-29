package spartar.caculator.operator;

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
