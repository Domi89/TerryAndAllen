package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.JassClientModel;

public class JassClientView {
	
	private JassClientModel model;
	private Scene scene;
	
	//Instanziieren der verschiedenen Behälter
	private BorderPane root;
	private HBox hbox;
	private JassClientViewMenBar menBar;
	private JassClientViewChat chat;
	private JassClientViewCenter center;
	private JassClientViewScore score;
	
	public JassClientModel getModel() {
		return model;
	}

	
	//Instanziieren der Buttons
	private Button chatButton;
	private Button trumpfEichle, trumpfSchaele, trumpfRose, trumpSchilte;
	
	//Textfields 
	private TextField chatField;
	
	//Labels 
	private Label messageLabel;
		
	public JassClientView(Stage stage, JassClientModel model) {
		this.model = model;
		
		/*
	 messageLabel = new Label();
		messageLabel.setPrefSize(300,300);
	
		 */
		this.chatField = new TextField();
		this.chatButton = new Button("send");
		
		
		//Initial labels and buttons
		menBar = new JassClientViewMenBar();
		score = new JassClientViewScore();
		chat = new JassClientViewChat();
		center = new JassClientViewCenter();
		
		
		
		//Draft HBox
		hbox= new HBox();
		hbox.getChildren().add(chatField);
		hbox.getChildren().add(chatButton);
		
	
		
		//Setzten der Behälter in die BorderPane
		this.root = new BorderPane();
		
		this.score.setPadding(new Insets(10, 10, 10, 10));
		this.chat.setPadding(new Insets(10, 10, 10, 10));

		VBox rightBox = new VBox();
		rightBox.getChildren().addAll(this.chat, this.score);
		
		this.root.setId("background");
		this.root.getStylesheets().addAll(this.getClass().getResource("style.css").toExternalForm());	
		
		this.root.setTop(menBar);
		
		
		this.root.setRight(rightBox);
		this.root.setCenter(center);
		
		JassClientViewBottom bottomView = new JassClientViewBottom();
		
		
		this.root.setBottom(bottomView);
		
		bottomView.setStyle("-fx-border-color: black;  -fx-border-width: 2px;");
		
		//Grösse der root definieren
		this.root.setMinSize(1280, 800);
		this.root.setMaxSize(1280, 1200);
		
		//Erstellen und anzeigen der Scene
		this.scene = new Scene(this.root);
		
	
		Image icon = new Image(getClass().getResourceAsStream("../images/Schelle.png"));
		
		stage.setTitle("Jass Spiel");
		stage.getIcons().add(icon);
		stage.setScene(this.scene);
		stage.show();
		
	}

		
	public Button getButton() {
		return chatButton;
	}

	public void setButton(Button button) {
		this.chatButton = button;
	}

	public TextField getTextField() {
		return chatField;
	}

	public void setTextField(TextField textField) {
		this.chatField = textField;
	}

	public Label getMessageLabel() {
		return messageLabel;
	}

	public void setMessageLabel(Label messageLabel) {
		this.messageLabel = messageLabel;
	}

	public MenuItem getColourChange() {
		return menBar.farbeWechseln;
	}
	




//Hier mit dem Switch auf den obigen HBOX zugreifen.... 
	// es liegt am Zugriff an die HBox
	public void changeTable() {
		
		//init
		JassClientViewFarbeWechseln i = new JassClientViewFarbeWechseln();
		int in = i.colourChange();
			
		switch(in) {
			case 0:
				
				//root.getStylesheets().addAll(this.getClass().getResource("style2.css").toExternalForm());
				//center.getHbox().setId("tisch2");
				//center.setTisch();
				
				break;
			case 1:
				//center.hb.setId("tisch1");
				
				break;
			case 2:
				// 
				
				break;
			}

			
	}


	public void setModel(JassClientModel model) {
		this.model = model;
	}

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}

	public HBox getHbox() {
		return hbox;
	}

	public void setHbox(HBox hbox) {
		this.hbox = hbox;
	}

	public JassClientViewMenBar getMenBar() {
		return menBar;
	}

	public void setMenBar(JassClientViewMenBar menBar) {
		this.menBar = menBar;
	}

	public JassClientViewCenter getCenter() {
		return center;
	}

	public void setCenter(JassClientViewCenter center) {
		this.center = center;
	}

	public Button getChatButton() {
		return chatButton;
	}

	public void setChatButton(Button chatButton) {
		this.chatButton = chatButton;
	}

	public Button getTrumpfEichle() {
		return trumpfEichle;
	}

	public void setTrumpfEichle(Button trumpfEichle) {
		this.trumpfEichle = trumpfEichle;
	}

	public Button getTrumpfSchaele() {
		return trumpfSchaele;
	}

	public void setTrumpfSchaele(Button trumpfSchaele) {
		this.trumpfSchaele = trumpfSchaele;
	}

	public Button getTrumpfRose() {
		return trumpfRose;
	}

	public void setTrumpfRose(Button trumpfRose) {
		this.trumpfRose = trumpfRose;
	}

	public Button getTrumpSchilte() {
		return trumpSchilte;
	}

	public void setTrumpSchilte(Button trumpSchilte) {
		this.trumpSchilte = trumpSchilte;
	}

	public TextField getChatField() {
		return chatField;
	}

	public void setChatField(TextField chatField) {
		this.chatField = chatField;
	}

	public JassClientViewChat getChat() {
		return chat;
	}

	public void setChat(JassClientViewChat chat) {
		this.chat = chat;
	}

	

}
