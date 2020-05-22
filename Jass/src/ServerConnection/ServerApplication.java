package ServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import BusinessLayer.Constants;
import BusinessLayer.Deck;
import BusinessLayer.Rule;
import serializedClasses.Card;
import serializedClasses.Message;
import serializedClasses.Suit;

public class ServerApplication {

	//private MessageHistory messageHistory;
	
	private ArrayList<ServerThread> serverThreads = new ArrayList<ServerThread>();
	
	private ArrayList<Message> history;
	//

	
	private Rule rule;
	private Suit trumpf;
	
	//0=no game startet , 1=game in progress
	private int gameStatus = 0;
	
	
	
	public ServerApplication() {
		this.history = new ArrayList<Message>();
		this.rule = null;
		this.trumpf = null;
		
		
		// schreibt Messages allen Clients
	    Thread threadWriteMessages = new Thread(new Runnable() {
     
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
        threadWriteMessages.setDaemon(true);
        threadWriteMessages.start();
		
		
        
        
        Thread thread4PlayersConnected = new Thread(new Runnable() {
            
            public void run() {
                Runnable thread4PlayersConnected = new Runnable() {

                    public void run() {
                    	thread4PlayersConnectedStart();
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    thread4PlayersConnectedStart();
                }
            }

			private void thread4PlayersConnectedStart() {
				
				
				if (serverThreads.size()==Constants.MAX_PLAYERS && gameStatus == 0) {
					Deck deck = new Deck();
					int playerNumber = 0;
					
					
					for (ServerThread sT: serverThreads) {
					
						
						ArrayList<Card> sendCards = new ArrayList<Card>();
						
						for(int i = 0; i<9; i++) {
							sendCards.add(deck.getCards().pop());
						}
						
						sT.getServerThreadOutput().sendCards(sendCards);
						
						if (playerNumber==0) {
							sT.getServerThreadOutput().sendString("yourTurn");
						}
						
						playerNumber++;
						
					}
					
					gameStatus = 1;
				}
				
			}

        });
        thread4PlayersConnected.setDaemon(true);
        thread4PlayersConnected.start();
		
        
        //------------------------
        
        
        Thread newCardReceivedFromClient = new Thread(new Runnable() {
            
            public void run() {
                Runnable newCardReceivedFromClient = new Runnable() {

                    public void run() {
                    	newCardReceivedFromClient();
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    newCardReceivedFromClient();
                }
            }

			private void newCardReceivedFromClient() {
				
				if(GameStatus.getNewCard()) {
					
					for (ServerThread sT: serverThreads) {
						Card receivedCard = GameStatus.getCurrentSmallRound().get(GameStatus.getCurrentSmallRound().size()-1);
						
						System.out.println("KARTE VON: "+receivedCard.getClient().getClientName());
						System.out.println("KARTE VON: "+sT.getClient().getClientName());
						
						//if (!sT.getClient().getClientName().equals(receivedCard.getClient().getClientName())) {
						//	sT.getServerThreadOutput().sendCard(receivedCard);
						//}
					
					}
					GameStatus.setNewCard(false);
				}
				
			}

        });
        newCardReceivedFromClient.setDaemon(true);
        newCardReceivedFromClient.start();
		
        //------------------------
		

		
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
