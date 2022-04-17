package baseball;

import baseball.controller.BaseBallGameController;
import baseball.model.BaseBallGameJudgment;
import baseball.view.InputView;
import baseball.view.ResultView;

public class Application {
    public static void main(String[] args) {
        BaseBallGameController baseBallGameController = new BaseBallGameController();

        boolean isProgramContinue = true;
        while (isProgramContinue) {
            startGame(baseBallGameController, baseBallGameController.createAnswer());

            isProgramContinue = InputView.enterGameContinuity();
        }



    }

    private static void startGame(BaseBallGameController baseBallGameController, String answer) {
        boolean isGameContinue = true;
        while(isGameContinue) {
            String input = InputView.enterNumber();

            BaseBallGameJudgment baseBallGameJudgment = baseBallGameController.requestJudge(input, answer);

            ResultView.printResult(baseBallGameJudgment);

            isGameContinue = baseBallGameController.requestGameProgress(baseBallGameJudgment);
        }
    }


}
