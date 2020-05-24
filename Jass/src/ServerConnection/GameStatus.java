package ServerConnection;

import java.util.ArrayList;
import java.util.Collections;

import BusinessLayer.BigRound;
import BusinessLayer.Constants;
import BusinessLayer.Game;
import BusinessLayer.SmallRound;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Message;
import serializedClasses.Rule;
import serializedClasses.Suit;

public class GameStatus {
	
	private  static SmallRound smallRound = new SmallRound();
	private  static BigRound bigRound = new BigRound();
	private  static Game game = new Game();
	
	private static boolean smallRoundFinished = false;
	
	public static Game getGame() {
		return game;
	}
	public static void setGame(Game game) {
		GameStatus.game = game;
	}
	private  static int maxPoints = 0;
	private  static ArrayList<Client> clients = new ArrayList<Client>();
	private  static Rule rule = Rule.trumpf;
	private  static Suit trumpf = Suit.Eichle;
	private  static Client lastWinner = null;
	
	private  static Boolean newCard = false;
	private  static Client lastPlayed = null;
	private  static Boolean currentGameFinished = false;

	private  static ArrayList<Card> currentGame = new ArrayList<Card>();
	
	private  static ArrayList<Message> history = new ArrayList<Message>();
	
	
	
	public GameStatus() {
		
	}
	
	public static int calculateMaxPoints() {
		
		ArrayList<Client> copy = clients;
		
		Collections.sort(copy);
		maxPoints = copy.get(Constants.MAX_PLAYERS-1).getPointsBig();
			
		return maxPoints;
	}
	
	public static Client calculateWinner() {
		
		ArrayList<Client> copy = clients;
		
		Collections.sort(copy);
		Client c = copy.get(Constants.MAX_PLAYERS-1);
			
		return c;
	}
	

	public static String getScore() {
		String scoreString = "";
		
		scoreString+="Max Punkte zu erreichen: "+Constants.POINTS_TO_WIN+"\n\n\n";
		
		for (Client c: clients) {	
			
		
			scoreString+="Spieler:   "+c.getClientName()+"\t Punkte: "+c.getPointsBig()+"\n";
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
		Client winner = null;
		if (smallRound.getCards().size()==Constants.MAX_PLAYERS) {
			int points = smallRound.calculatePoints();
			winner = smallRound.calculateWinner();
			bigRound.addSmallRounds(smallRound);
			smallRound = new SmallRound();
			GameStatus.setSmallRoundFinished(true);
			finished = true;
			
			for(Client c: clients) {
				if(c.getClientName().equals(winner.getClientName())) {
					System.out.println("ClientNAME"+c.getClientName()+"POINTS"+points);
					
					c.addPointsSmall(points);
					c.addPointsBig(points);
				}
			}
			
		}
		setLastWinner(winner);	

		return finished;
		
		
		
	}

	public static boolean bigRoundFinished() {
		
		int playedCards = 0;
		int cardsToPlay = 0;
		boolean isFinished = false;
		cardsToPlay = Constants.MAX_PLAYERS * 9;
		for (SmallRound sR: bigRound.getSmallRounds()) {
			for(Card cards: sR.getCards()) {
				playedCards++;
			}
		}
		if(playedCards == cardsToPlay) {
			isFinished = true;
			bigRound.setFinished(true);
		}
		bigRound.setFinished(true);
		return isFinished;
	}
	
	public static void addBigRoundToGame() {
		BigRound copy = bigRound;
		game.getBigRound().add(copy);
		bigRound = new BigRound();
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

	public static Client getLastWinner() {
		return lastWinner;
	}

	public static void setLastWinner(Client lastWinner) {
		GameStatus.lastWinner = lastWinner;
	}

	public static boolean isSmallRoundFinished() {
		return smallRoundFinished;
	}

	public static void setSmallRoundFinished(boolean smallRoundFinished) {
		GameStatus.smallRoundFinished = smallRoundFinished;
	}
}
