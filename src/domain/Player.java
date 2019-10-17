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


}
