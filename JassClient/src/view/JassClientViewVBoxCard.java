package view;

import java.io.FileInputStream;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class JassClientViewVBoxCard extends VBox{
	
	public JassClientViewVBoxCard() {
		super();
		
		String imageUrl1 = "/images/backOfCard.jpg";
		String imageUrl2 = "/images/backOfCard.jpg";
		String imageUrl3 = "/images/backOfCard.jpg";
		String imageUrl4 = "/images/backOfCard.jpg";
		
		Image image1 = new Image(imageUrl1, 100, 150, false, true);
		Image image2 = new Image(imageUrl2, 100, 150, false, true);
		Image image3 = new Image(imageUrl3, 100, 150, false, true);
		Image image4 = new Image(imageUrl4, 100, 150, false, true);
		
        ImageView imageView1 = new ImageView(image1);	
        ImageView imageView2 = new ImageView(image2);
        ImageView imageView3 = new ImageView(image3);
        ImageView imageView4 = new ImageView(image4);
        
        this.getChildren().addAll(imageView1,imageView2,imageView3,imageView4);
        
//		 String imageUrl = "https://docs.oracle.com/javafx/javafx/images/javafx-documentation.png";
//	        Image image = new Image(imageUrl,160,60,false,true);
		//Image beispiel = new Image(this.getClass().getClassLoader().getResourceAsStream("/images/eichel0$.gif"));
	
		
		
		
		//this.getChildren().add(test);	
		
		
		
	}
	
	
	
	
	

}
