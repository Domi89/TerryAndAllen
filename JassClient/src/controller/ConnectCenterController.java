package controller;

import application.JassClientApplication;
import model.JassClientModel;
import view.JassClientConnectCenter;

public class ConnectCenterController {
	
	private JassClientModel model;
	private JassClientConnectCenter view;
	private JassClientApplication start = new JassClientApplication();
	private Boolean sendable = false;
	
	public ConnectCenterController(JassClientModel model, JassClientConnectCenter view) {
		this.model = model;
		this.view = view;
		this.view.getConnect().setOnAction(e -> connectToServer());
		
		this.view.getBenutzerText().textProperty().addListener(
				(observable, oldValue, newValue) -> validateBenutzerName(newValue)
				);
	
	
	}

	private Object validateBenutzerName(String newValue) {
		this.view.getBenutzerText().set
		return null;
	}

	private Object connectToServer() {
		
		if(this.view.getBenutzerText().getText().equals("")) {
			
		}
		return null;
	}
	
	

}
