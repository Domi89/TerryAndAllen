package view;

import java.util.ArrayList;

import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Connection;

public class JassClientViewCenterTischName extends VBox{
	
	Label gameMode = new Label("De Gw�nner isch...");
	
	public Label getGameMode() {
		return gameMode;
	}

	public void setGameMode(Label gameMode) {
		this.gameMode = gameMode;
	}
	
	

	JassClientViewCenterTischName(){
		
		
		this.getChildren().add(gameMode);
		
		this.setAlignment(Pos.CENTER);
		this.gameMode.setId("gwuenner");
		this.gameMode.setVisible(false);
		this.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());		
	}
	

}
