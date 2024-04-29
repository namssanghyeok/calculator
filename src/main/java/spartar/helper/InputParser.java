package spartar.helper;

import java.util.Scanner;

/**
 * 입력 공통 처리 클래스
 * 올바르지 않은 입력이 들어온 경우 무한반복
 */
public class InputParser {
    private final Scanner sc;

    public InputParser(Scanner sc) {
        this.sc = sc;
    }

    public <T> T parse(String msg, Parser<T> parser) {
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
                System.out.println(e.getMessage());
            }
        }
    }

    public interface Parser<T> {
        T parse(String input);
    }
}
