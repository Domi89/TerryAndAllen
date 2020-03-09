package BusinessLayer;

import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) {
		
		Deck deck = new Deck();
		//System.out.println(deck);
		System.out.println("-------------------");
		
		int i = PointsCalculator.calculatePoints(deck.getCards(), Rule.undeUfe);
		System.out.println(i);
		
		System.out.println("-------------------");
		
		
		
		
		/*
		// SORTING TEST SUCCESS
		
		Card c = new Card(Suit.Rose, Rank.Ass);
		Card c1 = new Card(Suit.Eichle, Rank.Koenig);
		Card c2 = new Card(Suit.Eichle, Rank.Nuen);
		Card c3 = new Card(Suit.Eichle, Rank.Ober);
		ArrayList<Card> cards = new ArrayList<Card>();
		cards.add(c);
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
	
	
		System.out.println("-------------------");
		System.out.println(cards);
		Collections.sort(cards, new CardComparator(Rule.obeAbe, Suit.Eichle, Suit.Eichle));
		System.out.println("----------------");
		System.out.println(cards);
		*/
		
	
		

	}

}
