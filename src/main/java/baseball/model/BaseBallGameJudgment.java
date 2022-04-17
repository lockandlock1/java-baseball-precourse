package baseball.model;

public class BaseBallGameJudgment {

    private final int strike;
    private final int ball;

    public BaseBallGameJudgment(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }
}
