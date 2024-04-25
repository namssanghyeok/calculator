package spartar.caculator;

import spartar.constants.CalculatorType;
import spartar.constants.OperatorType;

import java.util.Scanner;

public class ArithmeticCalculator implements Calculator {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Number calculate() {
        Integer operand = parseNumberOrOperator(this.scanner, "첫 번째 숫자를 입력해주세요: ", Integer::parseInt);
        Integer otherOperand = parseNumberOrOperator(this.scanner, "두 번째 숫자를 입력해주세요: ", Integer::parseInt);
        OperatorType operatorType = parseNumberOrOperator(this.scanner, "사칙연산을: ", OperatorType::fromValue);
        System.out.printf("%d %s %d\n", operand, operatorType, otherOperand);
        return 10;
    }

    @Override
    public boolean supports(CalculatorType calculatorType) {
        return CalculatorType.ARITHMETIC.equals(calculatorType);
    }

    @Override
    public Number show() {
        return null;
    }


    public static <T> T parseNumberOrOperator(Scanner sc, String msg, Parser<T> parser) {
        while (true) {
            try {
                System.out.print(msg);
                String input = sc.nextLine().trim();
                return parser.parse(input);
            } catch (RuntimeException e) {
                if (e instanceof NumberFormatException) {
                    System.out.println("올바르지 않은 숫자입니다.");
                    continue;
                }
                System.out.println("Message: " + e.getMessage());
                System.out.println("Cause: " + e.getCause());
            }
        }
    }

    public interface Parser<T> {
        T parse(String input);
    }
}
