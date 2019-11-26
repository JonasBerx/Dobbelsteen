package view;

import domain.Game;
import domain.Observer;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PlayerView implements Observer {
	private Stage stage = new Stage();
	private Scene playerScene;
	private Label diceLabel;
	private Button playButton;
	private Label messageLabel;
	private Game game;

	private int playerid;


	public PlayerView(int playerid, Game game){
		this.playerid = playerid;
		this.game = game;
		diceLabel = new Label("turn 1: ");
		playButton = new Button("throw dice");
		playButton.setOnAction(new ThrowDicesHandler());
		playButton.setDisable(true);
		messageLabel = new Label("game not yet started");
		layoutComponents();
		stage.setScene(playerScene);
		stage.setTitle("Player "+playerid);
		stage.setResizable(false);
		stage.setX(100+(playerid-1) * 350);
		stage.setY(200);
		stage.show();
	}

	private void layoutComponents() {
		VBox root = new VBox(10);
		playerScene = new Scene(root,250,100);
		root.getChildren().add(playButton);
		root.getChildren().add(diceLabel);
		root.getChildren().add(messageLabel);
	}

	public void isCurrentPlayer(boolean turn){
		playButton.setDisable(!turn);
	}

	public void setMessageLabel(String text){
		this.messageLabel.setText(text);
	}

	@Override
	public void update(String s) {
		if (!game.getCurrentPlayer().equals(this.game.getPlayers().get(this.playerid))) {
			setMessageLabel(s);
			isCurrentPlayer(game.getPlayers().get(this.playerid).isCurrent());
		}else{
			this.diceLabel.setText("Turn: " + game.getTurnNumber());
			setMessageLabel(String.valueOf(this.game.getPlayers().get(this.playerid)));
		}
	}

	class ThrowDicesHandler implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent event) {
			game.step(playerid);
			isCurrentPlayer(false);
			game.getPlayers().get(playerid).setCurrent(false);
		}
	}
}