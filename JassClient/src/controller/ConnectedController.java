package controller;

import java.util.function.Supplier;

import model.Connection;
import view.JassClientConnectCenter;

public class ConnectedController extends Thread {
	
	private Supplier<Boolean> connected;
	private JassClientConnectCenter view;
	
	public ConnectedController (Supplier<Boolean> connected, JassClientConnectCenter view) {
		this.connected = connected;
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
			System.out.println(connected);
			if(Connection.connected) {
				System.out.println("Connected");
				//this.view.closeStage();
			}
			
			
		}
		
		
	}
}
