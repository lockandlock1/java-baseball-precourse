package baseball.controller;

import baseball.model.BaseBallGameJudgment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class BaseBallGameControllerTest {

    private static final BaseBallGameController baseballGameController = new BaseBallGameController();
    private static final int INPUT_LENGTH = 3;


    @Test
    @DisplayName("컴퓨터 정답 생성 기능 테스트")
    void createAnswerTest() {
        String input = baseballGameController.createAnswer();

        assertThat(input.length()).isEqualTo(INPUT_LENGTH);

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            check(set, input.charAt(i));
        }
    }

    private void check(Set<Character> set, char value) {
        if (!set.add(value)) {
            Assertions.fail("컴퓨터 정답 기능 오류");
        }
    }

    @ParameterizedTest
    @DisplayName("야구 게임 판정 테스트")
    @CsvSource(value = {"321, 1, 0", "347, 2, 0", "231, 0, 1", "431, 0, 2", "127, 0 ,0"})
    void requestJudgeTest(String input, int strikeCount, int ballCount) {
        String answer = "345";

        BaseBallGameJudgment result = baseballGameController.requestJudge(input, answer);


        assertThat(result.getStrike()).isEqualTo(strikeCount);
        assertThat(result.getBall()).isEqualTo(ballCount);
    }

    @DisplayName("야구 게임 종료 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"321,true", "345,false"})
    void requestGameProcessTest(String input, boolean answer) {
        String number = "345";

        BaseBallGameJudgment baseBallGameJudgment = baseballGameController.requestJudge(input, number);

        boolean result = baseballGameController.requestGameProgress(baseBallGameJudgment);

        assertThat(result).isEqualTo(answer);
    }
}