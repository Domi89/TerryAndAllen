package BusinessLayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ServerConnection.GameStatus;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Suit;

public class BigRound {
	
	private ArrayList<SmallRound> smallRounds;
	private boolean finished = false;
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	public BigRound() {

	}
	
	public int getPoints(Client client) {
		int points = 0;
		
		for(SmallRound sr: smallRounds) {
			points =+ sr.getPoints();
		}

		return points;
	}
	
	public Client getWinner() {
		ArrayList<Client> copy = new ArrayList<Client>();
		copy = this.clients;
		Collections.sort(copy, new ClientComparator());	
		return copy.get(0);
	
	}

	public ArrayList<SmallRound> getSmallRounds() {
		return smallRounds;
	}

	public void setSmallRounds(ArrayList<SmallRound> smallRounds) {
		this.smallRounds = smallRounds;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	public void addSmallRounds(SmallRound sm) {
		this.smallRounds.add(sm);
		for(Card c: sm.getCards()) {
			this.clients.add(c.getClient());
		}
	
	}
	
	

	
	

}
