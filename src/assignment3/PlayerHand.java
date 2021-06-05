package assignment3;

/**
 * This class extends the Hand abstract class and represents a hand 
 * of a player with some player specific behaviors.
 *
 * @author Junaid Zubair
 * @version 1.0
 */
public class PlayerHand extends Hand {

	/**
	 * Constructor that creates a PlayerHand object by simply calling
	 * the constructor defined in its superclass Hand, with Deck object 
	 * argument, deck.
	 * 
	 * @param deck Deck object that represents the deck of cards.
	 */
	public PlayerHand(Deck deck) {
		super(deck);
	}
	
	
	/**
	 * This method takes a DealerHand object, dealerHand, and returns whether 
	 * the player with this PlayerHand has won against the dealer with hand
	 * dealerHand. Returns true if player with this PlayerHand has won,
	 * false otherwise.
	 * 
	 * @param dealerHand Hand object representing the dealer's hand.
	 * @return boolean representing true if player with this PlayerHand has won, false otherwise.
	 */
	public boolean hasWon(DealerHand dealerHand) {
		int result = this.compareTo(dealerHand);
		if(result <= 0) return false;
		else return true;
	}
	
	/**
	 * This method replaces a card (Card object) numbered cradNumber 
	 * (1 for first, 2 for second, 3 for third) in this PlayerHand
	 * by a card (Card object) at the top of a deck d.
	 * 
	 * @param d Deck object representing the deck of cards.
	 * @param cardNumber representing the card to be replaced.
	 */
	public void replaceCard(Deck d, int cardNumber) {
		Card newCard = d.replaceCard(this.getCurrentHand().get(cardNumber - 1));
		this.getCurrentHand().set(cardNumber - 1, newCard);
	}
}
