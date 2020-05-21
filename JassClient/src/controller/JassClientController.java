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
		
		
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                Runnable updater = new Runnable() {

                    @Override
                    public void run() {
                        updater();
                    }
                };

                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }

                    // UI update is run on the Application thread
                    Platform.runLater(updater);
                }
            }

        });
		
        thread.setDaemon(true);
        
        thread.start();
	
        //events für die MenuBar
        this.view.getColourChange().setOnAction(e-> colChange());
		
		this.view.getChat().getSendButton().setOnAction(e -> sendMessageToServer());
		
		//historyListener.add(new Message("test","test"));

	}

	private void colChange() {
		this.view.changeTable();
	}

	private void updater() { 
			
		ArrayList<Message> messagesArrayList = new ArrayList<Message>();
		
		for (int i = 0; i<this.model.getClientThread().getClientThreadInput().getHistory().size(); i++) {
			messagesArrayList.add(this.model.getClientThread().getClientThreadInput().getHistory().get(i));
		}
		
		String messageString = "";
		
		for(Message m : messagesArrayList) {
			messageString+=m.getClientName()+": "+m.getMessage()+"\n";
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
