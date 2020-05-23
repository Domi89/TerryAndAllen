package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class JassClientViewHBoxCard extends HBox{
	
	
	public JassClientViewHBoxCard() {
		super();

						
		for (int i = 0; i < 4; i++) {
			String cardNr = "imageUrl"+i;
			createCard(cardNr);	
			}
		
		}

		
		private void createCard(String cardNr) {
			cardNr = "/images/backOfCardVert.jpg";
			Image image = new Image(cardNr,100,150,false,false); 
			//Image image = new Image(cardNr); 
			ImageView imageView = new ImageView(image);	
			
			this.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());			
			imageView.setId("backCard");
			
				
			this.getChildren().addAll(imageView);
		} 
	
		

}
