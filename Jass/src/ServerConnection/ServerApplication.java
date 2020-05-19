package ServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import serializedClasses.Message;

public class ServerApplication {

	//private MessageHistory messageHistory;
	
	private ArrayList<ServerThread> serverThreads = new ArrayList<ServerThread>();
	

	public ServerApplication(ArrayList<Message> history) {
		

		
		try(ServerSocket serverSocket = new ServerSocket(45138)){
			
			while(true) {
				
				Socket socket = serverSocket.accept();
				//TODO eventuel serialize weil mehrere Threads darauf zugreifen.
				
				serverThreads.add(new ServerThread(socket, history));
				serverThreads.get(serverThreads.size()-1).start();

						
			}
			
		} catch(IOException e){
			System.out.println("Serverexception: "+e.getMessage());			
		}	
		
		
	}
	
	public ArrayList<ServerThread> getServerThreads() {
		return serverThreads;
	}

	public void setServerThreads(ArrayList<ServerThread> serverThreads) {
		this.serverThreads = serverThreads;
	}

	
}
