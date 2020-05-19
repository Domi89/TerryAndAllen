package application;

import controller.ConnectCenterController;
import controller.JassClientController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.JassClientModel;
import view.JassClientConnectCenter;
import view.JassClientView;

public class JassClientApplicationGame extends Application{

	
	JassClientModel model;
	JassClientView view;
	JassClientController controller;

	
	public static Stage primaryStage = new Stage();
	
	public static void main(String[] args) {
		launch();
	}
	
	
	public void start(Stage primaryStage) throws Exception{
	//	model = new JassClientModel();
		view = new JassClientView(primaryStage, model);
	//	controller = new JassClientController(model, view);
		this.primaryStage = primaryStage;
		
	
	}
	
}
