package model;

import java.io.IOException;
import java.io.ObjectOutputStream;

import serializedClasses.Client;
import serializedClasses.Message;


public class ClientThreadOutput extends Thread{
	
	private ObjectOutputStream outputStream;

	private Client client;
	
	public ClientThreadOutput (ObjectOutputStream outputStream, Client client) {
		this.outputStream = outputStream;

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
