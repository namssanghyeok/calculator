package spartar.caculator;

import spartar.helper.InputParser;

import java.util.ArrayDeque;

/**
 * 공통 로직 담는 추상 클래스.
 * 결과 저장 관련 로직 담고있음
 */
public abstract class AbstractCalculator implements Calculator {
    private final ArrayDeque<Double> resultStore;
    private final InputParser inputParser;

    protected AbstractCalculator(InputParser inputParser) {
        this.resultStore = new ArrayDeque<>();
        this.inputParser = inputParser;
    }

    @Override
    public void saveResult(Double result) {
        if (resultStore.size() < 10) {
            resultStore.addLast(result);
            return;
        }
        String parse = inputParser.parse("가장 먼저 저장된 연산 결과 삭제하시겠습니까? (remove 입력 시 삭제)", String::new);
        if (!"remove".equals(parse)) {
            return;
        }
        this.removeResult();
        resultStore.addLast(result);
    }


    @Override
    public void removeResult() {
        this.resultStore.removeFirst();
    }

    @Override
    public void inquiryResult() {
        if (resultStore.isEmpty()) {
            System.out.println("계산 결과가 없습니다.");
        }
        for (Double number : this.resultStore) {
            System.out.println(number);
        }
    }
}
