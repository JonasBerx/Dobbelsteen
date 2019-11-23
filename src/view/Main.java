package view;

import domain.EventType;
import domain.Game;
import domain.Player;
import domain.PlayerFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		ScoreView sc = new ScoreView();
		Game game = new Game();
		PlayerFactory p = new PlayerFactory();
		game.addPlayer(p.createPlayer(1, "Dieter"));
		game.addPlayer(p.createPlayer(2, "Pieter"));
		game.addPlayer(p.createPlayer(3, "Jonas"));

		PlayerView pv1 = new PlayerView(3, game);
		PlayerView pv2 = new PlayerView(2, game);
		PlayerView pv3 = new PlayerView(1, game);
		pv1.isCurrentPlayer(true);
		game.addObserver(EventType.PLAYERVIEW, pv1);
		game.addObserver(EventType.PLAYERVIEW, pv2);
		game.addObserver(EventType.PLAYERVIEW, pv3);
		game.addObserver(EventType.SCOREVIEW, sc);


	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
