package serializedClasses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class GameFinished implements Serializable{
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	private int maxPoints = 0;
	private Client winner;
	
	
	
	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

	public int getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}

	public Client getWinner() {
		return winner;
	}

	public void setWinner(Client winner) {
		this.winner = winner;
	}


	
	
	public GameFinished() {
		
	}
	
	public int getPointsClient(Client client) {
		int i = 0;
		for (Client c: clients) {
			if(c.getClientName().equals(client.getClientName())) {
				i = c.getPointsBig();
			}
		}
		return i;
	}
	

	

}
