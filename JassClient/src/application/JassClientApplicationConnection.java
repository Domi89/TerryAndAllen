package application;

import controller.ConnectCenterController;
import controller.JassClientController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Connection;
import model.JassClientModel;
import view.JassClientConnectCenter;
import view.JassClientView;

// since it is JavaFX SDK 14, Run as -> VM arguments module path add controls and javafx.fxml
// additionally there must be added the JAVA FX 14 Library

public class JassClientApplicationConnection extends Application{
	
	JassClientModel model;
	JassClientView view;
	JassClientConnectCenter view2;
	JassClientController controller;
	ConnectCenterController controller2;
	
	public static Stage primaryStage = new Stage();
	
	
	public static void main(String[] args) {
		launch();
		
	}
	
	public void start(Stage primaryStage) throws Exception{
		model = new JassClientModel();
		view2 = new JassClientConnectCenter(primaryStage, model);
		controller2 = new ConnectCenterController(model,view2);
		this.primaryStage = primaryStage;
		
	}
	
	public void startSecond(Stage primaryStage) {
		
		view = new JassClientView(primaryStage, model);
		controller = new JassClientController(model, view);
		
	}
	
}
