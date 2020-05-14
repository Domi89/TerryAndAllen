package model;

import serializedClasses.Client;
import serializedClasses.Message;

public class JassClientModel {
	

	ClientThread clientThread;
	Client client = new Client("Client 0");
	
	
	public JassClientModel() {
		
		clientThread = new ClientThread(this.client);
		clientThread.start();
		
	}
	
	public void sendTextToServer(String s) {
		Message m = new Message(client.getClientName(), s);
		clientThread.getClientThreadOutput().sendMessageToServer(m);
	
	}

}
