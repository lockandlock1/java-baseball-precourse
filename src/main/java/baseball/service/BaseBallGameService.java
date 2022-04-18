package baseball.service;

import baseball.model.BaseBallGameJudgment;
import baseball.utils.Utils;

public class BaseBallGameService {

    private final int STRING_LENGTH = 3;

    public String createAnswer() {
        return Utils.generateAnswerNumber(STRING_LENGTH);
    }

    public BaseBallGameJudgment requestJudge(String input, String answer) {
        return judge(input, answer);
    }

    private BaseBallGameJudgment judge(String input, String answer) {

        return new BaseBallGameJudgment(countStrike(input, answer), countBall(input, answer));
    }

    private int countStrike(String input, String answer) {
        int strikeCnt = 0;
        for (int inputIdx = 0; inputIdx < STRING_LENGTH; inputIdx++) {
            strikeCnt += checkStrikeAnswer(input, answer, inputIdx);
        }

        return strikeCnt;
    }

    private int checkStrikeAnswer(String input, String answer, int inputIdx) {
        int strikeCount = 0;
        for (int answerIdx = 0; answerIdx < STRING_LENGTH; answerIdx++) {
            strikeCount += checkStrike(input.charAt(inputIdx), answer.charAt(answerIdx), inputIdx, answerIdx);
        }

        return strikeCount;
    }

    private int checkStrike(char input, char answer, int inputIdx, int answerIdx) {
        return input == answer && inputIdx == answerIdx ? 1 : 0;
    }

    private int countBall(String input, String answer) {
        int ballCnt = 0;
        for (int inputIdx = 0; inputIdx < STRING_LENGTH; inputIdx++) {
            ballCnt += checkBallAnswer(input, answer, inputIdx);
        }

        return ballCnt;
    }

    private int checkBallAnswer(String input, String answer, int inputIdx) {
        int ballCount = 0;
        for (int answerIdx = 0; answerIdx < STRING_LENGTH; answerIdx++) {
            ballCount += checkBall(input.charAt(inputIdx), answer.charAt(answerIdx), inputIdx, answerIdx);
        }

        return ballCount;
    }

    private int checkBall(char input, char answer, int inputIdx, int answerIdx) {
        return input == answer && inputIdx != answerIdx ? 1 : 0;
    }


    public boolean requestGameProgress(BaseBallGameJudgment baseBallGameJudgment) {
        return !(baseBallGameJudgment.getStrike() == STRING_LENGTH);
    }
}
