package ServerConnection;

import java.util.ArrayList;

import serializedClasses.Card;
import serializedClasses.Client;

public class GameStatus {
	
	private static ArrayList<Card> currentSmallRound = new ArrayList<Card>();
	
	private static ArrayList<Card> currentBigRound = new ArrayList<Card>();
	
	private static ArrayList<Card> currentGame = new ArrayList<Card>();
	
	private static Boolean newCard = false;
	
	private static Client lastPlayed = null;
	
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
		GameStatus.lastPlayed = card.getClient();
		GameStatus.setNewCard(true);
	}

	public static Boolean getNewCard() {
		return newCard;
	}

	public static void setNewCard(Boolean newCard) {
		GameStatus.newCard = newCard;

	
	
	}
}
