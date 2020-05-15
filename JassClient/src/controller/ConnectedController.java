package controller;

import view.JassClientConnectCenter;

public class ConnectedController extends Thread {
	
	private Boolean connected;
	private JassClientConnectCenter view;
	
	public ConnectedController (Boolean connected, JassClientConnectCenter view) {
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
			if(connected) {
				
				this.view.closeStage();
			}
			
			
		}
		
		
	}
}
