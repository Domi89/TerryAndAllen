package ServerConnection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import BusinessLayer.Game;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.GameFinished;
import serializedClasses.Message;
import serializedClasses.Rule;
import serializedClasses.Score;
import serializedClasses.Suit;

public class ServerThreadOutput extends Thread{
	
	private ObjectOutputStream outputStream;
	private Client client;
	public ServerThreadOutput(ObjectOutputStream outputStream, Client client) {

		this.outputStream = outputStream;
		this.client = client;

	}
	
	public void run() {
		
		try {
			this.outputStream.writeObject("Connected");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(true) {
			try {
				
				currentThread().sleep(5000);
				
			//	writeNewMessages();
				
			} catch (InterruptedException e) {
				
				System.out.println("Thread interrupted "+e.getMessage());
				
			} 
		}

		
	}

	private void writeNewMessages() {
		
		for (Message message: GameStatus.getHistory()) {
			if (message.getSent()) {
			} else {
				try {
					this.outputStream.writeObject(message);
					message.setSent(true);
				} catch (IOException e) {
					System.out.println("Error ServerthreadOutPut"+e.getMessage());
				}
			}
		}
		
	}
	
	public void writeNewMessages(Message m) {
		
		try {
			this.outputStream.writeObject(m);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void sendCard(Card c) {
		
		try {
			this.outputStream.writeObject(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	public void sendTrumpf(Suit suit) {
		
		try {
			this.outputStream.writeObject(suit);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}	
	
	public void sendRule(Rule rule) {
		
		try {
			this.outputStream.writeObject(rule);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	
	
	public void sendClient(Client c) {
		
		try {
			this.outputStream.writeObject(c);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendGame(GameFinished g) {
		
		try {
			this.outputStream.writeObject(g);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	
	public void sendString(String s) {
		try {
			this.outputStream.writeObject(s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendScore(Score s) {
		try {
			this.outputStream.writeObject(s);
			System.out.println("Score outputStream "+s);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendCards(ArrayList<Card> send) {
		
		try {
			this.outputStream.writeObject(send);
			System.out.println("Gesendete Karten: "+send);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	public void sendClients(ArrayList<Client> send) {
		
		try {
			this.outputStream.writeObject(send);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
