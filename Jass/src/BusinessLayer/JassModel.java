package BusinessLayer;

import java.util.ArrayList;

public class JassModel {
	
	private final ArrayList<Player> players = new ArrayList<Player>();
	private Deck deck;
	
	public JassModel() {
		
		for (int i = 0; i< Constants.MAX_PLAYERS; i++) {
			players.add(new Player("Player "+i));
			}
		deck = new Deck();
		
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}
	
	
	

}
