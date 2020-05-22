package model;

public class Connection {
	
	public static Boolean connected;
	public static Boolean yourTurn = false;
	
	
	public static void Connection() {
		
	}
	
	public Boolean getConnected() {
		return this.connected;
	}
	
	public static void setYourTurn(Boolean b) {
		yourTurn = b;
		System.out.println("Your turn");
	}
}
