package view;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class JassClientViewChat extends VBox{
	
	private Label labelChat = new Label();
	private TextField chatField = new TextField ("Nachricht hier eingeben");
	private Button sendButton = new Button("Senden");
	
	
	public JassClientViewChat() {
		super();
		
		labelChat.setMinSize(200.0, 100.0);
		labelChat.setStyle("-fx-font-size: 20px ; -fx-text-fill: black; -fx-background-color: grey"); 
		
		
		HBox bottom = new HBox();
		bottom.getChildren().addAll(chatField, sendButton);
		
		
		this.getChildren().addAll(labelChat, bottom);		
		
	}
	

	public Label getLabelChat() {
		return labelChat;
	}


	public void setLabelChat(Label labelChat) {
		this.labelChat = labelChat;
	}


	public TextField getChatField() {
		return chatField;
	}


	public void setChatField(TextField chatField) {
		this.chatField = chatField;
	}


	public Button getSendButton() {
		return sendButton;
	}


	public void setSend(Button sendButton) {
		this.sendButton = sendButton;
	}


	
		
			
		

}


