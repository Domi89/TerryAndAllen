package controller;

import java.util.ArrayList;
import java.util.List;

import application.JassClientApplicationConnection;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import model.JassClientModel;
import serializedClasses.Message;
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
                        Thread.sleep(1000);
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
                        Thread.sleep(1000);
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
		System.out.println(this.model.getCards());
		if(this.model.getCards().size()>0) {
			this.view.getCenter().getJcwpc().newDeckReceived(this.model.getCards());
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


	
	


}
