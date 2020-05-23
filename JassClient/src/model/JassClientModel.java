package model;

import java.util.ArrayList;
import java.util.function.Supplier;

import javafx.beans.value.ObservableIntegerValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.GameFinished;
import serializedClasses.Message;
import serializedClasses.Score;

public class JassClientModel {
	

	private ClientThread clientThread;
	private Client client;
	//private ArrayList<Message> history = new ArrayList<Message>();
	private ObservableList<Card> cards = FXCollections.observableArrayList();
	private ObservableList<Integer> updatedCards = FXCollections.observableArrayList();
	private ObservableList<Client> clients = FXCollections.observableArrayList();
	private ObservableList<Score> scores = FXCollections.observableArrayList();
	private ObservableList<GameFinished> gameFinished = FXCollections.observableArrayList();

	public ObservableList<GameFinished> getGameFinished() {
		return gameFinished;
	}



	public void setGameFinished(ObservableList<GameFinished> gameFinished) {
		this.gameFinished = gameFinished;
	}



	public ObservableList<Client> getClients() {
		return clients;
	}



	public void setClients(ObservableList<Client> clients) {
		this.clients = clients;
	}



	public ObservableList<Integer> getUpdatedCards() {
		return updatedCards;
	}



	public void setUpdatedCards(ObservableList<Integer> updatedCards) {
		this.updatedCards = updatedCards;
	}



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
		
	}
	


	
	public void connectToServer(String clientName, String ip, int port) {
		
		this.client = new Client(clientName);
		this.clientThread = new ClientThread(this.client, ip, port, this.cards, this.updatedCards, this.clients, this.scores, this.gameFinished);
		this.clientThread.start();
		
		
	}



	public Client getClient() {
		return client;
	}



	public void setClient(Client client) {
		this.client = client;
	}



	public ObservableList<Score> getScores() {
		return scores;
	}



	public void setScores(ObservableList<Score> scores) {
		this.scores = scores;
	}
	
	
	

}
