package application;

import controller.ConnectCenterController;
import controller.JassClientController;
import javafx.application.Application;
import javafx.stage.Stage;
import model.JassClientModel;
import view.JassClientConnectCenter;
import view.JassClientView;

public class JassClientApplicationGameNewStage{

	JassClientModel model;
	JassClientView view;
	JassClientController controller;
	
	public JassClientApplicationGameNewStage(Stage stage, JassClientModel model) {
		this.view = new JassClientView(stage, model);
		controller = new JassClientController(model, view);
	}
	
}
