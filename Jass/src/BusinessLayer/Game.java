package BusinessLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import ServerConnection.GameStatus;

public class Game implements Serializable{

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
