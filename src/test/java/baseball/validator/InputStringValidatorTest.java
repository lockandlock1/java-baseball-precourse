package baseball.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

class InputStringValidatorTest {

    private static final int DIGIT = 3;
    private static final String WRONG_INPUT_ERROR_MESSAGE = "잘못된 입력값 입니다";

    @ParameterizedTest
    @DisplayName("입력값 내용 오류 기능 테스트")
    @ValueSource(strings = {"199", "*:!!", "23~", "-189", "222"})

    void validTest(String input) {
        assertThatThrownBy(() -> {
            InputStringValidator.valid(input, DIGIT);
        }).hasMessageContaining(WRONG_INPUT_ERROR_MESSAGE);
    }
}