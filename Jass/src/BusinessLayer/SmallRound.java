package BusinessLayer;

import java.util.ArrayList;
import java.util.Collections;

import ServerConnection.GameStatus;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Rule;
import serializedClasses.Suit;

public class SmallRound{

	private Client winner;
	private int points;
	private ArrayList<Card> cards = new ArrayList<Card>();
	private boolean finished = false;
	private Rule rule;
	private Suit trumpf;
	
	public int calculatePoints() {
		int points = 0;
		this.rule = GameStatus.getRule();
		this.trumpf = GameStatus.getTrumpf();
		
		
		if(this.rule.equals(Rule.trumpf)) {
			points = PointsCalculator.calculatePoints(this.cards, rule, trumpf);
		} else {
			points = PointsCalculator.calculatePoints(this.cards, rule);
		}
		

		
		return points;
	}
	
	public Client finishedRound() {
		calculatePoints();
		return calculateWinner();	
	}
	
	public Client calculateWinner() {
		this.rule = GameStatus.getRule();
		this.trumpf = GameStatus.getTrumpf();
		Card firstPlayed = cards.get(0);
		ArrayList<Card> sortedCards = this.cards;
		Collections.sort(sortedCards, new CardComparator(this.rule, firstPlayed.getSuit(), this.trumpf));
		this.winner = sortedCards.get(sortedCards.size()-1).getClient();
		return this.winner;
	}
	
	public SmallRound() {
		
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}

	public Client getWinner() {
		return winner;
	}

	public void setWinner(Client winner) {
		this.winner = winner;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}


	
	public boolean roundFinished(ArrayList<Card> cards) {
		if(Constants.MAX_PLAYERS==cards.size()) {
			return true;
		}else {
			return false;
		}
	}
	

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	
	
	
}
