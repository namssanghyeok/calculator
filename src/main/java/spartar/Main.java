package spartar;

import spartar.caculator.ArithmeticCalculator;
import spartar.caculator.Calculator;
import spartar.caculator.CircleCalculator;
import spartar.caculator.operator.*;
import spartar.caculator.CalculatorType;
import spartar.exceptions.BadCalculatorTypeException;
import spartar.helper.InputParser;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
            프로그램에 필요한 계산기 및 연산자 생성 & 등록
         */
        Scanner sc = new Scanner(System.in);

        InputParser inputParser = new InputParser(sc);

        Calculator arithmaticCalculator = new ArithmeticCalculator(
                inputParser,
                List.of(
                        new AddOperator(),
                        new SubtractOperator(),
                        new MultiplyOperator(),
                        new DivideOperator(),
                        new ModOperator()
                ));
        Calculator circleCalculator = new CircleCalculator(inputParser);

        List<Calculator> calculators = List.of(arithmaticCalculator, circleCalculator);
        /*
            프로그램 실행
         */
        Runner runner = new Runner(inputParser, calculators);

        while (true) {
            // 계산기 선택
            Calculator calculator = runner.selectCalculator(sc);
            Double result = calculator.calculate();
            // 결과 출력 & 저장
            System.out.println(result);
            calculator.saveResult(result);
            // 다음 동작 선택.
            runner.chooseNextCommand(calculator);
        }
    }

    public static class Runner {
        private final InputParser inputParser;
        private final List<Calculator> calculators;

        public Runner(InputParser inputParser, List<Calculator> calculators) {
            this.inputParser = inputParser;
            this.calculators = calculators;
        }

        public void chooseNextCommand(Calculator currentCalculator) {
            CommandType command = CommandType.fromString(inputParser.parse("""
                    명령어 입력 (exit, inquiry, continue)
                    """, String::new).toUpperCase());
            switch (command) {
                case EXIT -> handleExit();
                case INQUIRY -> handleInquiry(currentCalculator);
            }
        }

        private void handleExit() {
            System.exit(0);
        }

        private void handleInquiry(Calculator calculator) {
            calculator.inquiryResult();
        }


        public Calculator selectCalculator(Scanner sc) {
            while (true) {
                try {
                    System.out.println("""
                            계산기 선택  1, 2 중 선택
                            1: 사칙연산
                            2: 원 넓이 계산
                            """);
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
                    // 에러 메시지 출력
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    // 커맨드 타입.
    public enum CommandType {
        DEFAULT,
        EXIT,
        INQUIRY;

        public static CommandType fromString(String string) {
            for (CommandType commandType : CommandType.values()) {
                if (commandType.name().equals(string.toUpperCase())) {
                    return commandType;
                }
            }
            return DEFAULT;
        }
    }
}