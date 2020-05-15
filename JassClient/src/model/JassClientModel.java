package model;

import java.util.ArrayList;
import java.util.function.Supplier;

import serializedClasses.Client;
import serializedClasses.Message;

public class JassClientModel {
	

	ClientThread clientThread;
	Supplier <Boolean> connected = ()-> false;
	
	Client client;
	ArrayList<Message> history = new ArrayList<Message>();
	
	public Supplier<Boolean> getConnected() {
		return this.connected;
	}
	
	public JassClientModel() {
		
		//clientThread = new ClientThread(this.client, this.history);
		//clientThread.start();
		
	}
	
	public void sendTextToServer(String s) {
		Message m = new Message(client.getClientName(), s);
		clientThread.getClientThreadOutput().sendMessageToServer(m);
	
	}
	
	public ArrayList<Message> getHistory(){
		return this.history;
	}
	
	public void connectToServer(String clientName, String ip, int port) {
		
		this.client = new Client(clientName);
		this.clientThread = new ClientThread(this.client, this.history, ip, port, this.connected);
		this.clientThread.start();
		
		
	}

}
