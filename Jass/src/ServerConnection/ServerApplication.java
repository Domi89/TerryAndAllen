package ServerConnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import BusinessLayer.Constants;
import BusinessLayer.Deck;
import BusinessLayer.Rule;
import serializedClasses.Card;
import serializedClasses.Client;
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
		
		
        
        
        Thread threadAllPlayersConnected = new Thread(new Runnable() {
            
            public void run() {
                Runnable threadAllPlayersConnected = new Runnable() {

                    public void run() {
                    	threadAllPlayersConnectedStart();
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    threadAllPlayersConnectedStart();
                }
            }

            
            
            // überprüft ob alle Spieler verbunden sind
			private void threadAllPlayersConnectedStart() {
				if (serverThreads.size()==Constants.MAX_PLAYERS && gameStatus == 0) {
					Deck deck = new Deck();
					int playerNumber = 0;
					
					for (ServerThread sT: serverThreads) {
						sT.setClient();
					}
					
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
					gameStatus=1;
					
									
					ArrayList<Client> clients = new ArrayList<Client>();
					
					for (ServerThread sT: serverThreads) {
						clients.add(sT.getClient());
					}
					for (ServerThread sT: serverThreads) {
						sT.getServerThreadOutput().sendClients(clients);
					}
					
					
					
				}
			}
        });
        threadAllPlayersConnected.setDaemon(true);
        threadAllPlayersConnected.start();
		
        
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
						
						
						if (!sT.getClient().getClientName().equals(receivedCard.getClient().getClientName())) {
							
							sT.getServerThreadOutput().sendCard(receivedCard);
						}
					
					}
					GameStatus.setNewCard(false);
				
					
					// send Message to Next Player				
			
					sendYourTurnToNextPlayer();
					

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
	
	public void sendYourTurnToNextPlayer() {
		
		Iterator<ServerThread> iti = serverThreads.iterator();
		
		Client nextPlayer = null;
		
		while (iti.hasNext()) {
			if(iti.next().getClient().getClientName().equals(GameStatus.getLastPlayed().getClientName())) {
				if(iti.hasNext()) {
					nextPlayer = iti.next().getClient();
				} else {
					nextPlayer = serverThreads.get(0).getClient();
				}
			}
		}
		
		getServerThreadByClientName(nextPlayer.getClientName()).getServerThreadOutput().sendString("yourTurn");
		
		
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
