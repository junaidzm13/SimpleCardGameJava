package assignment3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This class represents a single card, in the game of 52 cards.
 * 
 * @author Junaid Zubair
 * @version 1.0
 */
public class Card {

	/**
	 * Static int instance variable representing number of Card objects already been created.
	 */
	public static int numberOfCards = 0;
	private int number;
	private char suit;
	private static final ArrayList<Character> suits = new ArrayList<Character>(Arrays.asList('C', 'S', 'D', 'H'));
	
	
	/**
	 * No argument constructor that creates a Card object based on the number of
	 * Card objects already created.
	 */
	public Card() {
		suit = suits.get(numberOfCards / 13);
		number = numberOfCards % 13;
		numberOfCards++;
	}
	
	
	/**
	 * This method returns a boolean representing whether this 
	 * Card is a special card (any one of jack, queen or king).
	 * 
	 * @return true if this Card is a special card, otherwise false.
	 */
	public boolean isSpecialCard() {
		if (number >= 10) return true;
		else return false;
	}
	
	
	/**
	 * This is a getter method that returns the value of the instance 
	 * variable number that represents the number of the Card 
	 * within a given suite (10 = Jack, 11 = Queen, 12 = King, 0 = Ace, 1 = 2 Card, 2 = 3 Card, so on
	 * until 9 = 10 Card).
	 * 
	 * @return int representing the number of this Card
	 */
	public int getCardNumber() {
		return number;
	}
	
	
	/**
	 * This is a getter method that returns the value of suit instance
	 * variable representing the suit of this card.
	 * (C = Club, S = Spades, D = Diamond, H = Heart)
	 * 
	 * @return char representing the suit of this Card
	 */
	public char getSuit() {
		return suit;
	}
	
	
	/**
	 * This method returns the name of the GIF file in source/images corresponding to
	 * this Card object based on its number and suit.
	 * 
	 * @return String representing GIF file name of this Card object.
	 */
	public String getImageName() {
		int num = suits.indexOf(suit);
		return String.format("card_%d%d.gif", num + 1, number + 1);
	}
	
	
	/**
	 * This method returns a string representation of this Card object.
	 * 
	 * @return String representation of this object.
	 */
	public String toString() {
		return String.format("%d%c", number, suit);
	}
	
}
