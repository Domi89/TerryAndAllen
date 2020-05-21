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
	
	//private ObservableList<ServerThread> serverThreadsObservable = new ObservableList<ServerThread>();
	//protected ObservableList<ServerThread> serverThreads = FXCollections.;
	//protected ObservableList<ServerThread> serverThreads = FXCollections.observableArrayList();
	private ArrayList<Message> history;
	
	
	public ServerApplication() {
		this.history = new ArrayList<Message>();
		
		
	    Thread thread = new Thread(new Runnable() {
     
            public void run() {
                Runnable writeNewMessages = new Runnable() {

                    public void run() {
                        writeNewMessages();
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    writeNewMessages();
                }
            }

        });
		
        thread.setDaemon(true);
        
        thread.start();
		
		
		
		
		
		
		
		

		
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
	
	public ServerThread getServerThreadByClientName (String name) {
		ServerThread returnThread = null;
		if(this.serverThreads.size()>0) {
			for (int i = 0; i<this.serverThreads.size(); i++) {
				if(this.serverThreads.get(i).getClient().getClientName().equals(name)){
					return this.serverThreads.get(i);
				}
			}
		} 
		return returnThread;
		
	}
	
	
	private void writeNewMessages() {
		
		if (this.history!=null) {
			
			for (Message message: this.history) {
				if (message.getSent()) {
				} else {
					for (ServerThread sT: this.serverThreads) {
						sT.getServerThreadOutput().writeNewMessages(message);
						message.setSent(true);
					}
				}
			}
			
		}
	
		
	}

	
	
}
