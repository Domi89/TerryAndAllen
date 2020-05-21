package ServerConnection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Message;

public class ServerThreadOutput extends Thread{
	
	private ObjectOutputStream outputStream;

	private ArrayList<Message> history;
	private Client client;
	
	public ServerThreadOutput(ObjectOutputStream outputStream, ArrayList<Message> history, Client client) {
		this.outputStream = outputStream;
		this.history = history;
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
		
		for (Message message: history) {
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
	

	public void sendCards(ArrayList<Card> send) {
		
		try {
			this.outputStream.writeObject(send);
			System.out.println("Gesendete Karten: "+send);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}
