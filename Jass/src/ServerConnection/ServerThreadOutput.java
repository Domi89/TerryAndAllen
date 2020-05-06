package ServerConnection;

import java.io.ObjectOutputStream;

public class ServerThreadOutput extends Thread{
	
	private ObjectOutputStream outputStream;
	
	public ServerThreadOutput(ObjectOutputStream outputStream) {
		this.outputStream = outputStream;
	}
	
	public void run() {
		
	}
	
}
