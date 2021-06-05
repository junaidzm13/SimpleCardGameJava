package assignment3;

/**
 * This class represents the profile of the current player in
 * a single game, such as his/her remaining balance, current 
 * round's bet and the number of card replacements used.
 * 
 * @author Junaid Zubair
 * @version 1.0
 */

public class Profile {
	
	private int money = 100;
	private int currentBet;
	private int numberOfReplacementsUsed;
	
	/**
	 * No argument constructor.
	 */
	public Profile() {}
	
	
	/**
	 * This is a getter method that returns the value stored in money instance
	 * variable, representing the remaining total amount of money for the
	 * player with this Profile.
	 * 
	 * @return total remaining money of the player with this Profile.
	 */
	public int getMoney() {
		return money;
	}
	
	
	/**
	 * This is a getter method that returns the value of the instance variable
	 * numberOfReplacements representing the number of card replacements used
	 * by the player with this Profile.
	 * 
	 * @return int number of replacements used by the player with this Profile.
	 */
	public int getNumberOfReplacementsUsed() {
		return numberOfReplacementsUsed;
	}
	
	
	/**
	 * This method increments the variable numberOfReplacements representing the
	 * number of replacements used by the player with this Profile.
	 */
	public void incrementNumberOfReplacementsUsed() {
		numberOfReplacementsUsed++;
	}
	
	/**
	 * This is a getter method that returns the value of the instance variable currentBet
	 * representing the current bet made by the player with this Profile.
	 * 
	 * @return int current bet made by the player with this Profile.
	 */
	public int getCurrentBet() {
		return currentBet;
	}
	
	
	/**
	 * This is a setter method, that sets the value of currentBet instance variable
	 * that represents the current bet of the player with this Profile, to newBet.
	 * 
	 * @param newBet represents new bet being placed by the player with this Profile.
	 */
	public void setCurrentBet(int newBet) {
		currentBet = newBet;
	}
	
	
	/**
	 * This method takes a boolean hasWon, that represents whether the player has won
	 * the current bet or not, and accordingly increases or decreases the player's 
	 * money by the amount of current bet, and sets up the value of the other instance
	 * variables for the new round.
	 * 
	 * @param hasWon represents whether the player with this Profile has won or not.
	 */
	public void setNewMoney(boolean hasWon) {
		if(hasWon) money += currentBet;
		else money -= currentBet;
		currentBet = 0;
		numberOfReplacementsUsed = 0;
	}
	
	
	/**
	 * This method takes an integer newBet representing a new potential bet entered by the
	 * user, and checks whether this bet is valid. That is whether it is greater than 0 and
	 * smaller or equal to the current money that the player with this Profile has.
	 * 
	 * @param newBet representing the new bet being placed by the player.
	 * @return true if the newBet is valid, false otherwise.
	 */
	public boolean isValidBet(int newBet) {
		return (newBet > 0 && newBet <= money);
	}
	
}
