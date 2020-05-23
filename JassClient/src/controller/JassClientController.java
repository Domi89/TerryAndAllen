package controller;


import java.util.ArrayList;
import java.util.List;

import application.JassClientApplicationConnection;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Connection;
import model.JassClientModel;
import serializedClasses.Card;
import serializedClasses.Message;
import serializedClasses.Rank;
import serializedClasses.Rule;
import serializedClasses.Suit;
import view.JassClientConnectCenter;
import view.JassClientView;

public class JassClientController {
	
	private JassClientModel model;
	private JassClientView view;
	private JassClientApplicationConnection start = new JassClientApplicationConnection();
	private ObservableList<Message> messageHistory = FXCollections.observableList(new ArrayList<Message>());
	
	
	
	public JassClientController(JassClientModel model, JassClientView view) {
		this.model = model;
		this.view = view;
	
		//Message Label updater
        Thread threadMessage = new Thread(new Runnable() {
            public void run() {
                Runnable updaterMessage = new Runnable() {
                    public void run() {
                        updaterMessage();
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updaterMessage);
                }
            }
        });
        threadMessage.setDaemon(true);
        threadMessage.start();
	
        
        
        
        Thread threadCardUpdater = new Thread(new Runnable() {
            public void run() {
                Runnable cardUpdater = new Runnable() {
                    public void run() {
                    	cardUpdater();
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(cardUpdater);
                }
            }
        });
        threadCardUpdater.setDaemon(true);
        threadCardUpdater.start(); 
        
        
        
        
        Thread threadTischUpdater = new Thread(new Runnable() {
            public void run() {
                Runnable threadTischUpdater = new Runnable() {
                    public void run() {
                    	threadTischUpdater();
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(threadTischUpdater);
                }
            }
        });
        threadTischUpdater.setDaemon(true);
        threadTischUpdater.start(); 
        
        
        Thread threadClientsUpdater = new Thread(new Runnable() {
            public void run() {
                Runnable threadClientsUpdater = new Runnable() {
                    public void run() {
                    	threadClientsUpdater();
                    }
                };
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(threadClientsUpdater);
                }
            }
        });
        threadClientsUpdater.setDaemon(true);
        threadClientsUpdater.start(); 
        
        

        //events für die MenuBar
        this.view.getColourChange().setOnAction(e-> colChange());
		
		this.view.getChat().getSendButton().setOnAction(e -> sendMessageToServer());
		
		//historyListener.add(new Message("test","test"));

	}
	
	
	//updates after each Card the cards on Table & the ScoreBoard
	private void cardUpdater() { 
		
		if(this.model.getUpdatedCards().size()>0 && 
				this.model.getUpdatedCards().get(this.model.getUpdatedCards().size()-1)==0) {
			
			System.out.println(this.model.getCards());
			if(this.model.getCards().size()>0) {
				
				newDeckReceived(this.model.getCards());
						
			}
		
			this.model.getUpdatedCards().set(this.model.getUpdatedCards().size()-1, 1);
		}
		
		if(this.model.getScores().size()>0&&!this.model.getScores().get(this.model.getScores().size()-1).isShowed()) {
			
			String scoreString = this.model.getScores().get(this.model.getScores().size()-1).toString();
			this.view.getScore().getScoreLabel().setText(scoreString);
		
			this.model.getScores().get(this.model.getScores().size()-1).setShowed(true);
		}
		
	}
	
	
	private void threadClientsUpdater() { 
		
		if (this.model.getClients().size()>0) {
			if (Connection.getPlayersCount()==2) {
				if(this.model.getClient().getClientName().equals(this.model.getClients().get(0).getClientName())){
					this.view.getCenter().getTisch().getPlayerNames().get(0).setText(this.model.getClients().get(0).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(1).setText(this.model.getClients().get(1).getClientName());
				} else {
					this.view.getCenter().getTisch().getPlayerNames().get(1).setText(this.model.getClients().get(0).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(0).setText(this.model.getClients().get(1).getClientName());
				}
			}
			if (Connection.getPlayersCount()==4) {
				if(this.model.getClient().getClientName().equals(this.model.getClients().get(0).getClientName())){
					this.view.getCenter().getTisch().getPlayerNames().get(0).setText(this.model.getClients().get(0).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(1).setText(this.model.getClients().get(1).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(2).setText(this.model.getClients().get(2).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(3).setText(this.model.getClients().get(3).getClientName());
				} 
				if(this.model.getClient().getClientName().equals(this.model.getClients().get(1).getClientName())){
					this.view.getCenter().getTisch().getPlayerNames().get(0).setText(this.model.getClients().get(1).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(1).setText(this.model.getClients().get(2).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(2).setText(this.model.getClients().get(3).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(3).setText(this.model.getClients().get(0).getClientName());
				} 
				if(this.model.getClient().getClientName().equals(this.model.getClients().get(2).getClientName())){
					this.view.getCenter().getTisch().getPlayerNames().get(0).setText(this.model.getClients().get(2).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(1).setText(this.model.getClients().get(3).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(2).setText(this.model.getClients().get(0).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(3).setText(this.model.getClients().get(1).getClientName());
				} 
				if(this.model.getClient().getClientName().equals(this.model.getClients().get(3).getClientName())){
					this.view.getCenter().getTisch().getPlayerNames().get(0).setText(this.model.getClients().get(3).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(1).setText(this.model.getClients().get(0).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(2).setText(this.model.getClients().get(1).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(3).setText(this.model.getClients().get(2).getClientName());
				} 
			}
			if (Connection.getPlayersCount()==3) {
				if(this.model.getClient().getClientName().equals(this.model.getClients().get(0).getClientName())){
					this.view.getCenter().getTisch().getPlayerNames().get(0).setText(this.model.getClients().get(0).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(1).setText(this.model.getClients().get(1).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(2).setText(this.model.getClients().get(2).getClientName());
				} 
				if(this.model.getClient().getClientName().equals(this.model.getClients().get(1).getClientName())){
					this.view.getCenter().getTisch().getPlayerNames().get(0).setText(this.model.getClients().get(1).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(1).setText(this.model.getClients().get(2).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(3).setText(this.model.getClients().get(0).getClientName());
				} 
				if(this.model.getClient().getClientName().equals(this.model.getClients().get(2).getClientName())){
					this.view.getCenter().getTisch().getPlayerNames().get(0).setText(this.model.getClients().get(2).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(2).setText(this.model.getClients().get(0).getClientName());
					this.view.getCenter().getTisch().getPlayerNames().get(3).setText(this.model.getClients().get(1).getClientName());
				} 
			}
			
		}
		
		
	}
	
	
	private void threadTischUpdater() { 
		if(Connection.getNewCardToShow()) {
			Card playedCard = Connection.getCardsOnTable().get(Connection.getCardsOnTable().size()-1);
			String cardPlayedFrom = playedCard.getClient().getClientName();
			int positionToUpdate = this.view.getCenter().getTisch().getPosition(cardPlayedFrom);
			
			this.view.getCenter().getTisch().addCard(positionToUpdate, playedCard.getCardNr());

			Connection.setNewCardToShow(false);
		}

		
		
	}
	
	

	private void colChange() {
		this.view.changeTable();
	}

	
	
	
	
	//Message Label updater
	private void updaterMessage() { 
			
		ArrayList<Message> messagesArrayList = new ArrayList<Message>();
		
		for (int i = 0; i<this.model.getClientThread().getClientThreadInput().getHistory().size(); i++) {
			messagesArrayList.add(this.model.getClientThread().getClientThreadInput().getHistory().get(i));
		}
		
		String messageString = "";
		
		for(Message m : messagesArrayList) {
			messageString+="  "+m.getClientName()+": "+m.getMessage()+"\n";
		}
		
		this.view.getChat().getLabelChat().setText(messageString);
	}
	
	
	
	
	private void sendMessageToServer() {
		
		String messageText = this.view.getChat().getChatField().getText();
		if(!messageText.equals("")) {
			Message message = new Message(this.model.getClient().getClientName(), messageText);
			this.model.getClientThread().getClientThreadOutput().sendMessageToServer(message);
			this.view.getChat().getChatField().setText("");
		}
	}
	
	public void newDeckReceived(ObservableList<Card> cards) {
		
		this.view.getCenter().getJcwpc().getChildren().clear();
		for (Card c: cards) {
			
			
			String suit = c.getSuit().name();
			String rank = c.getRank().name();
			
			String cardNr ="/images/"+suit+" "+rank+".gif";
			System.out.println("CARDNUMMER:"+cardNr+"ENDE");
			createCard(cardNr);		
		}
	}
	
	private void createCard(String cardNr) {
		Image image = new Image(cardNr,100,150,false,false); 
		
		ImageView imageView = new ImageView(image);	
		
	  	 if(Connection.getChooseMode()) {
    		 
    		 view.getBottomView().getObeAbe().setDisable(false);
    		 view.getBottomView().getUndeUfe().setDisable(false);
    		 view.getBottomView().getTrumpf().setDisable(false);
    		 
    		 
    		 
    		 view.getBottomView().getObeAbe().setOnAction(e-> activateObeAbe());
    		 view.getBottomView().getUndeUfe().setOnAction(e-> activateUndeUfe());
    		 view.getBottomView().getTrumpf().setOnAction(e-> activateTrumpf());
    		 
    	      
    		 

    	 }
    	 
		
		
		imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
		     public void handle(MouseEvent event) {
		    	
		    	 
		    	 

		    	 
		    	 
		    	 
		    	 
		    	 
		    	 if(Connection.yourTurn && !Connection.getChooseMode()) {
		    		 
		        	 System.out.println(cardNr);
 
			       System.out.println("Tile pressed ");
			       event.consume();
			     
			       ImageView imageView = (ImageView) event.getSource();
			       view.getCenter().getJcwpc().getChildren().remove(event.getSource());
			       
			       view.getCenter().getTisch().addCard(0, cardNr);
		
			       sendSelectedCard(cardNr); 
			       Connection.setYourTurn(false);
		    	 }
		    	      
		     }


		});
		
		
		this.view.getCenter().getJcwpc().getChildren().addAll(imageView);
	} 
	
	private Object activateUndeUfe() {
		 view.getBottomView().getObeAbe().setDisable(true);
		 view.getBottomView().getUndeUfe().setDisable(true);
		 view.getBottomView().getTrumpf().setDisable(true);
		 model.getClientThread().getClientThreadOutput().sendRule(Rule.undeUfe);
		 Connection.setChooseMode(false);
		 
		return null;
	}

	private Object activateObeAbe() {
		 view.getBottomView().getObeAbe().setDisable(true);
		 view.getBottomView().getUndeUfe().setDisable(true);
		 view.getBottomView().getTrumpf().setDisable(true);
		 model.getClientThread().getClientThreadOutput().sendRule(Rule.obeAbe);
		 Connection.setChooseMode(false);
		return null;
	}

	private void activateTrumpf() {
		
		 view.getBottomView().getObeAbe().setDisable(true);
		 view.getBottomView().getUndeUfe().setDisable(true);
		 view.getBottomView().getTrumpf().setDisable(true);
		 model.getClientThread().getClientThreadOutput().sendRule(Rule.trumpf);

		 
		 view.getBottomView().getSchaelle().setDisable(false);
		 view.getBottomView().getEichle().setDisable(false);
		 view.getBottomView().getSchilte().setDisable(false);
		 view.getBottomView().getRose().setDisable(false);

		 view.getBottomView().getSchaelle().setOnAction(e-> activateSchaelle());
		 view.getBottomView().getEichle().setOnAction(e-> activateEichle());
		 view.getBottomView().getSchilte().setOnAction(e-> activateSchilte());
		 view.getBottomView().getRose().setOnAction(e-> activateRose());
		 
	}

	private void activateSchilte() {
		 view.getBottomView().getSchaelle().setDisable(true);
		 view.getBottomView().getEichle().setDisable(true);
		 view.getBottomView().getSchilte().setDisable(true);
		 view.getBottomView().getRose().setDisable(true);
		 
		 model.getClientThread().getClientThreadOutput().sendColor(Suit.Schilte);
		 Connection.setChooseMode(false);
	
	}

	private void activateRose() {
		 view.getBottomView().getSchaelle().setDisable(true);
		 view.getBottomView().getEichle().setDisable(true);
		 view.getBottomView().getSchilte().setDisable(true);
		 view.getBottomView().getRose().setDisable(true);
		 
		 model.getClientThread().getClientThreadOutput().sendColor(Suit.Rose);
		 Connection.setChooseMode(false);
	}

	private void activateEichle() {
		 view.getBottomView().getSchaelle().setDisable(true);
		 view.getBottomView().getEichle().setDisable(true);
		 view.getBottomView().getSchilte().setDisable(true);
		 view.getBottomView().getRose().setDisable(true);
		 
		 model.getClientThread().getClientThreadOutput().sendColor(Suit.Eichle);
		 Connection.setChooseMode(false);
	}

	private void activateSchaelle() {
		 view.getBottomView().getSchaelle().setDisable(true);
		 view.getBottomView().getEichle().setDisable(true);
		 view.getBottomView().getSchilte().setDisable(true);
		 view.getBottomView().getRose().setDisable(true);
		 
		 model.getClientThread().getClientThreadOutput().sendColor(Suit.Schaelle);
		 Connection.setChooseMode(false);
		
	}
	
	
	public void sendSelectedCard(String cardNr) {
				
		String[] splitStr = cardNr.split("\\s+");
		
		String suit = splitStr[0];
		String rank = splitStr[1];
		
		suit = suit.replace("/images/", "");
		rank = rank.replace(".gif", "");
		
	
		Card card = new Card(Suit.valueOf(suit), Rank.valueOf(rank));
		
		this.model.getClientThread().getClientThreadOutput().sendCardToServer(card);
		
		System.out.println("suit "+suit);
		System.out.println("rank "+rank);
		
	}
	
	
	
	


	
	


}
