package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class JassClientViewHBoxCard extends HBox{
	
	public JassClientViewHBoxCard() {
		super();

						
		for (int i = 0; i < 8; i++) {
			String cardNr = "imageUrl"+i;
			createCard(cardNr);	
			}
		
		String firstCard = "/images/backOfCard.jpg";
		Image firstC = new Image(firstCard, 100, 150, false, true); 
		ImageView imFiVie = new ImageView(firstC);	
		this.getChildren().add(imFiVie);	
		
		
		}

		

	private void createCard(String cardNr) {
		cardNr = "/images/backOfCardKlein.jpg";
		Image image = new Image(cardNr, 50, 150, false, true); 
		ImageView imageView = new ImageView(image);	
		this.getChildren().addAll(imageView);

		} 
	
		

}
