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


public class ClientThread extends Thread{
	
	private Socket socket;
	private Object inputObject;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private Client client;
	private ClientThreadInput clientThreadInput;
	private ClientThreadOutput clientThreadOutput;

	public ClientThread (Client client) {
		this.client = client;
	}
	
	public void run() {
		
		try(Socket socket = new Socket("localhost", 45138)){
							
			
					this.outputStream = new ObjectOutputStream(socket.getOutputStream());
					this.inputStream = new ObjectInputStream(socket.getInputStream());
					
					this.clientThreadInput = new ClientThreadInput(this.inputStream, this.client);
					this.clientThreadInput.start();
					
					this.clientThreadOutput = new ClientThreadOutput(this.outputStream, this.client);
					this.clientThreadOutput.start();
					
					while(true) {
						
					}
					
			
						
					
											
		} catch (IOException e) {
			System.out.println("Connection Problem "+e.getMessage());
		} 
	}
	
	
	public ClientThreadInput getClientThreadInput() {
		return clientThreadInput;
	}


	public ClientThreadOutput getClientThreadOutput() {
		return clientThreadOutput;
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