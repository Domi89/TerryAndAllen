package controller;

import application.JassClientApplicationConnection;
import model.JassClientModel;
import view.JassClientConnectCenter;
import view.JassClientView;

public class JassClientController {
	
	private JassClientModel model;
	private JassClientView view;
	private JassClientApplicationConnection start = new JassClientApplicationConnection();
	
	public JassClientController(JassClientModel model, JassClientView view) {
		this.model = model;
		this.view = view;
		this.view.getButton().setOnAction(e -> sendMessageView());
		Actualizer actualizer = new Actualizer(this.view, this.model);
		actualizer.start();
		
		
		
		
		
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
	
	
	


}
