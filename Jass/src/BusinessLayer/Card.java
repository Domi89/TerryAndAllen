package BusinessLayer;

public class Card implements Comparable<Card>{
	// h
	private Suit suit;
	private Rank rank;
	
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
	
}
