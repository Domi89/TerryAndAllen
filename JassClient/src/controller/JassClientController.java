package controller;

public class JassClientController {
	
	private JassClientModel model;
	private JassClientView view;
	private JassClientApplication start = new JassClientGame();
	
	public JassClientController(JassClientModel model, JassClientView view) {
		this.model = model;
		this.view = view;
	}

}
