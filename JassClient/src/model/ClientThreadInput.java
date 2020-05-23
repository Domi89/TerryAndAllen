package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import java.util.function.Supplier;
import java.util.stream.Collectors;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableIntegerValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import serializedClasses.Card;
import serializedClasses.Client;

import serializedClasses.GameFinished;
import serializedClasses.Message;
import serializedClasses.Rule;
import serializedClasses.Score;
import serializedClasses.Suit;

public class ClientThreadInput extends Thread{
	
	private ObjectInputStream inputStream;
	private Object inputObject;
	private Client client;
	//private ArrayList<Message> history = new ArrayList<Message>();
	private ObservableList<Message> history = FXCollections.observableArrayList();
	private ObservableList<Card> cards;
	private ObservableIntegerValue updated;
	private ObservableList<Integer> updatedCards;
	private ObservableList<Card> cardsOnBoard;
	private ObservableList<Client> clients;
	private ObservableList<Score> scores;
	private ObservableList<GameFinished> gameFinished;

	public ClientThreadInput(ObjectInputStream inputStream, Client client, ObservableList<Card> cards, ObservableList<Integer> updatedCards, ObservableList<Client> clients, ObservableList<Score> scores,ObservableList<GameFinished> gameFinished){
		this.inputStream = inputStream;
		this.client = client;
		this.cards = cards;
		this.updatedCards = updatedCards;
		this.clients = clients;
		this.scores = scores;
		this.gameFinished= gameFinished;
			
	}
	
	public void run() {
		
		try {
			
			while(true) {
				
				this.inputObject = this.inputStream.readObject();
				String className = inputObject.getClass().getSimpleName();
				System.out.println("Received class name: "+className);
				
				switch (className) {
					case "String":
						String string = (String) this.inputObject;
						this.stringClass(string);	
						break;
				
					case "Client":
						this.clientClass();
						break;
						
					case "Card":
						Card card = (Card) this.inputObject;
						this.cardClass(card);
						break;
						
					case "Score":
						
						Score score = (Score) this.inputObject;
						this.scoreClass(score);
						break;
					
					case "Message":
						Message message = (Message) this.inputObject;
						this.messageClass(message);
						break;
						
					case "Suit":
						Suit suit = (Suit) this.inputObject;
						this.suitClass(suit);
						break;
						
					case "Rule":
						Rule rule = (Rule) this.inputObject;
						this.ruleClass(rule);
						break;
						
					case "GameFinished":
						GameFinished game = (GameFinished) this.inputObject;
						this.gameFinishedClass(game);
						break;
						
						
					case "ArrayList":
						ArrayList<Object> input = (ArrayList<Object>) this.inputObject;
						
						String classN = input.get(0).getClass().getSimpleName();
						
						
						if(classN.equals("Card")) {
							System.out.println("classN "+classN);
							ArrayList<Card> inputCards = (ArrayList<Card>) this.inputObject;
							if (inputCards.size()==9) {
								this.newCards(inputCards);
							} else {
								System.out.println("Nicht 9 Karten erhalten Grösse:" +inputCards.size());
							}
						}
						
						if(classN.equals("Client")) {
							System.out.println("classN "+classN);
							ArrayList<Client> inputClients = (ArrayList<Client>) this.inputObject;
							this.clientsClass(inputClients);				
							
						}
						
	
						break;
						
						
					
					default:
						System.out.println("Class is not defined in ClientThreadInput!");
				}
			}
						
		} catch (ClassNotFoundException e) {
			System.out.println("Class / Object Error"+e.getMessage());
		} catch (IOException e) {
			System.out.println("Thread exception "+e.getMessage());
		}

	}


	private void gameFinishedClass(GameFinished game) {
		System.out.println("WINNER: "+game.getWinner().getClientName()+" Points: "+game.getMaxPoints());
		Connection.setGameFinished(true);
		this.gameFinished.add(game);
	}

	private void ruleClass(Rule rule) {
		Connection.setRule(rule);
		
	}

	private void suitClass(Suit suit) {
		Connection.setTrumpf(suit);
		
	}

	private void clientsClass(ArrayList<Client> inputClients) {
		this.clients.addAll(inputClients);
		System.out.println("Clients: "+inputClients);
	}

	private void cardClass(Card card) {
		System.out.println("Neue Karte gespielt von: "+card.getClient().getClientName()+" Karte: "+card);
		
		Connection.getCardsOnTable().add(card);
		Connection.setNewCardToShow(true);
	}

	private void newCards(ArrayList<Card> inputCards) {
		
		this.updatedCards.add(0);
		
		System.out.println(inputCards);
		this.cards.clear();
		this.cards.addAll(inputCards);
		
		
	}

	public ObservableList<Message> getHistory() {
		return history;
	}
	

	

	public void setHistory(ObservableList<Message> history) {
		this.history = history;
	}

	private void messageClass(Message m) {
		Message inMessage = m;
		m.setSent(false);
		System.out.println("-----NEW message-------");
		System.out.println(inMessage);
		System.out.println("-----NEW message-------");
		this.history.add(inMessage);
		
	}

	private void clientClass() {
		// TODO Auto-generated method stub
		
	}
	
	private void scoreClass(Score score) {
		
		System.out.println("Score inputStream "+score);
		this.scores.add(score);
		
		
	}

	private void stringClass(String string) {
		
		if(string.equals("chooseMode")) {
			Connection.setChooseMode(true);
		}
		
		if(string.equals("Connected")) {
			Connection.connected = true;
		}
		if(string.contentEquals("yourTurn")) {
			Connection.setYourTurn(true);
		}
		
	}





}
