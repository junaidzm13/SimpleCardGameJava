package assignment3;

import java.util.ArrayList;

/**
 * This abstract class represents a hand of a participant (including a player
 * and a dealer) containing three cards. Each card representing a Card object.
 * 
 * @author Junaid Zubair
 * @version 1.0
 */
public abstract class Hand implements Comparable<Hand> {

	private ArrayList<Card> currentHand = new ArrayList<Card>();
	
	
	/**
	 * Constructor that creates a Hand object by drawing three Card objects
	 * from the top of a Deck object d.
	 * 
	 * @param d Deck object that represents the deck of cards.
	 */
	public Hand(Deck d) {
		for(int i = 0; i < 3; i++) {
			currentHand.add(d.drawCard());
		}
	}
	
	
	/**
	 * This method places all three Card objects in this Hand at the
	 * bottom of the Deck object d.
	 * 
	 * @param d Deck object that represents the deck of cards.
	 */
	public void returnCards(Deck d) {
		for(int i = 0; i < 3; i++) {
			d.addCard(currentHand.get(i));
		}
	}
	
	
	/**
	 * This method counts and returns the number of special cards in this Hand.
	 * 
	 * @return Integer object representing the number of special cards in this Hand.
	 */
	public Integer numberOfSpecialCards() {
		int count = 0;
		for(Card c : currentHand)
			if(c.isSpecialCard()) count++;
		return count;
	}
	
	
	/**
	 * This method sums up the face value of all non-special cards in this Hand, and returns
	 * the sum's remainder when divided by 10.
	 * 
	 * @return Integer object that represents the remainder when the total face value of 
	 * non-special cards in this Hand is divided by 10.
	 */
	public Integer getFaceValueMod10() {
		int totalFace = 0;
		for (Card c : currentHand)
			if(!c.isSpecialCard())
				totalFace += c.getCardNumber() + 1;
		return totalFace % 10;
	}
	
	
	/**
	 * This method compares this Hand, with Hand h, using the given criteria in the rule
	 * book to determine whether this Hand has a higher, equal, or lower score than h.
	 * returns &gt; 0 if higher, 0 if equal and &lt; 0 if lower.
	 * 
	 * @param h other Hand object used in comparison.
	 * @return int &gt; 0, 0 or &lt; 0 if this Hand has score higher, equal, or lower than h respectively.
	 */
	@Override
	public int compareTo(Hand h) {
		int compareSpecial = numberOfSpecialCards().compareTo(h.numberOfSpecialCards());		
		if (compareSpecial != 0) return compareSpecial;
		else {
			int compareFaceValue = getFaceValueMod10().compareTo(h.getFaceValueMod10());
			if (compareFaceValue != 0) return compareFaceValue;
			else return 0;
		}
	}
	
	
	/**
	 * This is a getter method, that returns the value of the instance variable currentHand
	 * representing the current hand of this Hand object.
	 * 
	 * @return ArrayList&lt;Card&gt; representing current hand containing the 3 Card objects
	 */
	public ArrayList<Card> getCurrentHand(){
		return currentHand;
	}
	
}
