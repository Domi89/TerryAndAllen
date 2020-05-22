package ServerConnection;

import java.util.ArrayList;

import BusinessLayer.BigRound;
import BusinessLayer.Constants;
import BusinessLayer.Game;
import BusinessLayer.Rule;
import BusinessLayer.SmallRound;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Message;
import serializedClasses.Suit;

public class GameStatus {
	
	private static SmallRound smallRound = new SmallRound();
	private static BigRound bigRound = new BigRound();
	private static Game game = new Game();
	
	private static ArrayList<Client> clients = new ArrayList<Client>();
	
	private static Rule rule = Rule.trumpf;
	private static Suit trumpf = Suit.Eichle;
	
	private static Boolean newCard = false;
	private static Client lastPlayed = null;
	private static Boolean currentGameFinished = false;

	private static ArrayList<Card> currentGame = new ArrayList<Card>();
	
	private static ArrayList<Message> history = new ArrayList<Message>();
	
	
	
	public GameStatus() {
		
	}

	public static String getScore() {
		String scoreString = "";
		
		for (Client c: clients) {	
			scoreString+=c.getClientName()+"\t"+c.getPointsBig()+"\n";
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
	
	public static Boolean smallRoundFinished() {
		Boolean finished = false;
		if (smallRound.getCards().size()==Constants.MAX_PLAYERS) {
			int points = smallRound.calculatePoints();
			Client winner = smallRound.calculateWinner();
			bigRound.addSmallRounds(smallRound);
			smallRound = new SmallRound();
			finished = true;
			
			for(Client c: clients) {
				if(c.getClientName().equals(winner.getClientName())) {
					System.out.println("WIXENDE HURE: ClientNAME"+c.getClientName()+"POINTS"+points);
					
					c.addPointsSmall(points);
					c.addPointsBig(points);
				}
			}
			
			
		}
		return finished;
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

	public static ArrayList<Client> getClients() {
		return clients;
	}

	public static void setClients(ArrayList<Client> clients) {
		GameStatus.clients = clients;
	}
}
