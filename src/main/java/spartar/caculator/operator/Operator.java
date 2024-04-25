package spartar.caculator.operator;

import spartar.constants.OperatorType;

public interface Operator {
    boolean supports(OperatorType op);
    Double operate(Double operand, Double otherOperand);
}
