package BusinessLayer;

import java.util.Comparator;

import serializedClasses.Card;
import serializedClasses.Client;
import serializedClasses.Suit;

public class ClientComparator implements Comparator<Client> {


	
	public ClientComparator() {
		

	}

	public int compare(Client o1, Client o2) {
		if(o1.getPointsSmall() > o2.getPointsSmall()) {
			return 1;
		}
		if(o1.getPointsSmall() < o2.getPointsSmall()) {
			return -1;
		}
		return 0;
	}

}
