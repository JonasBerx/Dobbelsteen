import domain.DobbelSpel;
import javafx.application.Application;
import javafx.stage.Stage;
import view.PlayerView;
import view.ScoreView;

import java.util.ArrayList;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		new ScoreView();
		PlayerView pv1 = new PlayerView("Dietr", 1);
		PlayerView pv2 = new PlayerView("Pieter", 2);
		PlayerView pv3 = new PlayerView("Jonas", 3);

		pv1.isAanBeurt(true);

	}

	public static void main(String[] args) {
		launch(args);
	}
}
