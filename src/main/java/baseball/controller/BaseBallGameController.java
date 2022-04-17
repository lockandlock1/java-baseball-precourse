package baseball.controller;

import baseball.model.BaseBallGameJudgment;
import baseball.service.BaseBallGameService;

public class BaseBallGameController {

    private final BaseBallGameService baseBallGameService = new BaseBallGameService();

    public String createAnswer() {
        return baseBallGameService.createAnswer();
    }

    public BaseBallGameJudgment requestJudge(String input, String answer) {
        return baseBallGameService.requestJudge(input, answer);
    }

    public boolean requestGameProgress(BaseBallGameJudgment baseBallGameJudgment) {
        return baseBallGameService.requestGameProgress(baseBallGameJudgment);
    }
}
