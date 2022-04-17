package baseball.service;

import baseball.model.BaseBallGameJudgment;
import baseball.utils.Utils;

public class BaseBallGameService {

    private final int STRING_LENGTH = 3;


    public String createAnswer() {
        return Utils.answerNumberGenerate(STRING_LENGTH);
    }

    public BaseBallGameJudgment requestJudge(String input, String answer) {
        return judge(input, answer);
    }

    private BaseBallGameJudgment judge(String input, String answer) {
        int strikeCnt = 0;
        int ballCnt = 0;
        for (int i = 0; i < STRING_LENGTH; i++) {
            for (int j = 0; j < STRING_LENGTH; j++) {
                if ((input.charAt(i) == answer.charAt(j))) {
                    if(i == j) {
                        strikeCnt++;
                        continue;
                    }

                    ballCnt++;
                }
            }
        }

        return new BaseBallGameJudgment(strikeCnt, ballCnt);
    }

    public boolean requestGameProgress(BaseBallGameJudgment baseBallGameJudgment) {
        return !(baseBallGameJudgment.getStrike() == STRING_LENGTH);
    }
}
