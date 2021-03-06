package model;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Message;
import serializedClasses.Rule;
import serializedClasses.Suit;


public class ClientThreadOutput extends Thread{
	
	private ObjectOutputStream outputStream;

	private Client client;
	private ObservableList<Message> chatHistory;
	
	public ClientThreadOutput (ObjectOutputStream outputStream, Client client) {
		this.outputStream = outputStream;
		this.chatHistory = chatHistory;
		this.client = client;

	}
	
	public void run() {
		
			
			
		while (true) {
			
		}
		
	}
	
	public void sendRule(Rule r) {
		try {
			this.outputStream.writeObject(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public void sendColor(Suit r) {
		try {
			this.outputStream.writeObject(r);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
	}
	
	public void sendMessageToServer(Message m) {
		try {
			this.outputStream.writeObject(m);
		} catch (IOException e) {
			System.out.println("Fehler ClientConnection sendMessageToServer "+e.getMessage());
			}
	}
	
	public void sendClientToServer(Client client) {
		try {

			this.outputStream.writeObject(client);
			
			System.out.println("Sent Client name: "+client.getClientName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendCardToServer(Card card) {
		try {
			this.outputStream.writeObject(card);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

}
