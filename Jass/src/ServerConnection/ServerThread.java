package ServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket;
	private Object inputObject;
	private PrintWriter output;
	
	//
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		
		try {
			try {
				ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream());
				this.output = new PrintWriter(socket.getOutputStream(),true);

				while(true) {
										
					this.inputObject = objectInput.readObject();
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
			
			} catch (ClassNotFoundException e) {
				System.out.println("Class / Object Error");
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
	
	
	private void messageClass() {
		// TODO Auto-generated method stub
		
	}

	private void clientClass() {
		// TODO Auto-generated method stub
		
	}

	private void cardClass() {
		// TODO Auto-generated method stub
		
	}

	private void deckClass() {
		// TODO Auto-generated method stub
		
	}

	private void stringClass() {

		String inputString = (String) inputObject;
		System.out.println("Received client input: "+inputString);
		output.println(inputString);
		
	}
	

}
