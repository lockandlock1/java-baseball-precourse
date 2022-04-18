package baseball.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

class UtilsTest {
    static final int OUTPUT_LENGTH = 3;

    @Test
    @DisplayName("컴퓨터 정답 만들기 생성 문자 길이 테스트")
    void answerNumberGenerateLengthTest() {
        String result = Utils.generateAnswerNumber(OUTPUT_LENGTH);
        assertThat(result.length()).isEqualTo(OUTPUT_LENGTH);
        assertThat(Integer.parseInt(result)).isGreaterThanOrEqualTo(100).isLessThanOrEqualTo(999);
    }

    @Test
    @DisplayName("컴퓨터 정답 만들기 생성 문자열 범위 테스트")
    void answerNumberGenerateRangeTest() {
        String result = Utils.generateAnswerNumber(OUTPUT_LENGTH);

        assertThat(Integer.parseInt(result)).isGreaterThanOrEqualTo(100).isLessThanOrEqualTo(999);
    }

    @Test
    @DisplayName("컴퓨터 정답 만들기 생성 문자열 동일 문자 존재 여부 테스트")
    void answerNumberGenerateSameCharacterTest() {
        String result = Utils.generateAnswerNumber(OUTPUT_LENGTH);

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < result.length(); i++) {
            check(set, result.charAt(i));
        }
    }

    public void check(Set<Character> set, char value) {
        if (!set.add(value)) {
            fail("컴퓨터 정답 만들기 생성 문자열 동일 문자 존재");
        }
    }
}