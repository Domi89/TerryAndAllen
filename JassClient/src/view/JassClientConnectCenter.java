package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.JassClientModel;

public class JassClientConnectCenter {
               
    private JassClientModel model;
    private Scene scene;
	private Label benutzer, iP, port;
	private TextField benutzerText, ipText, portText;
	private Button connect;
	private BorderPane root;
	
	public JassClientConnectCenter(Stage stage, JassClientModel model) {
		
		this.model = model;
		
			

        //Create the fields for the Connection 
        this.benutzer = new Label("Username: ");
       	this.iP = new Label ("IP: ");
        this.port = new Label("Port: ");

        this.benutzerText = new TextField();
        this.ipText = new TextField();
        this.portText = new TextField();
        //Connection BUtton
        this.connect = new Button ("Verbinden");
                      
       	HBox hBox = new HBox();
        
        VBox labelBox = new VBox();
        VBox textBox = new VBox();
        
        //Adding IP label and field
        labelBox.getChildren().addAll(benutzer,iP,port);
        //adding port label and field
        textBox.getChildren().addAll(benutzerText, ipText, portText, connect);
    
        hBox.getChildren().addAll(labelBox, textBox);
        
        JassClientConnectMenBar menBar = new JassClientConnectMenBar();
        
        this.root = new BorderPane();
        
        this.root.setTop(menBar);
        this.root.setCenter(hBox);
        
        this.scene = new Scene(this.root);
        stage.setTitle("Verbindung zum Server aufbauen");
        stage.setScene(this.scene);
        stage.show();
	}

	public JassClientModel getModel() {
		return model;
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

	public Label getBenutzer() {
		return benutzer;
	}

	public void setBenutzer(Label benutzer) {
		this.benutzer = benutzer;
	}

	public Label getiP() {
		return iP;
	}

	public void setiP(Label iP) {
		this.iP = iP;
	}

	public Label getPort() {
		return port;
	}

	public void setPort(Label port) {
		this.port = port;
	}

	public TextField getBenutzerText() {
		return benutzerText;
	}

	public void setBenutzerText(TextField benutzerText) {
		this.benutzerText = benutzerText;
	}

	public TextField getIpText() {
		return ipText;
	}

	public void setIpText(TextField ipText) {
		this.ipText = ipText;
	}

	public TextField getPortText() {
		return portText;
	}

	public void setPortText(TextField portText) {
		this.portText = portText;
	}

	public Button getConnect() {
		return connect;
	}

	public void setConnect(Button connect) {
		this.connect = connect;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}
	
	
	
}
