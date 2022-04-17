package baseball.utils;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class Utils {

    private static final int DIGIT = 10;

    public static String answerNumberGenerate(int size) {
        Set<Integer> numbers = new HashSet<>();

        int value = 0;
        while (numbers.size() == size) {
            if(numbers.add(value)) {
                value += calculate(Randoms.pickNumberInRange(1, 9), size - numbers.size());
            }
        }

        return Integer.toString(value);

    }



    private static int calculate(int number, int power) {

        return  (int)Math.pow(DIGIT, power) * number;
    }


}
