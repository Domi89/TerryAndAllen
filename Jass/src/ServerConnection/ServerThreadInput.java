package ServerConnection;

import java.io.IOException;
import java.io.ObjectInputStream;

import serializedClasses.Message;
import serializedClasses.MessageHistory;

public class ServerThreadInput extends Thread{
	
	private ObjectInputStream inputStream;
	private Object inputObject;
	private MessageHistory mh;
	
	public ServerThreadInput(ObjectInputStream inputStream, MessageHistory mh) {
		this.inputStream = inputStream;
		this.mh = mh;
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
							this.clientClass();
							break;
							
						case "Message":
							
							this.messageClass((Message) this.inputObject);
							
						case "Card":
							this.cardClass();
							break;
							
						case "Deck":
							this.deckClass();
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

	private void deckClass() {
		// TODO Auto-generated method stub
		
	}

	private void cardClass() {
		// TODO Auto-generated method stub
		
	}

	private void messageClass(Message m) {
		System.out.println("Message: "+m.getClientName()+" :"+m.getMessage());
		this.mh.addMessage(m);
		
	}

	private void clientClass() {
		// TODO Auto-generated method stub
		
	}

	private void stringClass() {
		// TODO Auto-generated method stub
		
	}
	

}
