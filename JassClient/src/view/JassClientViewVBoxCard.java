package view;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class JassClientViewVBoxCard extends VBox{
	
	public JassClientViewVBoxCard() {
		super();
		
		Label card = new Label("Test");		
		card.setMinSize(200, 100);
		
		this.getChildren().add(card);		
		
		
		
	}
	
	
	
	
	

}
