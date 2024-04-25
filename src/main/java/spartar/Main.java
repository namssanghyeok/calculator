package spartar;

import spartar.caculator.ArithmeticCalculator;
import spartar.caculator.Calculator;
import spartar.caculator.CircleCalculator;
import spartar.constants.CalculatorType;
import spartar.exceptions.BadCalculatorTypeException;
import spartar.helper.InputParser;

import java.util.List; import java.util.Scanner;

public class Main {
/*
    public static String handleCommand(Scanner sc, String msg) {
        String EXIT_COMMAND = "exit";
        String INQUIRE_COMMAND = "inquire";

        System.out.print(msg);
        String input = sc.nextLine().trim();
        if (INQUIRE_COMMAND.equals(input)) {

        } else if (EXIT_COMMAND.equals(input)) {
            System.exit(0);
        }
        return "zzz";
    }
*/


    public static Calculator selectCalculator(Scanner sc, List<Calculator> calculators) {
        while (true) {
            try {
                System.out.println("계산기 선택 - 1, 2 중 선택");
                System.out.println("1: 사칙연산");
                System.out.println("2: 원 넓이 계산");
                int choice = Integer.parseInt(sc.nextLine().trim());
                sc.skip("");
                return calculators
                        .stream()
                        .filter(cal ->
                                cal.supports(CalculatorType.fromType(choice))
                        )
                        .findAny()
                        .orElseThrow(BadCalculatorTypeException::new);
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    System.out.println("1과 2 중 선택해주세요.");
                    continue;
                }
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        InputParser inputParser = new InputParser(sc);

        Calculator arithmaticCalculator = new ArithmeticCalculator(inputParser);
        Calculator circleCalculator = new CircleCalculator(inputParser);

        List<Calculator> calculators = List.of(arithmaticCalculator, circleCalculator);

        while (true) {
            Calculator calculator = selectCalculator(sc, calculators);
            calculator.calculate();
        }
    }
}