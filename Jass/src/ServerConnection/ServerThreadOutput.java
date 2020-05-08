package ServerConnection;

import java.io.IOException;
import java.io.ObjectOutputStream;

import serializedClasses.MessageHistory;

public class ServerThreadOutput extends Thread{
	
	private ObjectOutputStream outputStream;
	private MessageHistory mh;
	
	public ServerThreadOutput(ObjectOutputStream outputStream, MessageHistory mh) {
		this.outputStream = outputStream;
		this.mh = mh;
	}
	
	public void run() {
		
		while(true) {
			try {
				currentThread().sleep(5000);
				
				if (mh != null) {
					this.outputStream.writeObject(this.mh);
				}
			
							
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted "+e.getMessage());
			} catch (IOException e) {
				System.out.println("IOException "+e.getMessage());
			}
		}
		
	}
	

	
}
