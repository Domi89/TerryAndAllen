package controller;

import application.JassClientApplication;
import model.JassClientModel;
import view.JassClientView;

public class JassClientController {
	
	private JassClientModel model;
	private JassClientView view;
	private JassClientApplication start = new JassClientApplication();
	
	public JassClientController(JassClientModel model, JassClientView view) {
		this.model = model;
		this.view = view;
	}

}
