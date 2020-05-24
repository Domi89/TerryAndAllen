package model;

import java.util.ArrayList;

import serializedClasses.Card;
import serializedClasses.Rank;
import serializedClasses.Suit;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Card card1 = new Card(Suit.Eichle, Rank.Zaeh);
		Card card2 = new Card(Suit.Schilte, Rank.Zaeh);
		Card card3 = new Card(Suit.Rose, Rank.Zaeh);
		Card card4 = new Card(Suit.Eichle, Rank.Zaeh);
		
		Card card5 = new Card(Suit.Schilte, Rank.Zaeh);
		Card card6 = new Card(Suit.Eichle, Rank.Zaeh);
		
		ArrayList<Card> cardsOnHand = new ArrayList<Card>();
		ArrayList<Card> cardsOnTable = new ArrayList<Card>();
		
		
		cardsOnHand.add(card1);
		cardsOnHand.add(card2);
		cardsOnHand.add(card3);
		cardsOnHand.add(card4);
		
		cardsOnTable.add(card5);
		cardsOnTable.add(card6);
		
		System.out.println(CardComparator.haveSuitOnHand(cardsOnHand, cardsOnTable));
		
		
	}

}
