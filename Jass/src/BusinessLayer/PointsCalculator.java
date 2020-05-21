package BusinessLayer;

import java.util.Stack;

import serializedClasses.Card;
import serializedClasses.Suit;

public class PointsCalculator {
	
	public PointsCalculator() {
		
	}
	
	// CHECK all Rules must be equal to 152 points;
	
	public static int calculatePoints(Stack<Card> cards, Rule rule, Suit trumpf) {
		int points = 0;
		
		Stack<Card> copy = cards;
		
		switch(rule.name()) {
	
			case "trumpf":
				points = calculatorTrumpf(copy, trumpf);
				break;
			default:
				System.out.println("Sth went wrong within PointsCalculator");
		}
		return points;
	}
	
	public static int calculatePoints(Stack<Card> cards, Rule rule) {
		int points = 0;
		
		Stack<Card> copy = cards;
		
		switch(rule.name()) {
			case "obeAbe":
				points = calculatorObeabe(copy);
				break;
				
			case "undeUfe":
				points = calculatorUndeufe(copy);
				break;
			
			default:
				System.out.println("Sth went wrong within PointsCalculator");
		}
		return points;
	}
	
	
	

	private static int calculatorTrumpf(Stack<Card> cards, Suit trumpf) {
		int points = 0;
		while(!cards.isEmpty()) {
			Card c = cards.pop();
			if(c.getSuit()==trumpf) {
				points += c.getRank().getPointsTrumpf();
			} else {
				points += c.getRank().getPointsNormal();
			}
		}
		return points;
	}

	private static int calculatorUndeufe(Stack<Card> cards) {
		int points = 0;
		while(!cards.isEmpty()) {
			Card c = cards.pop();
			points += c.getRank().getPointsUndeufe();
		}
		return points;
	}

	private static int calculatorObeabe(Stack<Card> cards) {
		int points = 0;
		while(!cards.isEmpty()) {
			Card c = cards.pop();
			points += c.getRank().getPointsObeabe();
		}
		return points;
	}
	
	

}
