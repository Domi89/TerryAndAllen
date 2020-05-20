package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class JassClientViewCenter extends BorderPane{

	//Instanzieren der Label gewonnen
	private Label winLabel1, winLabel2, winLabel3, winLabel4;
	private Label namePlayer1, namePlayer2, namePlayer3, namePlayer4;

	private HBox hb;
	
	private JassClientViewVBoxCard jcvv, jcvv2;
	private JassClientViewHBoxCard jcvh;
	private JassClientViewPlayerCard jcwpc;
			
	public JassClientViewCenter() {
		super();
		
		
		jcvv = new JassClientViewVBoxCard();
		jcvv2 = new JassClientViewVBoxCard();
		jcvh = new JassClientViewHBoxCard();
		jcwpc = new JassClientViewPlayerCard();
		
		HBox hb = new HBox();
		hb.setId("tisch0");
		hb.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
				
		this.setCenter(hb);
		this.setLeft(jcvv);
		jcvv.setAlignment(Pos.CENTER);
		this.setRight(jcvv2);
		jcvv2.setAlignment(Pos.CENTER);
		this.setTop(jcvh);
		jcvh.setAlignment(Pos.CENTER);
		this.setBottom(jcwpc);
		jcwpc.setAlignment(Pos.CENTER);		
		
		
		
	}

	
	//Hier mit dem Switch auf den obigen HBOX zugreifen.... 
	public static void changeCSS() {
		
		int i = JassClientViewFarbeWechseln.colourChoice;
			
		switch(i) {
			
			case 0:
				this.hb.setId("tisch0");
				this.hb.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());
				
				
			}

		
	}
		
		
		
	}

	
	