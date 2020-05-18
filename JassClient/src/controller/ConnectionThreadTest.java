package controller;

import model.Connection;
import view.JassClientConnectCenter;

public class ConnectionThreadTest extends Thread{
	
	private JassClientConnectCenter view;
	
	public ConnectionThreadTest (JassClientConnectCenter view) {
		this.view = view;
	}
	
	public void run() {
		
		while (true) {
			
			try {
				this.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Connection.connected) {
				
			}
			
			
			
		}
	}
}
