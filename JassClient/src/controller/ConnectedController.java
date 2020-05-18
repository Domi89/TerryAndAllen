package controller;

import java.util.function.Supplier;

import model.Connection;
import view.JassClientConnectCenter;

public class ConnectedController extends Thread {
	

	private JassClientConnectCenter view;
	
	public ConnectedController (JassClientConnectCenter view) {
	
		this.view = view;
	}

	public void run() {
		
		while(true) {
			try {
				this.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Connection.connected) {
				System.out.println("Connected");
				//this.view.closeStage();
				this.view.closeStage();
				
				
			}
			
			
		}
		
		
	}
}
