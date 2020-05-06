package view;

import javafx.scene.Scene;
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
	
	public JassClientView(Stage stage, JassClientModel model) {
		this.model = model;
		
		TextField textField = new TextField();
		hbox= new HBox();
		hbox.getChildren().add(textField);
		
		this.root = new BorderPane();
		this.root.setCenter(hbox);
		
		
		this.scene = new Scene(this.root);
		stage.setTitle("JassClient");
		stage.setScene(this.scene);
		stage.show();
		
	}

}
