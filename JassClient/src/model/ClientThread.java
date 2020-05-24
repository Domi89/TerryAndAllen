package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javafx.collections.ObservableList;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.GameFinished;
import serializedClasses.Message;
import serializedClasses.Score;


public class ClientThread extends Thread{
	
	private Socket socket;
	private Object inputObject;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private Client client;
	private ClientThreadInput clientThreadInput;
	private ClientThreadOutput clientThreadOutput;
	private String ip;
	private int port;
	private ObservableList<Card> cardsOnHand;
	public ObservableList<Card> getCardsOnHand() {
		return cardsOnHand;
	}



	public void setCardsOnHand(ObservableList<Card> cardsOnHand) {
		this.cardsOnHand = cardsOnHand;
	}
	
	
	public ArrayList<Card> getCardOnHandArray() {
		
		ArrayList<Card> cards = (ArrayList<Card>) this.cardsOnHand.stream().collect(Collectors.toList());
		return cards;		
	}

	
	public ArrayList<Card> getCardOnTableArray() {
		
		ArrayList<Card> cards = (ArrayList<Card>) this.cardsOnTable.stream().collect(Collectors.toList());
			return cards;	
	}



	private ObservableList<Card> cardsOnTable;
	private ObservableList<Integer> updatedCards;
	private ObservableList<Client> clients;
	private ObservableList<Score> scores;
	private ObservableList<GameFinished> gameFinished;
	
	public ClientThread (Client client, String ip, int port, ObservableList<Card> cardsOnHand, ObservableList<Integer> updatedCards, 
			ObservableList<Client> clients, ObservableList<Score> scores, ObservableList<GameFinished> gameFinished, ObservableList<Card> cardsOnTable) {
		this.client = client;
		this.ip = ip;
		this.port = port;
		this.cardsOnHand = cardsOnHand;
		this.updatedCards = updatedCards;
		this.clients = clients;
		this.scores = scores;
		this.gameFinished = gameFinished;
		this.cardsOnTable=cardsOnTable;
		
	}
	
	
	public void removeCard(Card card) {
		
		for(int i = 0; i<cardsOnHand.size(); i++) {
			
			if(cardsOnHand.get(i).getSuit().equals(card.getSuit()) && cardsOnHand.get(i).getRank().equals(card.getRank())) {
				cardsOnHand.remove(i);
			}
		
		}
		
	}
	
	
	
	public ClientThread (Client client) {
		this.client = client;
		this.ip = "localhost";
		this.port = 45138;
		
	}
	
	public void run() {
		
		try(Socket socket = new Socket(this.ip, this.port)){
							
					this.outputStream = new ObjectOutputStream(socket.getOutputStream());
					this.inputStream = new ObjectInputStream(socket.getInputStream());

					this.clientThreadInput = new ClientThreadInput(this.inputStream, this.client, this.cardsOnHand, 
							this.updatedCards, this.clients, this.scores, this.gameFinished, this.cardsOnTable);
					this.clientThreadInput.start();
					
					this.clientThreadOutput = new ClientThreadOutput(this.outputStream, this.client);
					this.clientThreadOutput.start();
					
					this.clientThreadOutput.sendClientToServer(this.client);
					
					while(true) {
						
					}
					
			
						
					
											
		} catch (IOException e) {
			System.out.println("Connection Problem "+e.getMessage());
		} 
	}
	
	
	public ClientThreadInput getClientThreadInput() {
		return clientThreadInput;
	}


	public ClientThreadOutput getClientThreadOutput() {
		return clientThreadOutput;
	}



	public ObservableList<Card> getCardsOnTable() {
		return cardsOnTable;
	}



	public void setCardsOnTable(ObservableList<Card> cardsOnTable) {
		this.cardsOnTable = cardsOnTable;
	}

	
	
}