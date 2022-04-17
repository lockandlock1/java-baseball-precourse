package baseball.view;

import baseball.validator.InputStringValidator;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BASE_BALL_GAME_INPUT = "숫자를 입력해주세요 : ";
    private static final String BASE_BALL_GAME_CONTINUE_ASK = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 ";
    private static final String WRONG_INPUT_ERROR_MESSAGE = "값을 잘못 입력하였습니다";
    private static final int BASE_BALL_GAME_CONTINUE = 1;
    private static final int BASE_BALL_GAME_END = 2;
    private static final int BASE_BALL_GAME_NUMBER_DIGIT = 3;
    private static final int BASE_BALL_GAME_CONTINUE_DIGIT = 1;

    public static String enterNumber() {
        System.out.println(BASE_BALL_GAME_INPUT);

        return InputStringValidator.valid(Console.readLine(), BASE_BALL_GAME_NUMBER_DIGIT);
    }

    public static boolean enterGameContinuity() {
        System.out.println(BASE_BALL_GAME_CONTINUE_ASK);

        int input = Integer.parseInt(InputStringValidator.valid(Console.readLine(), BASE_BALL_GAME_CONTINUE_DIGIT));

        return checkEnterInput(input);
    }

    private static boolean checkEnterInput(int value) {
        if(value > BASE_BALL_GAME_END) {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
        }
        return value == BASE_BALL_GAME_CONTINUE;
    }
}
