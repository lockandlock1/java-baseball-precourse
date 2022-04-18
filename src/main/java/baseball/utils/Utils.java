package baseball.utils;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;


public class Utils {

    private static final int DIGIT = 10;
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 9;

    public static String generateAnswerNumber(int size) {
        Set<Integer> numbers = checkDuplicate(size);

        return Integer.toString(generateNumber(numbers));
    }

    private static Set<Integer> checkDuplicate(int size) {
        Set<Integer> numbers = new HashSet<>();

        boolean isContinue = true;
        while (isContinue) {
            numbers.add(Randoms.pickNumberInRange(START_NUMBER, END_NUMBER));
            isContinue = checkContinue(numbers.size(), size);
        }

        return numbers;
    }

    private static int generateNumber(Set<Integer> numbers){
        int value = 0;

        int digit = 1;
        for (Integer number : numbers) {
            value += (int) Math.pow(DIGIT, numbers.size() - digit) * number;
            digit++;
        }

        return value;
    }

    private static boolean checkContinue(int size, int numberLength) {
        return !(size == numberLength);
    }

}
