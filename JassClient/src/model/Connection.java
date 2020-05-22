package model;

import java.util.ArrayList;

import serializedClasses.Rule;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Suit;

public class Connection {
	
	public static Boolean connected;
	public static Boolean yourTurn = false;
	//public static Boolean newCard = false;
	
	private static ArrayList<Card> cardsOnTable = new ArrayList<Card>();
	private static Boolean newCardToShow = false;
	
	private static Boolean chooseMode = false;

	private static Rule rule = Rule.trumpf;
	private static Suit trumpf = Suit.Eichle;
	
	
	
	private static int playersCount = 2;
	
	public static int getPlayersCount() {
		return playersCount;
	}

	public static void setPlayersCount(int playersCount) {
		Connection.playersCount = playersCount;
	}

	public static void Connection() {
		
	}
	
	public Boolean getConnected() {
		return this.connected;
	}
	
	public static void setYourTurn(Boolean b) {
		yourTurn = b;
		System.out.println("Your turn");
	}

	public static ArrayList<Card> getCardsOnTable() {
		return cardsOnTable;
	}

	public static void setCardsOnTable(ArrayList<Card> cardsOnTable) {
		Connection.cardsOnTable = cardsOnTable;
	}

	public static Boolean getNewCardToShow() {
		return newCardToShow;
	}

	public static void setNewCardToShow(Boolean newCardToShow) {
		Connection.newCardToShow = newCardToShow;
	}

	public static Boolean getChooseMode() {
		return chooseMode;
	}

	public static void setChooseMode(Boolean chooseMode) {
		Connection.chooseMode = chooseMode;
	}

	public static Suit getTrumpf() {
		return trumpf;
	}

	public static void setTrumpf(Suit trumpf) {
		Connection.trumpf = trumpf;
	}

	public static Rule getRule() {
		return rule;
	}

	public static void setRule(Rule rule) {
		Connection.rule = rule;
	}


}
