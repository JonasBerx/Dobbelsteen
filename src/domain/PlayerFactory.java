package domain;

public class PlayerFactory {
    public PlayerFactory() {

    }

    public Player createPlayer(int playerId, String name) {
        return new Player(playerId,name);
    }

}
