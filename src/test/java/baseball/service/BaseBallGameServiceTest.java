package baseball.service;

import baseball.model.BaseBallGameJudgment;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


class BaseBallGameServiceTest {

    BaseBallGameService baseBallGameService = new BaseBallGameService();

    static final int INPUT_LENGTH = 3;


    @DisplayName("컴퓨터 정답 생성 기능 테스트")
    @RepeatedTest(3)
    void createAnswerTest() {
        String input = baseBallGameService.createAnswer();

        assertThat(input.length()).isEqualTo(INPUT_LENGTH);

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < input.length(); i++) {
            check(set, input.charAt(i));
        }

    }

    public void check(Set<Character> set, char value) {
        if (!set.add(value)) {
            Assertions.fail("컴퓨터 정답 기능 오류");
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {"321"})
    void requestJudgeTest(String input) {
        String answer = "345";

        BaseBallGameJudgment result = baseBallGameService.requestJudge(input, answer);


        assertThat(result.getStrike()).isEqualTo(1);
        assertThat(result.getBall()).isEqualTo(0);
    }


    @DisplayName("야구 게임 종료 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"321,true", "345,false"})
    void requestGameProcessTest(String input, boolean answer) {
        String number = "345";

        BaseBallGameJudgment baseBallGameJudgment = baseBallGameService.requestJudge(input, number);

        boolean result = baseBallGameService.requestGameProgress(baseBallGameJudgment);

        assertThat(result).isEqualTo(answer);
    }

}