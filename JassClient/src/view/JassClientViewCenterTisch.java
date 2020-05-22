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

public class JassClientViewCenterTisch extends GridPane{
	
	private ArrayList<Image> images = new ArrayList<Image>();
	private ArrayList<ImageView> imageViews = new ArrayList<ImageView>();
	private ArrayList<Label> playerNames = new ArrayList<Label>();
	
	
	
	public ArrayList<Label> getPlayerNames() {
		return playerNames;
	}


	public void setPlayerNames(ArrayList<Label> playerNames) {
		this.playerNames = playerNames;
	}


	JassClientViewCenterTisch(){
		
		this.setId("tisch0");
		this.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());	
	
		/*
		String cardNr = "/images/Eichle Acht.gif";
		Image image = new Image(cardNr,100,150,false,false); 
		ImageView imageView = new ImageView(image);	
		Image image2 = new Image("/images/Schaelle Acht.gif",100,150,false,false); 
		Image image3 = new Image("/images/Schilte Acht.gif",100,150,false,false); 
		Image image4 = new Image("/images/Karte.gif",100,150,false,false); 
		ImageView imageView2 = new ImageView(image2);	
		ImageView imageView3 = new ImageView(image3);	
		ImageView imageView4 = new ImageView(image4);	
		*/
		
		
	
		
		
		images.add(new Image("/images/backOfCard0.jpg",100,150,false,false)); 
		images.add(new Image("/images/backOfCard0.jpg",100,150,false,false)); 
		images.add(new Image("/images/backOfCard0.jpg",100,150,false,false)); 
		images.add(new Image("/images/backOfCard0.jpg",100,150,false,false)); 

		imageViews.add(new ImageView(images.get(0)));
		imageViews.add(new ImageView(images.get(1)));
		imageViews.add(new ImageView(images.get(2)));
		imageViews.add(new ImageView(images.get(3)));

		
		/*
		labels.add(new Label("label0"));
		labels.add(new Label("label1"));
		labels.add(new Label("label2"));
		labels.add(new Label("label3"));
		*/
		
		if (Connection.getPlayersCount()==2) {
			
			for(int i = 0; i<Connection.getPlayersCount(); i++) {
				playerNames.add(new Label("Player "+i));
			}
			
			VBox vBox0 = new VBox();
			VBox vBox2 = new VBox();
			
			vBox0.getChildren().addAll(imageViews.get(0), playerNames.get(0));
			vBox2.getChildren().addAll(imageViews.get(2), playerNames.get(1));
			
			vBox0.setAlignment(Pos.CENTER);
			vBox2.setAlignment(Pos.CENTER);
			
			this.add(vBox0, 1, 2);
			this.add(vBox2, 1, 0);
			this.setVgap(70);
			this.setAlignment(Pos.CENTER);
		}
		

		
		
		if (Connection.getPlayersCount()==4) {
				
			

			VBox vBox2 = new VBox();
			VBox vBox3 = new VBox();
			VBox vBox0 = new VBox();
			VBox vBox1 = new VBox();
			
			for(int i = 0; i<Connection.getPlayersCount(); i++) {
				playerNames.add(new Label("Player "+i));
			}
			
			vBox0.getChildren().addAll(imageViews.get(0), playerNames.get(0));
			vBox1.getChildren().addAll(imageViews.get(1), playerNames.get(1));
			vBox2.getChildren().addAll(imageViews.get(2), playerNames.get(2));
			vBox3.getChildren().addAll(imageViews.get(3), playerNames.get(3));
			
			
			
			vBox0.setAlignment(Pos.CENTER);
			vBox1.setAlignment(Pos.CENTER);
			vBox2.setAlignment(Pos.CENTER);
			vBox3.setAlignment(Pos.CENTER);
			
			
			this.add(vBox2, 1, 0);
			this.add(vBox3, 0, 1);
			this.add(vBox0, 1, 2);
			this.add(vBox1, 2, 1);
			
			
			this.setHgap(60);
			this.setAlignment(Pos.CENTER);
			
		}
		JassClientViewCenterTischName playerNames = new JassClientViewCenterTischName();
		this.add(playerNames, 1, 1);
		
	}
	
	
	public void addCard(int position, String cardNr) {
		Image image = new Image(cardNr,100,150,false,false); 
		ImageView imageView = new ImageView(image);	
		imageViews.set(position, imageView);
		
		
		if (Connection.getPlayersCount()==4) {
			switch (position) {
			case 0: 
				this.add(imageViews.get(position), 1, 2);
				break;
				
			case 1: 

				this.add(imageViews.get(position), 2, 1);
				break;	
			case 2: 

				this.add(imageViews.get(position), 1, 0);
				break;
			case 3: 

				this.add(imageViews.get(position), 0, 1);
				break;
			}
			
		}
	
		if (Connection.getPlayersCount()==2) {
			switch (position) {
			case 0: 
				this.add(imageViews.get(position), 1, 2);
				break;
				
			case 1: 

				this.add(imageViews.get(position), 1, 0);
				break;
			}
			
		}
				
	}
	
	
	public void addCard(int position, ImageView imageView) {

		ImageView imageView1 = imageView;	
		imageViews.set(position, imageView);
		
		
		if (Connection.getPlayersCount()==4) {
			switch (position) {
			case 0: 
				this.add(imageViews.get(position), 1, 2);
				break;
				
			case 1: 

				this.add(imageViews.get(position), 2, 1);
				break;	
			case 2: 

				this.add(imageViews.get(position), 1, 0);
				break;
			case 3: 

				this.add(imageViews.get(position), 0, 1);
				break;
			}
			
		}
	
		if (Connection.getPlayersCount()==2) {
			switch (position) {
			case 0: 
				this.add(imageViews.get(position), 1, 2);
				break;
				
			case 1: 

				this.add(imageViews.get(position), 1, 0);
				break;
			}
			
		}
				
	}
	
	
	public void resetTisch() {
		
		for (int i = 0; i<Connection.getPlayersCount();i++) {
			addCard(i, "/images/backOfCard0.jpg");
		}
	
	}

}
