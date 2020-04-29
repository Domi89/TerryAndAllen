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
			
			
			//Creates a socket and waits until the client is connected
			Socket socket = serverSocket.accept();
			System.out.println("Client connected");
			
			BufferedReader input = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			PrintWriter output = new PrintWriter(socket.getOutputStream(),true);
			
			while(true) {
				String echoString=input.readLine();
				if(echoString.equals("exit")) {
					break;
				}
				output.println("Echo from Server "+echoString);
				
			}
			
		} catch(IOException e){
			System.out.println("Serverexception: "+e.getMessage());			
		}
	}
}
