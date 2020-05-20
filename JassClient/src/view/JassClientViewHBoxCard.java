package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class JassClientViewHBoxCard extends HBox{
	
	
	public JassClientViewHBoxCard() {
		super();

		this.setMinSize(800, 200);
		this.setMaxSize(801, 201);
		
		for (int i = 0; i < 4; i++) {
			String cardNr = "imageUrl"+i;
			createCard(cardNr);	
			}
		
		//	this.setId("backCard");
		//this.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
		
		}

	
	
		private void createCard(String cardNr) {
			cardNr = "/images/backOfCard.jpg";
			Image image = new Image(cardNr,100,150,false,false); 
			//Image image = new Image(cardNr); 
			ImageView imageView = new ImageView(image);	
			
			imageView.setId("backCard");
			this.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
				
			this.getChildren().addAll(imageView);
		} 
	
		

}
