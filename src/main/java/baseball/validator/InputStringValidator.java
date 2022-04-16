package baseball.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringValidator {

    private static final Pattern onlyNumberPattern = Pattern.compile("^[0-9]*?");
    private static final String WRONG_INPUT_ERROR_MESSAGE = "잘못된 입력값 입니다";
    private static final int DIGIT = 3;

    public static String valid(String input) {
        Matcher matcher = onlyNumberPattern.matcher(input);

        if(matcher.find() && input.length() == DIGIT) {
            return checkPositive(input);
        }

        throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
    }

    private static String checkPositive(String input) {
        int number = Integer.parseInt(input);

        if(number < 0) {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
        }

        return input;

    }
}
