package model;

import java.io.IOException;
import java.io.ObjectInputStream;

import serializedClasses.Client;
import serializedClasses.Message;
import serializedClasses.MessageHistory;

public class ClientThreadInput extends Thread{
	
	private ObjectInputStream inputStream;
	private Object inputObject;
	private MessageHistory messageHistory;
	private Client client;
	
	public ClientThreadInput(ObjectInputStream inputStream, MessageHistory messageHistory, Client client){
		this.inputStream = inputStream;
		this.messageHistory = messageHistory;
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
						this.stringClass();	
						break;
				
					case "Client":
						this.clientClass();
						break;
					
					case "Message":
						this.messageClass();
						break;
						
					case "MessageHistory":
						this.messageHistoryClass((MessageHistory) this.inputObject);
						break;
					
					default:
						System.out.println("Class is not defined in ServerThread!");
				}
			}
						
		} catch (ClassNotFoundException e) {
			System.out.println("Class / Object Error"+e.getMessage());
		} catch (IOException e) {
			System.out.println("Thread exception "+e.getMessage());
		}
		
		
		
	}

	private void messageHistoryClass(MessageHistory messageHistory) {
		this.messageHistory = messageHistory;
		
		if(this.messageHistory.getMessageHistory().size()!=0) {
			System.out.println("Message history: "+this.messageHistory.getLatestMessage());
			System.out.println("MessageHistorySize = "+this.messageHistory.getMessageHistory().size());
		} else {
			System.out.println("Message History = Null");
		}
		
		
	}

	private void messageClass() {
		// TODO Auto-generated method stub
		
	}

	private void clientClass() {
		// TODO Auto-generated method stub
		
	}

	private void stringClass() {
		// TODO Auto-generated method stub
		
	}

}
