package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Supplier;

import serializedClasses.Client;
import serializedClasses.Message;


public class ClientThread2 extends Thread{
	
	private Socket socket;
	private Object inputObject;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private Client client;
	private ArrayList<Message> history;
	private String ip;
	private int port;

	
	public ClientThread2 (Client client, ArrayList<Message> history, String ip, int port) {
		this.client = client;
		this.history = history;
		this.ip = ip;
		this.port = port;

		
	}
	
	public ClientThread2 (Client client, ArrayList<Message> history) {
		this.client = client;
		this.history = history;
		this.ip = "localhost";
		this.port = 45138;
	}
	
	public void run() {
		
		try(Socket socket = new Socket(this.ip, this.port)){
					
			this.outputStream = new ObjectOutputStream(socket.getOutputStream());
			this.inputStream = new ObjectInputStream(socket.getInputStream());
			
			

			while(true) {
				
		
				
				//-----INPUT
				
				try {
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
					
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				//-----INPUT
				// -----OUTPUT----- 
				
				try {
					currentThread().sleep(5000);
					this.sendClientToServer();
					
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

				
				
				
			}
			
	
		} catch (IOException e) {
			System.out.println("Connection Problem "+e.getMessage());
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
	
	public void sendClientToServer() {
		try {
			Client sC = this.client;
			this.outputStream.writeObject(sC);
			System.out.println("Sent Client name: "+sC.getClientName());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	private void stringClass(String string) {
		if(string.equals("Connected")) {
			Connection.connected = true;
			
		}
	}


	


}