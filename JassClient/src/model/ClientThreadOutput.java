package model;

import java.io.IOException;
import java.io.ObjectOutputStream;

import serializedClasses.Client;
import serializedClasses.Message;
import serializedClasses.MessageHistory;

public class ClientThreadOutput extends Thread{
	
	private ObjectOutputStream outputStream;
	private MessageHistory messageHistory;
	private Client client;
	
	public ClientThreadOutput (ObjectOutputStream outputStream, MessageHistory messageHistory, Client client) {
		this.outputStream = outputStream;
		this.messageHistory = messageHistory;
		this.client = client;
	}
	
	public void run() {
		
		while (true) {
			
			
			
		}
		
		
	}
	
	public void sendMessageToServer(Message m) {
		try {
			this.outputStream.writeObject(m);
		} catch (IOException e) {
			System.out.println("Fehler ClientConnection sendMessageToServer "+e.getMessage());
			}
	}
	

}
