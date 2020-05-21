package application;

import java.util.ArrayList;

import controller.ConnectCenterController;
import controller.JassClientController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import model.JassClientModel;
import serializedClasses.Message;
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
