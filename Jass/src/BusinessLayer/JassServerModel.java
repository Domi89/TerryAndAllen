package BusinessLayer;

import java.util.ArrayList;


import ServerConnection.ServerApplication;
import serializedClasses.Message;


public class JassServerModel {
	

	private ArrayList<Message> history;
	
	public JassServerModel() {
	
		this.history = new ArrayList<Message>();
		
		ServerApplication serverApplication = new ServerApplication(this.history);
		
	}

}
