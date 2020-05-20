package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class JassClientViewVBoxCard extends VBox{
	
	public JassClientViewVBoxCard() {
		super();
		
		for (int i = 0; i < 4; i++) {
			String cardNr = "imageUrl"+i;
			createCard(cardNr);	
			}
		}

		private void createCard(String cardNr) {
			cardNr = "/images/backOfCard.jpg";
			Image image = new Image(cardNr, 100, 150, false, true); 
			ImageView imageView = new ImageView(image);	
			this.getChildren().addAll(imageView);
		} 
	

}
