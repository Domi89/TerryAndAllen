package view;

import application.JassClientApplicationGameNewStage;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.JassClientModel;

public class JassClientConnectCenter {
               
    private JassClientModel model;
    private Scene scene;
	private Label welcome1, welcome2, benutzer, iP, port;
	private TextField benutzerText, ipText, portText;
	private Button connect;
	private BorderPane root;
	private Stage stage;

	
	public JassClientConnectCenter(Stage stage, JassClientModel model) {
		//commen
		this.model = model;
		
		getClass().getResource("../styleSheets/ConnectCenter.css").toExternalForm();
		
        //Create the fields for the Connection 
        this.benutzer = new Label("Username: ");
       	this.iP = new Label ("IP: ");
        this.port = new Label("Port: ");

        this.benutzerText = new TextField();
        this.ipText = new TextField();
        this.ipText.setText("localhost");
        
        this.portText = new TextField();
        this.portText.setText("45138");
        //Connection BUtton
         this.connect = new Button ("Verbinden");

      
        this.welcome1 = new Label("Gr�ezi und Wilkommen zu ");
        this.welcome2 = new Label("Terry & Alans Online Jass");
        
        //TODO wieder auf TRUE setzen
        this.connect.setDisable(true);
       	HBox hBox = new HBox();
        
        VBox labelBox = new VBox();
        VBox textBox = new VBox();
       
        this.connect.setId("conBut");
        hBox.setId("window");
        this.benutzer.setId("labels");
        this.iP.setId("labels");
        this.port.setId("labels");
        this.benutzerText.setId("textField");
        this.portText.setId("textField"); 
        this.ipText.setId("textField");
        this.welcome1.setId("welcometext");
        this.welcome2.setId("welcometext");
                
          
        //Adding IP label and field
        labelBox.getChildren().addAll(welcome1, benutzer,iP,port);
        //adding port label and field
        textBox.getChildren().addAll(welcome2, benutzerText, ipText, portText, connect);
    
        hBox.getChildren().addAll(labelBox, textBox);
        
        JassClientConnectMenBar menBar = new JassClientConnectMenBar();
        
        this.root = new BorderPane();
        
        this.root.setTop(menBar);
        this.root.setCenter(hBox);
        
        this.scene = new Scene(this.root);
        this.scene.getStylesheets().add(getClass().getResource("../styleSheets/ConnectCenter.css").toExternalForm());
        this.connect.setId("conBut");
        
        Image icon = new Image(getClass().getResourceAsStream("../images/Schelle.png"));
        
        this.stage = stage;
        this.stage.setTitle("Verbindung zum Server aufbauen");
        this.stage.getIcons().add(icon);
        this.stage.setScene(this.scene);
        this.stage.show();
        
        
        
        
	}

	public void closeStage() {
		
		this.stage.close();
		this.openNewView();
				
	}
	
	public void openNewView() {
		Stage newStage = new Stage();	    
		//JassClientView jCV = new JassClientView(newStage, this.model);
				
		JassClientApplicationGameNewStage jcagns = new JassClientApplicationGameNewStage(newStage, this.model);
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
