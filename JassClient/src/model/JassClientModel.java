package model;

import java.util.ArrayList;
import java.util.function.Supplier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import serializedClasses.Client;
import serializedClasses.Message;

public class JassClientModel {
	

	private ClientThread clientThread;
	private Client client;
	private volatile ArrayList<Message> history = new ArrayList<Message>();
	

	
	
	public ClientThread getClientThread() {
		return clientThread;
	}



	public void setClientThread(ClientThread clientThread) {
		this.clientThread = clientThread;
	}


	
	public JassClientModel() {
		
		//clientThread = new ClientThread(this.client, this.history);
		//clientThread.start();
		
	}
	

	
	public ArrayList<Message> getHistory(){
		return this.history;
	}
	
	public void connectToServer(String clientName, String ip, int port) {
		
		this.client = new Client(clientName);
		this.clientThread = new ClientThread(this.client, this.history, ip, port);
		this.clientThread.start();
		
		
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}
	
	
	

}
