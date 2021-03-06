package ServerConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import serializedClasses.Card;
import serializedClasses.Client;

import serializedClasses.Message;
import serializedClasses.Rule;
import serializedClasses.Suit;


public class ServerThreadInput extends Thread{
	
	private volatile ObjectInputStream inputStream;
	private volatile Object inputObject;
	private volatile ArrayList<Card> currentSmallRound;
	private volatile Client client;
	
	public Client getClient() {
		return client;
		
	}
	

	public void setClient(Client client) {
		this.client = client;
	}
	public ServerThreadInput(ObjectInputStream inputStream, Client client) {
	
		this.inputStream = inputStream;

		this.client = client;

	}
	
	public void run() {
		
		try {
			try {
				
				
				while(true) {
					
					this.inputObject = this.inputStream.readObject();
					String className = inputObject.getClass().getSimpleName();
					System.out.println("Received class name: "+className);
					
					switch (className) {
						case "String":
							this.stringClass();	
							break;
						
						case "Client":
							Client receivedClient = (Client) this.inputObject;
							this.clientClass(receivedClient);
							GameStatus.getClients().add(receivedClient);
							break;
							
						case "Card":
							Card receivedCard = (Card) this.inputObject;
							this.cardClass(receivedCard);
							break;
							
						case "Message":
							Message message = (Message) this.inputObject;
							//Message message = new Message("", "");
							
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
														
						default:
							System.out.println("Class is not defined in ServerThread!");
					}
						
				} 
			}catch (ClassNotFoundException e) {
				System.out.println("Class / Object Error"+e.getMessage());
			}
		} catch (IOException e) {
			System.out.println("Thread exception "+e.getMessage());
		}
			
	}

	
	private void ruleClass(Rule rule) {
		GameStatus.setRule(rule);
		
	}

	private void suitClass(Suit suit) {
		GameStatus.setTrumpf(suit);
		
	}

	private void cardClass(Card receivedCard) {
		//TODO Abspeichern in ArrayList ArrayList, Senden der erhaltenen Karte an die Restlichen Threads
		// Überprüfen, wenn 4 Karten erhalten, auswerten wer gewonnen und punkte nachtragen
		
		receivedCard.setClient(this.client);
		GameStatus.addcurrentSmallRound(receivedCard);
		//GameStatus.setLastPlayed(this.client);
		
		System.out.println("Received Card from Client: "+receivedCard);
		
	}

	private void clientClass(Client client) {
		this.client = client;
		System.out.println("Received Client name: "+client.getClientName());
		
	}

	private void messageClass(Message m) {
		System.out.println("Message: "+m.getClientName()+" :"+m.getMessage());
		GameStatus.getHistory().add(m);

	}


	private void stringClass() {
		// TODO Auto-generated method stub
		
	}
	

}
