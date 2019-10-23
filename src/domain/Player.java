package domain;

public class Player {
    private String name;
    private Score score;
    private Dice dice;


    public Player() {
        this.name = "Unknown Player";
        this.score = new Score();
        this.dice = new Dice();
    }

    public Player(String name) {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        }
        this.name = name;
        this.score = new Score();
        this.dice = new Dice();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }
}
