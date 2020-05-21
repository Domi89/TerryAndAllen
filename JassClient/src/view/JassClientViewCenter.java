package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
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
	private JassClientViewCenterTisch tisch;
	
	public JassClientViewCenterTisch getTisch() {
		return tisch;
	}

	public void setTisch(JassClientViewCenterTisch tisch) {
		this.tisch = tisch;
	}

	public JassClientViewPlayerCard getJcwpc() {
		return jcwpc;
	}

	public void setJcwpc(JassClientViewPlayerCard jcwpc) {
		this.jcwpc = jcwpc;
	}

	public JassClientViewCenter() {
		super();
		
		
		jcvv = new JassClientViewVBoxCard();
		jcvv2 = new JassClientViewVBoxCard();
		jcvh = new JassClientViewHBoxCard();
		jcwpc = new JassClientViewPlayerCard();
		tisch= new JassClientViewCenterTisch();
		
	
		
		jcwpc.setMinSize(900, 150);
		jcwpc.setMaxSize(900, 150);
		jcvh.setMinSize(900, 150);
		jcvh.setMaxSize(900, 150);
		
		jcvv.setMinSize(150, 600);
		jcvv.setMaxSize(150, 600);
		jcvv2.setMinSize(150, 600);
		jcvv2.setMaxSize(150, 600);
		
				
		this.setCenter(tisch);
		this.setLeft(jcvv);
		jcvv.setAlignment(Pos.CENTER);
		this.setRight(jcvv2);
		jcvv2.setAlignment(Pos.CENTER);
		this.setTop(jcvh);
		jcvh.setAlignment(Pos.CENTER);
		this.setBottom(jcwpc);
		jcwpc.setAlignment(Pos.CENTER);		
		
		
		
	}

		public HBox getHbox() {
			return this.hb;
		}
		
		public void setTisch() {
			//hb.setBackground(background.);
			hb.setBackground(Background.EMPTY);
			
		}
		
		
}

	
	