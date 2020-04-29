package connection;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

import serializedClasses.Message;

public class MessageThread extends Thread{
	
	private ObjectOutputStream outputStream;
	
	public MessageThread(ObjectOutputStream outputStream) throws IOException, InterruptedException {
		this.outputStream = outputStream;
		
		while(true) {
			this.sleep(5000);
			Message m = new Message("test", "message");
			this.outputStream.writeObject(m);
			System.out.println("Message gesendet");
		}

	}

}
