package view;

import java.util.ArrayList;

import javafx.scene.control.Label;
import model.JassClientModel;
import serializedClasses.Message;

public class MessageLabelActualizer extends Thread{
	
	private Label messageLabel;
	private JassClientModel model;
	
	public MessageLabelActualizer(Label messageLabel, JassClientModel model) {
		
		this.messageLabel=messageLabel;
		this.model = model;
		
	}
	
	public void run() {

		while(true) {
			
								
				ArrayList<Message> history = this.model.getHistory();
				
				String s ="---";
				
				
				for (Message message: history) {
					s+=message;
					s+=("\n");
					
						
				}
				this.messageLabel.setText(s);
				
			
					
		}
		
	}

}
