package controller;

import java.util.ArrayList;

import model.JassClientModel;
import serializedClasses.Message;
import view.JassClientView;

public class Actualizer extends Thread {
	
	
	private JassClientView view;
	private JassClientModel model;
	
	public Actualizer(JassClientView view, JassClientModel model) {
		this.view = view;
		this.model = model;
	}

	public void run() {
		while (true) {
			
			actualizeMessageLabel();
			
		}
	}
	
	public void actualizeMessageLabel() {
		ArrayList<Message> history = this.model.getHistory();
		String ht="";
		
		for (Message message: history) {
			ht+=message;
		}
		
		
		this.view.getMessageLabel().setText(ht);
	}
	
}
