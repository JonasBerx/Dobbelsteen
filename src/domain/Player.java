package domain;

public class Player {
    private Integer playerId;
    private String name;
    private boolean isCurrent;

    public Player(Integer playerId,String name){
        this.playerId = playerId;
        this.name = name;
        this.isCurrent = false;
    }

    public boolean isCurrent(){
        return this.isCurrent;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrent(boolean current) {
        isCurrent = current;
    }

    public String toString(){
        return this.playerId + " " + this.name;
    }
}