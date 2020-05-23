package BusinessLayer;

import java.util.ArrayList;
import java.util.Collections;

import ServerConnection.GameStatus;
import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Suit;

public class Game{

	private int maxPoints;
	private ArrayList<BigRound> bigRound = new ArrayList<BigRound>();
	private boolean finished = false;
	
	public Game() {
		
	}
	
	public int getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}

	public ArrayList<BigRound> getBigRound() {
		return bigRound;
	}

	public void setBigRound(ArrayList<BigRound> bigRound) {
		this.bigRound = bigRound;
	}
	
	
	
}
