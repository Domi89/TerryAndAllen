package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JassClientViewScore extends VBox{
	
	//private ScrollPane labelChat = new ScrollPane();
	private Label scoreLabel = new Label();
	
	
	public Label getScoreLabel() {
		return scoreLabel;
	}


	public void setScoreLabel(Label scoreLabel) {
		this.scoreLabel = scoreLabel;
	}
	
	


	private Label titelLabel = new Label("SCORE TAFEL");


	public JassClientViewScore() {
		super();
		this.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
		scoreLabel.setMinSize(200.0, 100.0);
		scoreLabel.setId("scoreLabel");
		titelLabel.setId("scoreLabelTitel");
		titelLabel.setAlignment(Pos.CENTER);
		this.setSpacing(10);
		this.getChildren().add(titelLabel);
		this.getChildren().add(scoreLabel);	
		
		
	}

			
		

}


