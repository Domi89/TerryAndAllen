package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class JassClientViewCenter extends BorderPane{

	//Instanzieren der Label gewonnen
	private Label winLabel1, winLabel2, winLabel3, winLabel4;
	private Label namePlayer1, namePlayer2, namePlayer3, namePlayer4;

	private JassClientViewVBoxCard jcvv;
			
	public JassClientViewCenter() {
		super();
		
		//Button test = new Button("Wuhuuuu biatch");
		
		jcvv = new JassClientViewVBoxCard();
		
		HBox hb = new HBox();
		hb.setId("tisch");
	
		hb.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
		//hb.getChildren().add(test);
		
		this.setCenter(hb);
		this.setLeft(jcvv);
				
		
		
		
	}

	
	












}
