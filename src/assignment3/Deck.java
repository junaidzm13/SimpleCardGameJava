package assignment3;

import java.util.ArrayList;

/**
 * This class represents a deck of 52 cards. Each card is a Card object.
 * 
 * @author Junaid Zubair
 * @version 1.0
 */
public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>();
	
	
	/**
	 * No argument constructor to create this Deck by creating 52 new
	 * Card objects.
	 */
	public Deck() {
		Card.numberOfCards = 0;
		for(int i = 0; i < 52; i++) {
			deck.add(new Card());
		}
	}
	
	
	/**
	 * This method randomly shuffles this Deck.
	 */
	public void shuffleDeck() {
		for (int i = 0; i < deck.size(); i++) {
			int newIndex = (int) (deck.size() * Math.random());
			Card temp = deck.set(newIndex, deck.get(i));
			deck.set(i, temp);
		}
	}
	
	
	/**
	 * This method removes a Card object from the top of this Deck.
	 * 
	 * @return Card object representing the top card stored in this Deck.
	 */
	public Card drawCard() {
		return deck.remove(deck.size() - 1);
	}
	
	
	/**
	 * This methods adds back Card c to the bottom of this Deck.
	 * 
	 * @param c represents Card object to be added.
	 */
	public void addCard(Card c) {
		deck.add(0, c);
	}
	
	
	/**
	 * This method adds Card returnedCard to the end of this Deck and
	 * removes and returns a Card object from the top of the Deck.
	 * 
	 * @param returnedCard represents Card object being returned and replaced.
	 * @return Card object at the top of this Deck.
	 */
	public Card replaceCard(Card returnedCard) {
		Card newCard = drawCard();
		deck.add(0, returnedCard);
		return newCard;
	}
	
}
