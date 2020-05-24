package model;

import java.util.ArrayList;
import java.util.Comparator;

import serializedClasses.Card;
import serializedClasses.Rule;
import serializedClasses.Suit;

public class CardComparator implements Comparator<Card> {

	private static Suit trumpf = null;
	private static Suit firstPlayed = null;
	private static Rule rule = null;
	
	
	public CardComparator(Rule rule, Suit firstPlayed, Suit trumpf) {
		
		this.rule=rule;
		this.firstPlayed=firstPlayed;
		this.trumpf=trumpf;

	}
	
	
	//public boolean cardPlayable(ArrayList<Card> cardsOnHand, ArrayList<Card> cardsOnTable, Card wantToPlay, Rule rule, Suit trumpf) {
		
	//	}
		
		
		
	//}
	
	public static boolean haveSuitOnHand(ArrayList<Card> cardsOnHand, ArrayList<Card> cardsOnTable) {
		boolean suitOnHand = false;
		if (cardsOnTable!=null) {
			for (Card c: cardsOnHand) {
				if(c.getSuit().equals(cardsOnTable.get(0).getSuit())) {
					suitOnHand = true;
				}
			}
		}
		return suitOnHand;
	}
	
	
	public int compare(Card o1, Card o2) {
		
		int value=0;
		
		switch(rule.name()) {
			case "obeAbe":
				value = obeAbeCompare(o1, o2);
				break;
				
			case "undeUfe":
				value = undeUfeCompare(o1, o2);
				break;
			
			case "trumpf":
				value = trumpfCompare(o1, o2);
				break;
			default:
				System.out.println("Sth went wrong within Rules");
		}
		
		return value;
	
	}
	
	
	
	public int trumpfCompare(Card o1, Card o2) {
		
		if(o1.getSuit()==trumpf && o2.getSuit()!=trumpf) {
			return 1;
		}
		if(o1.getSuit()!=trumpf && o2.getSuit()==trumpf) {
			return -1;
		}
		if(o1.getSuit()==trumpf && o2.getSuit()==trumpf) {
			return Integer.compare(o1.getRank().getRankTrumpf(), o2.getRank().getRankTrumpf());
		}
		if(o1.getSuit()==firstPlayed && o2.getSuit()!=firstPlayed) {
			return 1;
		}
		if(o1.getSuit()!=firstPlayed && o2.getSuit()==firstPlayed) {
			return -1;
		}
		return Integer.compare(o1.getRank().getRankNormal(), o2.getRank().getRankNormal());

	}
	
	public int obeAbeCompare(Card o1, Card o2) {
		if(o1.getSuit()==firstPlayed && o2.getSuit()!=firstPlayed) {
			return 1;
		}
		if(o1.getSuit()!=firstPlayed && o2.getSuit()==firstPlayed) {
			return -1;
		}
		return Integer.compare(o1.getRank().getRankNormal(), o2.getRank().getRankNormal());
	}
	
	
	public int undeUfeCompare(Card o1, Card o2) {
		if(o1.getSuit()==firstPlayed && o2.getSuit()!=firstPlayed) {
			return 1;
		}
		if(o1.getSuit()!=firstPlayed && o2.getSuit()==firstPlayed) {
			return -1;
		}
		return Integer.compare(o1.getRank().getRankNormal(), o2.getRank().getRankNormal())*-1;
	}

}
