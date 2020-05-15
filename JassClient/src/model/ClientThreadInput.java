package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import serializedClasses.Client;
import serializedClasses.Message;

public class ClientThreadInput extends Thread{
	
	private ObjectInputStream inputStream;
	private Object inputObject;
	private Client client;
	private ArrayList<Message> history;
	
	public ClientThreadInput(ObjectInputStream inputStream, Client client, ArrayList<Message> history){
		this.inputStream = inputStream;
		this.client = client;
		this.history = history;
	}
	
	public void run() {
		
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
						this.clientClass();
						break;
					
					case "Message":
						Message message = (Message) this.inputObject;
						this.messageClass(message);
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


	private void messageClass(Message m) {
		System.out.println("-----NEW message-------");
		System.out.println(m);
		System.out.println("-----NEW message-------");
		history.add(m);
		
	}

	private void clientClass() {
		// TODO Auto-generated method stub
		
	}

	private void stringClass() {
		// TODO Auto-generated method stub
		
	}

}
