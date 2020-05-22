package ServerConnection;

import java.util.ArrayList;

import BusinessLayer.BigRound;
import BusinessLayer.Rule;
import BusinessLayer.SmallRound;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Message;
import serializedClasses.Suit;

public class GameStatus {
	
	private static SmallRound smallRound = new SmallRound();
	private static BigRound bigRound = new BigRound();
	
	
	private static Rule rule = Rule.obeAbe;
	private static Suit trumpf = null;
	
	private static Boolean newCard = false;
	private static Client lastPlayed = null;
	private static Boolean currentGameFinished = false;

	private static ArrayList<Card> currentGame = new ArrayList<Card>();
	
	private static ArrayList<Message> history = new ArrayList<Message>();
	
	
	
	public GameStatus() {
		
	}

	public static String getScore() {
		String scoreString = "";
		
		for (Client c: bigRound.getClients()) {	
			scoreString+=c.getClientName()+"\t"+bigRound.getPoints(c)+"\n";
		}
		
		return scoreString;
	}
	
	public static ArrayList<Card> getCurrentGame() {
		return currentGame;
	}

	public static void setCurrentGame(ArrayList<Card> currentGame) {
		GameStatus.currentGame = currentGame;
	}
	
	public static void addCardsCurrentBigRound(SmallRound cards) {
		bigRound.getSmallRounds().add(cards);
	}
	
	public static void addcurrentGame(Card card) {
		GameStatus.currentGame.add(card);
	}
	
	public static void addcurrentSmallRound(Card card) {
		smallRound.getCards().add(card);
		GameStatus.setLastPlayed(card.getClient());
		GameStatus.setNewCard(true);
	}

	public static Boolean getNewCard() {
		return newCard;
	}

	public static void setNewCard(Boolean newCard) {
		GameStatus.newCard = newCard;

	
	
	}

	public static Client getLastPlayed() {
		return lastPlayed;
	}

	public static void setLastPlayed(Client lastPlayed) {
		GameStatus.lastPlayed = lastPlayed;
	}

	public static Boolean getCurrentGameFinished() {
		return currentGameFinished;
	}

	public static void setCurrentGameFinished(Boolean currentGameFinished) {
		GameStatus.currentGameFinished = currentGameFinished;
	}


	public static Suit getTrumpf() {
		return trumpf;
	}

	public static void setTrumpf(Suit trumpf) {
		GameStatus.trumpf = trumpf;
	}

	public static Rule getRule() {
		return rule;
	}

	public static void setRule(Rule rule) {
		GameStatus.rule = rule;
	}
	public static SmallRound getSmallRound() {
		return smallRound;
	}
	public static void setSmallRound(SmallRound smallRound) {
		GameStatus.smallRound = smallRound;
	}
	public static BigRound getBigRound() {
		return bigRound;
	}
	public static void setBigRound(BigRound bigRound) {
		GameStatus.bigRound = bigRound;
	}

	public static ArrayList<Message> getHistory() {
		return history;
	}

	public static void setHistory(ArrayList<Message> history) {
		GameStatus.history = history;
	}
}
