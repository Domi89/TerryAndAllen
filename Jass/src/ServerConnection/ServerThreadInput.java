package ServerConnection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import serializedClasses.Message;


public class ServerThreadInput extends Thread{
	
	private ObjectInputStream inputStream;
	private Object inputObject;

	private ArrayList<Message> history;
	
	public ServerThreadInput(ObjectInputStream inputStream, ArrayList<Message> history) {
		this.inputStream = inputStream;
		this.history = history;
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
							Message message = (Message) this.inputObject;
							//Message message = new Message("", "");
							
							this.messageClass(message);
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


	private void messageClass(Message m) {
		System.out.println("Message: "+m.getClientName()+" :"+m.getMessage());
		this.history.add(m);

	}

	private void clientClass() {
		// TODO Auto-generated method stub
		
	}

	private void stringClass() {
		// TODO Auto-generated method stub
		
	}
	

}
