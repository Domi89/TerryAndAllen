package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
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
	
	//Instanziieren der Buttons
	private Button chatButton;
	private Button trumpfEichle, trumpfSchaele, trumpfRose, trumpSchilte;
	
	//Textfields 
	private TextField chatField;
	
	//Labels 
	private Label messageLabel;
	private Label winLabel1, winLabel2, winLabel3, winLabel4;
	
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
		chat = new JassClientViewChat();
		
		//Draft HBox
		hbox= new HBox();
		hbox.getChildren().add(chatField);
		hbox.getChildren().add(chatButton);
		
		//Setzten der Behälter in die BorderPane
		this.root = new BorderPane();
	
		this.root.setTop(menBar);
		this.root.setRight(chat);
		this.root.setCenter(hbox);
		
		//Grösse der root definieren
		this.root.setMinSize(1280, 800);
		this.root.setMaxSize(1280, 1200);
		
		//Erstellen und anzeigen der Scene
		this.scene = new Scene(this.root);
		stage.setTitle("Jass Spiel");
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
	

}
