package ServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread{
	private Socket socket;
	
	public ServerThread(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		try {
			BufferedReader input = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
					
			while(true) {
				String echoString = input.readLine();
				System.out.println("Received client input: "+echoString);
				if(echoString.equals("exit")) {
					break;
				}
				output.println(echoString);		
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
