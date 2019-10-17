package domain;

public class Score implements Observer {
    private int point;

    Score() {
        this.point = 0;
    }

    private int addScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("Score smaller than 0");
        }
        point += score;
        return point;
    }


    @Override
    public void update(Player player, Score score) {
        addScore(score.point);
    }
}
