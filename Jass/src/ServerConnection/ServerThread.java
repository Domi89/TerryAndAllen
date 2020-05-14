package ServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import serializedClasses.Message;


public class ServerThread extends Thread{
	private Socket socket;
	private Object inputObject;
	private ObjectOutputStream outputStream;
	private ObjectInputStream inputStream;
	private ArrayList<Message> history;
		
	public ServerThread(Socket socket, ArrayList<Message> history) {
		this.socket = socket;

		this.history = history;
	}
	
	public void run() {
		
		try {
			
				this.inputStream = new ObjectInputStream(socket.getInputStream());
				this.outputStream = new ObjectOutputStream(socket.getOutputStream());
								
				ServerThreadInput serverThreadInput = new ServerThreadInput(this.inputStream, this.history);
				serverThreadInput.start();
				
				ServerThreadOutput serverThreadOutput = new ServerThreadOutput(this.outputStream, this.history);
				serverThreadOutput.start();
				
				while(true) {
					
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
}