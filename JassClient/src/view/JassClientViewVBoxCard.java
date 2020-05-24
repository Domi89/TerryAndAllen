package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class JassClientViewVBoxCard extends VBox{
	
	public JassClientViewVBoxCard() {
		super();
		
				
		for (int i = 0; i < 9; i++) {
			String cardNr = "imageUrl"+i;
			createCard(cardNr);	
			}

		String firstCard = "/images/backOfCardVertikal.jpg";
		Image firstC = new Image(firstCard, 150, 100, false, true); 
		ImageView imFiVie = new ImageView(firstC);	
		this.getChildren().add(imFiVie);	
	
	
	}

		private void createCard(String cardNr) {

			cardNr = "/images/backOfCardVertikal2.jpg";
			Image image = new Image(cardNr, 150, 50, false, true); 
			ImageView imageView = new ImageView(image);	
			this.getChildren().addAll(imageView);
			
			
		} 
	
		

}
