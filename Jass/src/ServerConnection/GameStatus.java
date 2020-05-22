package ServerConnection;

import java.util.ArrayList;

import BusinessLayer.BigRound;
import BusinessLayer.Rule;
import BusinessLayer.SmallRound;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Suit;

public class GameStatus {
	
	private static SmallRound smallRound = new SmallRound();
	private static BigRound bigRound = new BigRound();
	
	private static Rule rule = Rule.obeAbe;
	private static Suit trumpf = null;
	
	private static Boolean newCard = false;
	private static Client lastPlayed = null;
	private static Boolean currentGameFinished = false;
	
	//private static Boolean currentSmallRoundFinished = false;

	//private static Boolean currentBigRoundFinished = false;
	
	
	
	private static ArrayList<Card> currentSmallRound = new ArrayList<Card>();
	private static ArrayList<Card> currentBigRound = new ArrayList<Card>();
	
	
	
	
	
	
	private static ArrayList<Card> currentGame = new ArrayList<Card>();
	

	

	
	

	

	
	
	public GameStatus() {
		
	}

	public static ArrayList<Card> getCurrentSmallRound() {
		return currentSmallRound;
	}

	public static void setCurrentSmallRound(ArrayList<Card> currentSmallRound) {
		GameStatus.currentSmallRound = currentSmallRound;
	}

	public static ArrayList<Card> getCurrentBigRound() {
		return currentBigRound;
	}

	public static void setCurrentBigRound(ArrayList<Card> currentBigRound) {
		GameStatus.currentBigRound = currentBigRound;
	}

	public static ArrayList<Card> getCurrentGame() {
		return currentGame;
	}

	public static void setCurrentGame(ArrayList<Card> currentGame) {
		GameStatus.currentGame = currentGame;
	}
	
	public static void addCardcurrentBigRound(Card card) {
		GameStatus.currentBigRound.add(card);
	}
	
	public static void addcurrentGame(Card card) {
		GameStatus.currentGame.add(card);
	}
	
	public static void addcurrentSmallRound(Card card) {
		GameStatus.currentSmallRound.add(card);
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

	/*
	public static Boolean getCurrentBigRoundFinished() {
		return currentBigRoundFinished;
	}

	public static void setCurrentBigRoundFinished(Boolean currentBigRoundFinished) {
		GameStatus.currentBigRoundFinished = currentBigRoundFinished;
	}
*/
	//public static Boolean getCurrentSmallRoundFinished() {
	//	return currentSmallRoundFinished;
	//}

	//public static void setCurrentSmallRoundFinished(Boolean currentSmallRoundFinished) {
	//	GameStatus.currentSmallRoundFinished = currentSmallRoundFinished;
	//}

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
}
