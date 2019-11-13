package domain;

public class Player {
    private String name;
    private Score score;
    private boolean isAanDeBeurt;


    public Player() {
        this.name = "Unknown Player";
        this.score = new Score();
    }

    public Player(String name) {
        setName(name);
        setScore(new Score());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        } else {
            this.name = name;
        }
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        if (score == null) {
            throw new IllegalArgumentException("Oei je hebt een lege score toegevoegd");
        } else {
            this.score = score;
        }
    }

    public void setAanDeBeurt(boolean aanDeBeurt) {
        isAanDeBeurt = aanDeBeurt;
    }

    public boolean isAanDeBeurt() {
        return isAanDeBeurt;
    }
}
