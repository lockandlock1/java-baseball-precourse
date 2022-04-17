package baseball.utils;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Utils {

    private static final int DIGIT = 10;

    public static String answerNumberGenerate(int size) {
        Set<Integer> numbers = new HashSet<>();

        int value = 0;

        boolean isContinue = true;
        while (isContinue) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (numbers.add(randomNumber)) {
                value += calculate(randomNumber, size - numbers.size());
            }

            if (numbers.size() == size) {
                isContinue = false;
            }
        }

        return Integer.toString(value);

    }


    private static int calculate(int number, int power) {

        return (int) Math.pow(DIGIT, power) * number;
    }


}
