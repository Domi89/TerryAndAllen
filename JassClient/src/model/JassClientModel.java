package model;

import serializedClasses.Client;
import serializedClasses.Message;
import serializedClasses.MessageHistory;

public class JassClientModel {
	
	MessageHistory messageHistory = new MessageHistory();
	ClientThread clientThread;
	Client client = new Client("Client 0");
	
	
	public JassClientModel() {
		
		clientThread = new ClientThread(this.client, this.messageHistory);
		clientThread.start();
		
	}
	
	public void sendTextToServer(String s) {
		Message m = new Message(client.getClientName(), s);
		clientThread.getClientThreadOutput().sendMessageToServer(m);
	
	}

}
