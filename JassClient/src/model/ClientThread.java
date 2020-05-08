package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import serializedClasses.Client;
import serializedClasses.Message;
import serializedClasses.MessageHistory;

public class ClientThread extends Thread{
	
	private Socket socket;


	private Object inputObject;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private Client client;
	private MessageHistory messageHistory;
	private ClientThreadInput clientThreadInput; 
	private ClientThreadOutput clientThreadOutput;

	public ClientThread (Client client, MessageHistory messageHistory) {
		this.client = client;
		this.messageHistory = messageHistory;
	}
	
	public void run() {
		
		try(Socket socket = new Socket("localhost", 45138)){
							
					
					this.outputStream = new ObjectOutputStream(socket.getOutputStream());
					this.inputStream = new ObjectInputStream(socket.getInputStream());
					
					this.clientThreadInput = new ClientThreadInput(this.inputStream, this.messageHistory, this.client);
					clientThreadInput.start();
					
					this.clientThreadOutput = new ClientThreadOutput(this.outputStream, this.messageHistory, this.client);
					clientThreadOutput.start();
					
					
					//TODO braucht es das?
					while (true) {
						
					}
					
					/*
					while(true) {
						
						try {
							this.inputObject = this.inputStream.readObject();
							String inputString = (String) this.inputObject;
							System.out.println(inputString);
						} catch (ClassNotFoundException e) {
							System.out.println("ClientConnection ClassNotFound "+e.getMessage());
						}
						
					}
					*/
					
					
					/*				
					Scanner scanner = new Scanner(System.in);
					String echoString;
					String response;
					*/
					
					/*
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
					*/
					
					
					//----------------------------------------------------
					
					
					
					/*
					
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
						// test
						
																
					}
				
					*/
					
							
		} catch (IOException e) {
			System.out.println("Connection Problem "+e.getMessage());
		} 
	}
	
	
	public ClientThreadInput getClientThreadInput() {
		return clientThreadInput;
	}

	public void setClientThreadInput(ClientThreadInput clientThreadInput) {
		this.clientThreadInput = clientThreadInput;
	}

	public ClientThreadOutput getClientThreadOutput() {
		return clientThreadOutput;
	}

	public void setClientThreadOutput(ClientThreadOutput clientThreadOutput) {
		this.clientThreadOutput = clientThreadOutput;
	}
	
	/*
	public void sendMessageToServer(Message m) {
		try {
			this.outputStream.writeObject(m);
		} catch (IOException e) {
			System.out.println("Fehler ClientConnection sendMessageToServer "+e.getMessage());
			}
	}
	*/

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