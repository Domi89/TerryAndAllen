package ServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApplication {

	public static void main (String[] args) {
		
		
		try(ServerSocket serverSocket = new ServerSocket(45138)){
			
			
			
			while(true) {
				
				Socket socket = serverSocket.accept();
				ServerThread serverThread = new ServerThread(socket);
				serverThread.start();
						
			}
			
		} catch(IOException e){
			System.out.println("Serverexception: "+e.getMessage());			
		}
	}
}
