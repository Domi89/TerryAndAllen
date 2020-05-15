package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.JassClientModel;

public class JassClientView {
	
	private JassClientModel model;
	private Scene scene;
	private BorderPane root;
	private HBox hbox;
	private Button button;
	private TextField textField;
	private Label messageLabel;
	
	public JassClientView(Stage stage, JassClientModel model) {
		this.model = model;
		
		messageLabel = new Label();
		messageLabel.setPrefSize(300,300);
		this.textField = new TextField();
		this.button = new Button("send");
		hbox= new HBox();
		hbox.getChildren().add(textField);
		hbox.getChildren().add(button);
		
		//MessageLabelActualizer mla = new MessageLabelActualizer(this.messageLabel, this.model);
		//mla.start();
		
		this.root = new BorderPane();
		this.root.setTop(messageLabel);
		this.root.setCenter(hbox);
		
		
		this.scene = new Scene(this.root);
		stage.setTitle("JassClient");
		stage.setScene(this.scene);
		stage.show();
		
	}

	public Button getButton() {
		return button;
	}

	public void setButton(Button button) {
		this.button = button;
	}

	public TextField getTextField() {
		return textField;
	}

	public void setTextField(TextField textField) {
		this.textField = textField;
	}

	public Label getMessageLabel() {
		return messageLabel;
	}

	public void setMessageLabel(Label messageLabel) {
		this.messageLabel = messageLabel;
	}
	

}
