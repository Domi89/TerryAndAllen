package serializedClasses;

import java.io.Serializable;

public class Card implements Comparable<Card>, Serializable {
	// h
	private Suit suit;
	private Rank rank;
	
	//if Card is played, Client will added to the played card
	private Client client = null;
	private Boolean sentToClient = null;
	private Boolean showedOnTable = false;
	private int position;
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	public String toString() {
		return this.suit+" "+this.rank+"\n";
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public int compareTo(Card o) {
		int i=0;
		if(this.rank.getRankNormal()>o.rank.getRankNormal()) {
			i=1;
		} if(this.rank.getRankNormal()<o.rank.getRankNormal()) {
			i=-1;
		}
		return i;
	}

	public int compareToR(Card o) {
		int i=0;
		if(this.rank.getRankTrumpf()>o.rank.getRankTrumpf()) {
			i=1;
		} if(this.rank.getRankTrumpf()<o.rank.getRankTrumpf()) {
			i=-1;
		}
		return i;
	}

	public Boolean getSentToClient() {
		return sentToClient;
	}

	public void setSentToClient(Boolean sentToClient) {
		this.sentToClient = sentToClient;
	}

	public Boolean getShowedOnTable() {
		return showedOnTable;
	}

	public void setShowedOnTable(Boolean showedOnTable) {
		this.showedOnTable = showedOnTable;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
}
