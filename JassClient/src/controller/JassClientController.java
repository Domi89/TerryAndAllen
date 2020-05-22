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
		//this.view.getButton().setOnAction(e -> sendMessageView());
		
		
		
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
        
        
        
        
        
        
        
        
        
        
        //events für die MenuBar
        this.view.getColourChange().setOnAction(e-> colChange());
		
		this.view.getChat().getSendButton().setOnAction(e -> sendMessageToServer());
		
		//historyListener.add(new Message("test","test"));

	}
	
	private void cardUpdater() { 
		
		if(this.model.getUpdatedCards().size()>0 && 
				this.model.getUpdatedCards().get(this.model.getUpdatedCards().size()-1)==0) {
			
			System.out.println(this.model.getCards());
			if(this.model.getCards().size()>0) {
				
				newDeckReceived(this.model.getCards());
				//this.view.getCenter().getJcwpc().newDeckReceived(this.model.getCards());
			
			}
			//
			this.model.getUpdatedCards().set(this.model.getUpdatedCards().size()-1, 1);
	
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
		
		
		
		
		imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
		     public void handle(MouseEvent event) {
		    	
		    	 if(Connection.yourTurn) {
		    		 
		        	 System.out.println(cardNr);
			    	 //sendCard(event.getSource().getClass().getName());
			    	 
			       System.out.println("Tile pressed ");
			       event.consume();
			     
			       ImageView imageView = (ImageView) event.getSource();
			       view.getCenter().getJcwpc().getChildren().remove(event.getSource());
			       view.getCenter().getTisch().setBottom(imageView);
			       sendSelectedCard(cardNr); 
			       Connection.setYourTurn(false);
		    	 }
		    	      
		     }
		});
		
		
		this.view.getCenter().getJcwpc().getChildren().addAll(imageView);
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
		//       /images/Eichle Sibe.gif
		
	}
	
	
	
	


	
	


}
