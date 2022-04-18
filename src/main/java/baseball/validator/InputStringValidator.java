package baseball.validator;


import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputStringValidator {

    private static final Pattern onlyNumberPattern = Pattern.compile("^[0-9]*?");
    private static final String WRONG_INPUT_ERROR_MESSAGE = "잘못된 입력값 입니다";
    private static final int DIGIT = 3;

    public static String valid(String input, int value) {
        if(input.length() > value) {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
        }


        Matcher matcher = onlyNumberPattern.matcher(input);

        if(matcher.find()) {
            return checkDifferentDigit(input);
        }

        throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
    }

    private static String checkDifferentDigit(String input) {
        Set<Character> numbers = new HashSet<>();

        for(int i = 0; i < DIGIT; i++) {
            check(numbers, input.charAt(i));
        }

        return input;
    }

    private static void check(Set<Character> numbers, char input) {
        if(!numbers.add(input)) {
            throw new IllegalArgumentException(WRONG_INPUT_ERROR_MESSAGE);
        }
    }

}
