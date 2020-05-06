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
		
		
		this.view.getButton().setOnAction(e -> sendMessageView());
	
	
	
	}

	private void sendMessageView() {
		if(this.view.getTextField().getText().equals("")){
			return;
		} else {
			String s = this.view.getTextField().getText();
			this.model.sendTextToServer(s);
			this.view.getTextField().setText("");
		}
	}
	
	private void actualizeMessageLabel(String s) {
		this.view.getMessageLabel().setText(s);
	}

}
