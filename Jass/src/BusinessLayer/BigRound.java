package BusinessLayer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ServerConnection.GameStatus;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Suit;

public class BigRound {
	
	private ArrayList<SmallRound> smallRounds = new ArrayList<SmallRound>();
	private boolean finished = false;
	
	private ArrayList<Client> clients = new ArrayList<Client>();
	
	public ArrayList<Client> getClients() {
		return clients;
	}

	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}

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
		
		
		
		if(Constants.MAX_PLAYERS==2) {
			int cardsPlayed = this.smallRounds.size()*2;
			if(cardsPlayed==18) {
				bigRoundFinished();
			}
		}
		if(Constants.MAX_PLAYERS==3) {
			int cardsPlayed3 = this.smallRounds.size()*3;
			if(cardsPlayed3==27) {
				bigRoundFinished();
			}
		}
		if(Constants.MAX_PLAYERS==4) {
			int cardsPlayed4 = this.smallRounds.size()*4;
			if(cardsPlayed4==36) {
				bigRoundFinished();
			}
		}
	}
	
	public void bigRoundFinished() {
		
		
		
	}
	
	

	
	

}
