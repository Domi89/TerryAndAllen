package model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.function.Supplier;

import javafx.collections.ObservableList;
import serializedClasses.Client;
import serializedClasses.Message;

public class ClientThreadInput extends Thread{
	
	private ObjectInputStream inputStream;
	private Object inputObject;
	private Client client;
	private ArrayList<Message> history = new ArrayList<Message>();


	public ClientThreadInput(ObjectInputStream inputStream, Client client){
		this.inputStream = inputStream;
		this.client = client;
			
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


	public ArrayList<Message> getHistory() {
		return history;
	}

	public void setHistory(ArrayList<Message> history) {
		this.history = history;
	}

	private void messageClass(Message m) {
		Message inMessage = m;
		m.setSent(false);
		System.out.println("-----NEW message-------");
		System.out.println(inMessage);
		System.out.println("-----NEW message-------");
		history.add(inMessage);
		
	}

	private void clientClass() {
		// TODO Auto-generated method stub
		
	}

	private void stringClass(String string) {
		if(string.equals("Connected")) {
			
			Connection.connected = true;
			
		}
	}





}
