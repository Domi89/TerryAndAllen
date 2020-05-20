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

import javafx.collections.ObservableList;
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
	private ArrayList<Message> history;
	private String ip;
	private int port;
	
	
	public ClientThread (Client client, ArrayList<Message> history, String ip, int port) {
		this.client = client;
		this.history = history;
		this.ip = ip;
		this.port = port;
		
	}
	
	
	
	public ClientThread (Client client, ArrayList<Message> history) {
		this.client = client;
		this.history = history;
		this.ip = "localhost";
		this.port = 45138;
		
	}
	
	public void run() {
		
		try(Socket socket = new Socket(this.ip, this.port)){
							
					this.outputStream = new ObjectOutputStream(socket.getOutputStream());
					this.inputStream = new ObjectInputStream(socket.getInputStream());

					this.clientThreadInput = new ClientThreadInput(this.inputStream, this.client, this.history);
					this.clientThreadInput.start();
					
					this.clientThreadOutput = new ClientThreadOutput(this.outputStream, this.client, this.history);
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

	
	
}