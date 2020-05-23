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
	private VBox vBox0, vBox1, vBox2,vBox3;
	
	
	public ArrayList<Label> getPlayerNames() {
		return playerNames;
	}


	public void setPlayerNames(ArrayList<Label> playerNames) {
		this.playerNames = playerNames;
	}


	JassClientViewCenterTisch(){
		
		this.setId("tisch0");
		this.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());	
		
		
		images.add(new Image("/images/backOfCard0.jpg",100,150,false,false)); 
		images.add(new Image("/images/backOfCard0.jpg",100,150,false,false)); 
		images.add(new Image("/images/backOfCard0.jpg",100,150,false,false)); 
		images.add(new Image("/images/backOfCard0.jpg",100,150,false,false)); 

		imageViews.add(new ImageView(images.get(0)));
		imageViews.add(new ImageView(images.get(1)));
		imageViews.add(new ImageView(images.get(2)));
		imageViews.add(new ImageView(images.get(3)));

		
		if (Connection.getPlayersCount()==2) {
			
			for(int i = 0; i<Connection.getPlayersCount(); i++) {
				playerNames.add(new Label("Player "+i));
			}
			
			this.vBox0 = new VBox();
			this.vBox2 = new VBox();
			
			this.vBox0.getChildren().addAll(imageViews.get(0), playerNames.get(0));
			this.vBox2.getChildren().addAll(imageViews.get(2), playerNames.get(1));
			
			this.vBox0.setAlignment(Pos.CENTER);
			this.vBox2.setAlignment(Pos.CENTER);
			

			this.add(vBox0, 1, 2);
			this.add(vBox2, 1, 0);
			this.setVgap(70);
			this.setAlignment(Pos.CENTER);
		}
		

		
		
		if (Connection.getPlayersCount()==4) {
				
			

			this.vBox2 = new VBox();
			this.vBox3 = new VBox();
			this.vBox0 = new VBox();
			this.vBox1 = new VBox();
			
			for(int i = 0; i<Connection.getPlayersCount(); i++) {
				playerNames.add(new Label("Player "+i));
			}
			
			this.vBox0.getChildren().addAll(imageViews.get(0), playerNames.get(0));
			this.vBox1.getChildren().addAll(imageViews.get(1), playerNames.get(1));
			this.vBox2.getChildren().addAll(imageViews.get(2), playerNames.get(2));
			this.vBox3.getChildren().addAll(imageViews.get(3), playerNames.get(3));
			
			
			
			this.vBox0.setAlignment(Pos.CENTER);
			this.vBox1.setAlignment(Pos.CENTER);
			this.vBox2.setAlignment(Pos.CENTER);
			this.vBox3.setAlignment(Pos.CENTER);
			
			
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
				this.vBox0.getChildren().remove(0);
				this.vBox0.getChildren().add(0, imageViews.get(position));
				break;
				
			case 1: 
				this.vBox1.getChildren().remove(0);
				this.vBox1.getChildren().add(0, imageViews.get(position));
				break;	
			case 2: 
				this.vBox2.getChildren().remove(0);
				this.vBox2.getChildren().add(0, imageViews.get(position));
				break;
			case 3: 

				this.vBox3.getChildren().remove(0);
				this.vBox3.getChildren().add(0, imageViews.get(position));
				break;
			}
			
		}
	
		if (Connection.getPlayersCount()==2) {
			switch (position) {
			case 0: 
				this.vBox0.getChildren().remove(0);
				this.vBox0.getChildren().add(0, imageViews.get(position));
		
				
			//	this.add(imageViews.get(position), 1, 2);
				break;
				
			case 1: 
				this.vBox2.getChildren().remove(0);
				this.vBox2.getChildren().add(0, imageViews.get(position));
				//this.add(imageViews.get(position), 1, 0);
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
	
	public int getPosition(String clientName) {
		int position = -1;
		
		for (int i = 0; i<playerNames.size();i++) {
			if(playerNames.get(i).getText().equals(clientName)) {
				position = i;
			}
		}
		return position;
	}
	
	
	public void resetTisch() {
		
		for (int i = 0; i<Connection.getPlayersCount();i++) {
			addCard(i, "/images/backOfCard0.jpg");
		}
	
	}

}
