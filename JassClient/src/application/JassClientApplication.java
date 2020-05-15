package application;

import controller.JassClientController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.JassClientModel;
import view.JassClientConnectCenter;
import view.JassClientView;

// since it is JavaFX SDK 14, Run as -> VM arguments module path add controls and javafx.fxml

public class JassClientApplication extends Application{
	
	JassClientModel model;
	JassClientView view;
	JassClientConnectCenter view2;
	JassClientController controller;
	
	public static Stage primaryStage = new Stage();
	
	
	public static void main(String[] args) {
		launch();
	}
	
	public void start(Stage primaryStage) throws Exception{
		//model = new JassClientModel();
		//view = new JassClientView(primaryStage, model);
		view2 = new JassClientConnectCenter(primaryStage, model);
		//controller = new JassClientController(model, view);
		this.primaryStage = primaryStage;
	}
	

}
