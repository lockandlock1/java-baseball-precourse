package baseball.view;

import baseball.validator.InputStringValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String CAR_NUMBER_QUESTION = "숫자를 입력해주세요 : ";

    public static String enterNumber() {
        System.out.println(CAR_NUMBER_QUESTION);

        return InputStringValidator.valid(Console.readLine());
    }
}
