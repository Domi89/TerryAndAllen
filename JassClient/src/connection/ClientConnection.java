package connection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ClientConnection {
	
	public ClientConnection() {
		try(Socket socket = new Socket("localhost", 45138)){
			
			BufferedReader echoes = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
			PrintWriter stringToEcho = new PrintWriter(socket.getOutputStream(), true);
		
			Scanner scanner = new Scanner(System.in);
			String echoString;
			String response;
			
			do {
				System.out.println("String to be echoed ");
				echoString = scanner.nextLine();
				stringToEcho.println(echoString);
				if(!echoString.contentEquals("Exit")) {
					response = echoes.readLine();
					System.out.println(response);
				}
	
			} while (!echoString.equals("exit"));				
			
		} catch(IOException e) {
			System.out.println("Client Error: "+e.getMessage());
		}
	}

}
