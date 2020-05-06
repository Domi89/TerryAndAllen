package model;

import serializedClasses.Message;

public class JassClientModel {
	
	ClientConnection cc;
	String UserName = "Hans";
	
	public JassClientModel() {
		
		cc = new ClientConnection();
		cc.start();
		
	}
	
	public void sendTextToServer(String s) {
		Message m = new Message(this.UserName, s);
		cc.sendMessageToServer(m);		
	}

}
