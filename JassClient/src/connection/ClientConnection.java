package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import serializedClasses.Message;

public class ClientConnection {
	
	private Socket socket;
	private Object inputObject;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	
	public ClientConnection() {
		
		try(Socket socket = new Socket("localhost", 45138)){
			try {
				try {
					
					System.out.println("test");
					
					this.outputStream = new ObjectOutputStream(socket.getOutputStream());
					this.inputStream = new ObjectInputStream(socket.getInputStream());
					
									
					Scanner scanner = new Scanner(System.in);
					String echoString;
					String response;
					
					do {
						System.out.println("String to be echoed ");
						echoString = scanner.nextLine();
						this.outputStream.writeObject(echoString);
						//stringToEcho.println(echoString);
						
				
						
						if(!echoString.contentEquals("Exit")) {

							this.inputObject = inputStream.readObject();
							String className = this.inputObject.getClass().getSimpleName();
							String inputString = (String) this.inputObject;
							System.out.println(inputString);
						}
			
					} while (!echoString.equals("exit"));
					
					
					
					//----------------------------------------------------
					
					
					
					
					
					while(true) {
					
						
						//ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());					
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
			} 
			
		
		} catch (IOException e) {
			System.out.println("Client connection problem");
		}
		
	
		
		
	}

	private void deckClass() {
		// TODO Auto-generated method stub
		
	}

	private void cardClass() {
		// TODO Auto-generated method stub
		
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
