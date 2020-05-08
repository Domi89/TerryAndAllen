package ServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import serializedClasses.MessageHistory;

public class ServerApplication {

	public static void main (String[] args) {
		
		//TODO Messages must be saved in the BusinessLayer / Model
		MessageHistory mh = new MessageHistory();
		
		try(ServerSocket serverSocket = new ServerSocket(45138)){
			
			while(true) {
				
				Socket socket = serverSocket.accept();
				//TODO eventuel serialize weil mehrere Threads darauf zugreifen.
				ServerThread serverThread = new ServerThread(socket, mh);
				serverThread.start();
						
			}
			
		} catch(IOException e){
			System.out.println("Serverexception: "+e.getMessage());			
		}
	}
}
