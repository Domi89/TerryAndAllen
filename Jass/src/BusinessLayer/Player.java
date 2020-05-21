package BusinessLayer;

import java.util.ArrayList;

import serializedClasses.Card;

public class Player {

	private ArrayList<Card> activeCards;
	private ArrayList<Card> wonCards;
	//used for AI to calculate
	private ArrayList<Card> seenCards;
	private String name;
	
	public Player(String name) {
		this.name=name;
		this.activeCards= new ArrayList<Card>();
		this.wonCards = new ArrayList<Card>();
		this.seenCards = new ArrayList<Card>();
	}

	public ArrayList<Card> getActiveCards() {
		return activeCards;
	}

	public void setActiveCards(ArrayList<Card> activeCards) {
		this.activeCards = activeCards;
	}

	public ArrayList<Card> getWonCards() {
		return wonCards;
	}

	public void setWonCards(ArrayList<Card> wonCards) {
		this.wonCards = wonCards;
	}

	public ArrayList<Card> getSeenCards() {
		return seenCards;
	}

	public void setSeenCards(ArrayList<Card> seenCards) {
		this.seenCards = seenCards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
