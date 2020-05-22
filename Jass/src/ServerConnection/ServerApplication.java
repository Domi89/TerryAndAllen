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
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Message;
import serializedClasses.Rule;
import serializedClasses.Score;
import serializedClasses.Suit;

public class ServerApplication {

	private ArrayList<ServerThread> serverThreads = new ArrayList<ServerThread>();
	private int gameStatus = 0;
	private String sentScore ="";
	
	
	public ServerApplication() {
		

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

                    writeNewMessages();
                }
            }

        });
	    
	    
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
							sT.getServerThreadOutput().sendString("chooseMode");
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
				if(GameStatus.getSmallRound().getCards().size()>0) {
					Card receivedCard = GameStatus.getSmallRound().getCards().get(GameStatus.getSmallRound().getCards().size()-1);
					if (!sT.getClient().getClientName().equals(receivedCard.getClient().getClientName())) {
						sT.getServerThreadOutput().sendCard(receivedCard);
					}
				}
		
				//TODO DELETE
			}
			GameStatus.setNewCard(false);
			
			Boolean finished = GameStatus.smallRoundFinished();
		
			
			
			// send Message to Next Player				
	
			sendYourTurnToNextPlayer();
			

		}
		
		

		
	}

	});




	Thread sendScoreToClients = new Thread(new Runnable() {
	    
	    public void run() {
	        Runnable sendScoreToClients = new Runnable() {
	
	            public void run() {
	            	sendScoreToClients();
	            }
	        };
	        while (true) {
	            try {
	                Thread.sleep(5000);
	            } catch (InterruptedException ex) {
	            }
	
	            // UI update is run on the Application thread
	            
	            
	            sendScoreToClients();
	        }
	    }
	
		private void sendScoreToClients() {
			
			for (ServerThread sT: serverThreads) {
				Score score = new Score(GameStatus.getScore());
				sT.getServerThreadOutput().sendScore(score);
	
			}
			
			
		}
	
	});
	    
	    

	    threadWriteMessages.setDaemon(true);
        threadWriteMessages.start();
		
		

    	        
        
        
        
        
        
        
        //------------------------
		

		
		try(ServerSocket serverSocket = new ServerSocket(45138)){
			
			while(serverThreads.size()<Constants.MAX_PLAYERS) {
				
				Socket socket = serverSocket.accept();
				
				serverThreads.add(new ServerThread(socket));
				serverThreads.get(serverThreads.size()-1).start();
	
			}
			
	        threadAllPlayersConnected.setDaemon(true);
	        threadAllPlayersConnected.start();
	        
	        
	    	newCardReceivedFromClient.setDaemon(true);
	    	newCardReceivedFromClient.start();
	        
	  
	        sendScoreToClients.setDaemon(true);
	        sendScoreToClients.start();
			
			
			
			
			
			
		} catch(IOException e){
			System.out.println("Serverexception: "+e.getMessage());			
		}	
		
		
	}
	
	public ArrayList<ServerThread> getServerThreads() {
		return serverThreads;
	}
	
	public void sendYourTurnToNextPlayer() {
		
		if(GameStatus.getLastWinner()!=null) {
			
			Client nextPlayer = GameStatus.getLastWinner();

			getServerThreadByClientName(nextPlayer.getClientName()).getServerThreadOutput().sendString("yourTurn");
			
			GameStatus.setLastWinner(null);
			
		} else {
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
		
		if (GameStatus.getHistory().size()>=0) {
			
			for (Message message: GameStatus.getHistory()) {
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
