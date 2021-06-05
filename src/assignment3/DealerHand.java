package assignment3;

/**
 * This class extends the Hand abstract class and represents a hand 
 * of a dealer.
 * 
 * @author Junaid Zubair
 * @version 1.0
 */
public class DealerHand extends Hand {

	/**
	 * Constructor that creates a DealerHand object by simply calling
	 * the constructor defined in its superclass Hand, with Deck object 
	 * argument deck.
	 * 
	 * @param deck Deck object that represents the deck of cards.
	 */
	public DealerHand(Deck deck) {
		super(deck);
	}
	
}
