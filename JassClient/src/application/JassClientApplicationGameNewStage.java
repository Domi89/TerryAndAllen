package application;

import java.util.ArrayList;

import controller.ConnectCenterController;
import controller.JassClientController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import model.JassClientModel;
import serializedClasses.Message;
import view.JassClientConnectCenter;
import view.JassClientView;

public class JassClientApplicationGameNewStage{

	JassClientModel model;
	JassClientView view;
	JassClientController controller;
	
	public JassClientApplicationGameNewStage(Stage stage, JassClientModel model) {
		this.view = new JassClientView(stage, model);
		controller = new JassClientController(model, view);
		
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
		
	}
	
	
	private void updater() { 
		//this.view.getChat().getLabelChat().setText("FETTSACK");
		String gay = new String();
		gay = this.model.getClientThread().getClientThreadInput().getHistory().toString();
		this.view.getChat().getLabelChat().setText(gay);
		
		
		
	}
	
}
