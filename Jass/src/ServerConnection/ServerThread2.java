package ServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import serializedClasses.Client;
import serializedClasses.Message;


public class ServerThread2 extends Thread{
	private Socket socket;
	private Object inputObject;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private ArrayList<Message> history;
	private Client client;	
	
	public ServerThread2(Socket socket, ArrayList<Message> history) {
		this.socket = socket;
		this.history = history;
		
	}
	
	public void run() {
		
		try {
							
				while(true) {
					
					this.inputStream = new ObjectInputStream(socket.getInputStream());
					this.outputStream = new ObjectOutputStream(socket.getOutputStream());
									
					// -----INPUT----- 
					
					try {
						this.inputObject = this.inputStream.readObject();
						String className = inputObject.getClass().getSimpleName();
						System.out.println("Received class from client: "+className);
						
						switch (className) {
						case "String":
							this.stringClass();	
							break;
						
						case "Client":
							Client receivedClient = (Client) this.inputObject;
							this.clientClass(receivedClient);
							break;
							
						case "Message":
							Message message = (Message) this.inputObject;
							//Message message = new Message("", "");
							
							this.messageClass(message);
							break;
														
						default:
							System.out.println("Class is not defined in ServerThread!");
					}
							
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					
					try {
						currentThread().sleep(5000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
					// -----OUTPUT----- 
					
					this.outputStream.writeObject("Connected");
				}
			
		} catch (IOException e) {
			System.out.println("Thread exception "+e.getMessage());
		} finally {
			try {
				socket.close();
			} catch(IOException e){
				
			}
		}
	}
	
	
	// -----INPUT----- 
	
	
	private void messageClass(Message m) {
		System.out.println("Message: "+m.getClientName()+" :"+m.getMessage());
		this.history.add(m);

	}

	private void clientClass(Client client) {
		this.client = client;
		System.out.println("Received Client name: "+client.getClientName());
		
	}


	private void stringClass() {
		// TODO Auto-generated method stub
		
	}
	
	// -----INPUT----- 
}