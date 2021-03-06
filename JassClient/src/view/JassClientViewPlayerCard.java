package view;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import serializedClasses.Card;

public class JassClientViewPlayerCard extends HBox{
	
	public JassClientViewPlayerCard() {
		super();

				/*	
		for (int i = 0; i < 9; i++) {
			String cardNr = "/images/eichel"+ i +"$.gif";
			createCard(cardNr);	
			}
				
				*/
		
		}

		
		private void createCard(String cardNr) {
			
			Image image = new Image(cardNr,100,150,false,false); 
			ImageView imageView = new ImageView(image);	
			this.getChildren().addAll(imageView);
		} 
		
		public void newDeckReceived(ObservableList<Card> cards) {
			
			this.getChildren().clear();
			for (Card c: cards) {
				
				
				String suit = c.getSuit().name();
				String rank = c.getRank().name();
				
				String cardNr ="/images/"+suit+" "+rank+".gif";
				System.out.println("CARDNUMMER:"+cardNr+"ENDE");
				createCard(cardNr);		
				
			}
			
		}
		

	
	

}
