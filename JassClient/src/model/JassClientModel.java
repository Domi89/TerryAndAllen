package model;

import java.util.ArrayList;
import java.util.function.Supplier;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Message;

public class JassClientModel {
	

	private ClientThread clientThread;
	private Client client;
	//private ArrayList<Message> history = new ArrayList<Message>();
	private ObservableList<Card> cards = FXCollections.observableArrayList();
	

	public ObservableList<Card> getCards() {
		return cards;
	}



	public void setCards(ObservableList<Card> cards) {
		this.cards = cards;
	}



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
	

	
	//public ArrayList<Message> getHistory(){
		//return this.history;
	//}
	
	public void connectToServer(String clientName, String ip, int port) {
		
		this.client = new Client(clientName);
		this.clientThread = new ClientThread(this.client, ip, port, this.cards);
		this.clientThread.start();
		
		
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}
	
	
	

}
