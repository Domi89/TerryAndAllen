package BusinessLayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class Deck {
	
	private Stack<Card> cards;
	
	public Deck() {
		this.createDeck();
	}

	
	private void createDeck() {
		
		cards = new Stack<Card>();
		for (Suit suit: Suit.values()) {
			for (Rank rank: Rank.values()) {
				Card card = new Card(suit, rank);
				cards.push(card);
			}
		}
		shuffle();

	}
	
	private void shuffle() {
		
		Random rand = new Random();
		Stack<Card> shuffledCards = new Stack<Card>();
		while (cards.size()>0) {
			int index = rand.nextInt(cards.size());
			Card shuffeledCard = cards.get(index);
			cards.remove(index);
			shuffledCards.push(shuffeledCard);
		}
		cards = shuffledCards;
		
	}
	
	public String toString() {
		
		String s ="";
		for (Card c: cards) {
			
			s += c+"\n";
			
		}
		return s;
		
	}

	public Stack<Card> getCards() {
		return cards;
	}

	public void setCards(Stack<Card> cards) {
		this.cards = cards;
	}
	

}
