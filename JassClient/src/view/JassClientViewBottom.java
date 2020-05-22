package view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JassClientViewBottom extends HBox{
	
	private Button obeAbe, undeUfe, trumpf;
	public Button getObeAbe() {
		return obeAbe;
	}


	public void setObeAbe(Button obeAbe) {
		this.obeAbe = obeAbe;
	}


	public Button getTrumpf() {
		return trumpf;
	}


	public void setTrumpf(Button trumpf) {
		this.trumpf = trumpf;
	}


	public Button getRose() {
		return rose;
	}


	public void setRose(Button rose) {
		this.rose = rose;
	}


	public Button getSchilte() {
		return schilte;
	}


	public void setSchilte(Button schilte) {
		this.schilte = schilte;
	}


	public Button getEichle() {
		return eichle;
	}


	public void setEichle(Button eichle) {
		this.eichle = eichle;
	}


	public Button getSchaelle() {
		return schaelle;
	}


	public void setSchaelle(Button schaelle) {
		this.schaelle = schaelle;
	}


	public Button getUndeUfe() {
		return undeUfe;
	}


	public void setUndeUfe(Button undeUfe) {
		this.undeUfe = undeUfe;
	}


	private Button rose, schilte, eichle, schaelle;
	
	
	public JassClientViewBottom() {
		
		obeAbe = new Button("obeAbe");
		undeUfe = new Button("undeUfe");
		trumpf = new Button("trumpf");
		rose = new Button("Rose");
		schilte = new Button("Schilte");
		eichle = new Button("Eichle");
		schaelle = new Button("Schaelle");
		
		obeAbe.setDisable(true);
		undeUfe.setDisable(true);
		trumpf.setDisable(true);
		rose.setDisable(true);
		schilte.setDisable(true);
		eichle.setDisable(true);
		schaelle.setDisable(true);
		
		HBox ruleBox = new HBox();
		VBox suitBox = new VBox();
		
		this.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());	
		obeAbe.setId("bottomButton");
		undeUfe.setId("bottomButton");
		trumpf.setId("bottomButton");
		
		rose.setId("bottomButtonSuit");
		schilte.setId("bottomButtonSuit");
		eichle.setId("bottomButtonSuit");
		schaelle.setId("bottomButtonSuit");
		
		this.setAlignment(Pos.CENTER);
		ruleBox.setAlignment(Pos.CENTER_LEFT);
		suitBox.setAlignment(Pos.CENTER_LEFT);
		
		this.setPadding(new Insets(10, 10, 10, 10));
		ruleBox.setPadding(new Insets(10, 10, 10, 10));
		suitBox.setPadding(new Insets(10, 10, 10, 10));
		
		ruleBox.getChildren().addAll(obeAbe, undeUfe, trumpf);
		suitBox.getChildren().addAll(rose,schilte,eichle,schaelle);
		
		this.getChildren().add(ruleBox);
		this.getChildren().add(suitBox);

		
	}
	
	

}
