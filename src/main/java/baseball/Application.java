package baseball;


import baseball.controller.BaseBallGameController;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        BaseBallGameController baseBallGameController = new BaseBallGameController(Integer.toString(Randoms.pickNumberInRange(100, 999)));

        while (true) {
            String input = InputView.enterNumber();


        }



    }
}
