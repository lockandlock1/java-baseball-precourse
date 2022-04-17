package baseball.view;

import baseball.model.BaseBallGameJudgment;

public class ResultView {

    private static final int GAME_END_CONDITION = 3;

    private static final boolean GAME_CONTINUE = true;
    private static final boolean GAME_END = false;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static StringBuilder stringBuilder;

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
        if(ballCount > 0) {
            stringBuilder.append(ballCount);
            stringBuilder.append(BALL);
        }


        return stringBuilder.toString();
    }

    private static void makeStrikeSentence(int strikeCount, String ballSentence) {
        StringBuilder stringBuilder = new StringBuilder(ballSentence);
        if(strikeCount > 0) {
            stringBuilder.append(strikeCount);
            stringBuilder.append(STRIKE);
        }

        System.out.println(stringBuilder.toString());
    }



}
