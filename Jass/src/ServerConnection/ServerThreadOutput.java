package ServerConnection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import serializedClasses.Message;

public class ServerThreadOutput extends Thread{
	
	private ObjectOutputStream outputStream;

	private ArrayList<Message> history;
	
	public ServerThreadOutput(ObjectOutputStream outputStream, ArrayList<Message> history) {
		this.outputStream = outputStream;
		this.history = history;
	}
	
	public void run() {
		
		while(true) {
			try {
				currentThread().sleep(5000);
				
				writeNewMessages();
									
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted "+e.getMessage());
			} 
		}

		
	}

	private void writeNewMessages() {
		
		for (Message message: history) {
			if (message.getSent()) {
			} else {
				try {
					this.outputStream.writeObject(message);
					message.setSent(true);
				} catch (IOException e) {
					System.out.println("Error ServerthreadOutPut"+e.getMessage());
				}
			}
		}
		
	}
	

	
}
