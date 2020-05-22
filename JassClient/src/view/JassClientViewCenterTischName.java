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
	
	Label gameMode = new Label("GAME MODE");
	
	public Label getGameMode() {
		return gameMode;
	}

	public void setGameMode(Label gameMode) {
		this.gameMode = gameMode;
	}

	JassClientViewCenterTischName(){
		
		this.getChildren().add(gameMode);
		
		this.setAlignment(Pos.CENTER);
		
		/*
		if (Connection.getPlayersCount()==2) {
			this.add(imageViews.get(0), 1, 2);
			this.add(imageViews.get(2), 1, 0);
			this.setVgap(80);
			this.setAlignment(Pos.CENTER);
		}
		*/
		
		/*
		if (Connection.getPlayersCount()==4) {
				
			this.add(imageViews.get(2), 1, 0);
			this.add(imageViews.get(3), 0, 1);
			this.add(imageViews.get(0), 1, 2);
			this.add(imageViews.get(1), 2, 1);
			
			this.setVgap(25);
			this.setHgap(75);
			this.setAlignment(Pos.CENTER);
		}
		*/
		
		
	}
	

}
