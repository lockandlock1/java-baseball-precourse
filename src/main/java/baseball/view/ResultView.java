package baseball.view;

import baseball.model.BaseBallGameJudgment;

public class ResultView {

    private static final int GAME_END_CONDITION = 3;
    private static final int STRIKE_DEFAULT_VALUE = 0;
    private static final int BALL_DEFAULT_VALUE = 0;

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String GAME_END_SENTENCE = "\n3개의 숫자를 모두 맞히셨습니다!게임 종료";

    public static void printResult(BaseBallGameJudgment baseBallGameJudgment) {
        int strikeCount = baseBallGameJudgment.getStrike();
        if(baseBallGameJudgment.isNothing()) {
            System.out.println(NOTHING);

            return;
        }

        makeStrikeSentence(strikeCount,
                makeBallSentence(baseBallGameJudgment.getBall()));
    }

    private static String makeBallSentence(int ballCount) {
        StringBuilder stringBuilder = new StringBuilder("");
        if(ballCount > BALL_DEFAULT_VALUE) {
            stringBuilder.append(ballCount);
            stringBuilder.append(BALL);
            stringBuilder.append(" ");
        }


        return stringBuilder.toString();
    }

    private static void makeStrikeSentence(int strikeCount, String ballSentence) {
        StringBuilder stringBuilder = new StringBuilder(ballSentence);


        if(strikeCount > STRIKE_DEFAULT_VALUE) {
            stringBuilder.append(strikeCount);
            stringBuilder.append(STRIKE);
        }

        if(strikeCount == GAME_END_CONDITION) {
            stringBuilder.append(GAME_END_SENTENCE);
        }

        System.out.println(stringBuilder.toString());
    }



}
