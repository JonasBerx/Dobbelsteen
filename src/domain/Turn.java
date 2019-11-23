package domain;

public class Turn {
    private Player player;
    private int dice1, dice2, previousScore, score;

    public Turn(Player p, int dice1, int dice2, int previousScore) {
        this.player = p;
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.previousScore = previousScore;
        calculateScore();
    }

    public void calculateScore() {
        score = dice1 + dice2;
        if (dice1 == dice2) {
            score *= 2;
        }
        if (previousScore == score) {
            score += 5;
        }
    }

    public int getScore() {
        return score;
    }

    public String toString() {
        return this.player.toString() + " " + dice1 + " + " + dice2;
    }
}
