package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
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

        for(int i  = 0 ; i < input.length(); i++) {
            check(set, input.charAt(i));
        }

    }

    public void check(Set<Character> set, char value) {
        if(!set.add(value)) {
            Assertions.fail("컴퓨터 정답 기능 오류");
        }
    }



}