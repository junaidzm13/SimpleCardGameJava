package assignment3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

/**
 * This class contains the main method, as well as all the 
 * logic for the game and the GUI.
 * 
 * @author Junaid Zubair
 * @version 1.0
 */

public class MainGUI {

	ArrayList<JLabel> dealerImgLabels = new ArrayList<JLabel>();
	ArrayList<ImageIcon> dealerImgIcons = new ArrayList<ImageIcon>();
	
	ArrayList<JLabel> playerImgLabels = new ArrayList<JLabel>();
	ArrayList<ImageIcon> playerImgIcons = new ArrayList<ImageIcon>();
	
	JLabel betLabel = new JLabel();
	JLabel moneyLabel = new JLabel();
	JTextField inputBetTF;
	JFrame frame;
	Profile playerProfile = new Profile();
	Deck deck;
	PlayerHand playerHand;
	DealerHand dealerHand;
	
	JLabel betTextLabel, moneyTextLabel;
	JButton startButton, resultButton;
	JButton rpCard1Button, rpCard2Button, rpCard3Button;
	
	Font f = new Font("Matura MT Script Capitals", Font.BOLD, 15);
	Color darkBlue = new Color(0, 0, 137);
	Color seaGreen = new Color(78, 219, 205);
	
	
	/**
	 * No argument constructor. Only initializes some instance variables.
	 */
	public MainGUI() {
		
		for(int i = 0; i<3; i++) {
			dealerImgLabels.add(new JLabel());
			dealerImgIcons.add(new ImageIcon(
					getClass().getResource("/Images/card_back.gif")
					));
			dealerImgLabels.get(i).setIcon(dealerImgIcons.get(i));
			
			playerImgLabels.add(new JLabel());
			playerImgIcons.add(new ImageIcon(
					getClass().getResource("/Images/card_back.gif")
					));
			playerImgLabels.get(i).setIcon(playerImgIcons.get(i));
		}
		
	}
	
	
	/**
	 * This is the main method where the execution of the program starts. It creates
	 * an instance of this class and calls its method go().
	 * 
	 * @param args Unused.
	 */
	public static void main(String[] args) {
		MainGUI game = new MainGUI();
		game.go();
	}
	
	
	/**
	 * This method contains all the logic for the game as well as the logic
	 * for the GUI components used.
	 */
	public void go() {
		// Dealer cards panel
		JPanel dealerCardPanel = new JPanel();
		for(int i = 0; i < 3; i++) dealerCardPanel.add(dealerImgLabels.get(i));
		dealerCardPanel.setBackground(Color.green);
		
		// Player cards panel
		JPanel playerCardPanel = new JPanel();
		for(int i = 0; i < 3; i++) playerCardPanel.add(playerImgLabels.get(i));
		playerCardPanel.setBackground(Color.green);
		
		// 3 replace buttons
		rpCard1Button = new JButton("Replace Card 1");
		rpCard2Button = new JButton("Replace Card 2");
		rpCard3Button = new JButton("Replace Card 3");
		rpCard1Button.setFont(f);
		rpCard2Button.setFont(f);
		rpCard3Button.setFont(f);
		rpCard1Button.setToolTipText("Replace \ncard 1.");
		rpCard2Button.setToolTipText("Replace \ncard 2.");
		rpCard3Button.setToolTipText("Replace \ncard 3.");
		rpCard1Button.addActionListener(new ReplacementButton1());
		rpCard2Button.addActionListener(new ReplacementButton2());
		rpCard3Button.addActionListener(new ReplacementButton3());
		rpCard1Button.setEnabled(false);
		rpCard2Button.setEnabled(false);	
		rpCard3Button.setEnabled(false);
        
		JPanel rpCardBtnPanel = new JPanel();
		rpCardBtnPanel.add(rpCard1Button);
		rpCardBtnPanel.add(rpCard2Button);
		rpCardBtnPanel.add(rpCard3Button);
		rpCardBtnPanel.setBackground(Color.green);
		
		
		// Game start, result and placing of bet panel
		JLabel betPlacementLabel = new JLabel("Bet: $");
		betPlacementLabel.setForeground(Color.WHITE);
		inputBetTF = new JTextField(10);
		startButton = new JButton("Start");
		startButton.addActionListener(new StartButton());
		resultButton = new JButton("Result");	
		resultButton.addActionListener(new ResultButton());
		resultButton.setEnabled(false);
		startButton.setFont(f);
		startButton.setToolTipText("Start betting.");
		resultButton.setFont(f);
		resultButton.setToolTipText("Finish betting.");
		f = f.deriveFont(12);
		inputBetTF.setFont(f);
		inputBetTF.setToolTipText("Enter your bet.");
		f = f.deriveFont(16);
		betPlacementLabel.setFont(f);
		
		JPanel gamePanel = new JPanel();
		gamePanel.add(betPlacementLabel);
		gamePanel.add(inputBetTF);
		gamePanel.add(startButton);
		gamePanel.add(resultButton);
		gamePanel.setBackground(darkBlue);
		
		
		// InfoPanel
		betTextLabel = new JLabel("Place your bet!");
		moneyTextLabel = new JLabel("|  Amount of money you have: ");
		betLabel.setText("");
		moneyLabel.setText("$100");		
		JPanel infoPanel = new JPanel();
		infoPanel.add(betTextLabel); infoPanel.add(betLabel);
		infoPanel.add(moneyTextLabel); infoPanel.add(moneyLabel);
		
		f = f.deriveFont(14);
		betTextLabel.setFont(f);
		betLabel.setFont(f);
		moneyTextLabel.setFont(f);
		moneyLabel.setFont(f);	
		betTextLabel.setForeground(Color.WHITE);
		betLabel.setForeground(Color.RED);
		moneyTextLabel.setForeground(Color.WHITE);
		moneyLabel.setForeground(Color.RED);
		infoPanel.setBackground(darkBlue);
		
		
		// Main Panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(5, 1));
		mainPanel.add(dealerCardPanel); mainPanel.add(playerCardPanel);
		mainPanel.add(rpCardBtnPanel); mainPanel.add(gamePanel);
		mainPanel.add(infoPanel);
		
		// MenuBar
		JMenuBar menuBar = new JMenuBar();
		JMenu controlMenu = new JMenu("Control");
		JMenu helpMenu = new JMenu("Help");
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		JMenuItem instMenuItem = new JMenuItem("Instructions");
		exitMenuItem.addActionListener(new ExitMenuItem());
		instMenuItem.addActionListener(new HelpMenu());		
		controlMenu.add(exitMenuItem); helpMenu.add(instMenuItem);
		menuBar.add(controlMenu); menuBar.add(helpMenu);
		
		
		// Frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.setJMenuBar(menuBar);
		frame.setTitle("A Simple Card Game");
		frame.setSize(480, 600);
		frame.setVisible(true);
	}
	
	
	/**
	 * This class implements an ActionListener interface that is registered with
	 * the startButton in the GUI.
	 * 
	 * @author Junaid Zubair
	 * @version 1.0
	 */
	public class StartButton implements ActionListener {
		
		/**
		 *
		 * This method inherited from the ActionListener interface, takes an event,
		 * and performs the required actions once the event that this StartButton object
		 * is registered with occurs. This method checks whether the input bet is valid, that 
		 * is, whether it is a positive integer not larger than the amount of money the player
		 * has and if the bet is valid, it sets up the new round by performing the required 
		 * actions otherwise displays a message dialogue stating that the input bet is invalid.
		 * 
		 * @param event represents the event that occurred.
		 */
		public void actionPerformed(ActionEvent event) {
			try {
				int bet = Integer.parseInt(inputBetTF.getText());
				if (playerProfile.isValidBet(bet)) {
					startButton.setEnabled(false);
			        resultButton.setEnabled(true); rpCard3Button.setEnabled(true);
			        rpCard2Button.setEnabled(true); rpCard1Button.setEnabled(true);
			        
			        deck = new Deck();
					deck.shuffleDeck();
					
					playerProfile.setCurrentBet(bet);
					playerHand = new PlayerHand(deck);

					betLabel.setText(String.format("$%d", playerProfile.getCurrentBet()));
					betTextLabel.setText("Your current bet is: ");
				
					for(int i = 0; i < 3; i++) {
						Card c = playerHand.getCurrentHand().get(i);
						playerImgIcons.set(i, new ImageIcon(
								getClass().getResource(
										String.format("/Images/%s", c.getImageName()))));
						playerImgLabels.get(i).setIcon(playerImgIcons.get(i));
					}
					dealerHand = new DealerHand(deck);
				}
				else {
					JOptionPane.showMessageDialog(frame, 
							"WARNING: The bet you place must be a positive integer\nand must be smaller than your total balance!",
				               "WARNING: Wrong Bet", JOptionPane.WARNING_MESSAGE);
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(frame,
						"WARNING: The bet you place must be a positive integer\nand must not be greater than your total balance!",
			               "WARNING: Wrong Bet", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	
	/**
	 * 
	 * This class implements an ActionListener interface that is registered
	 * with the replacement buttons (rpCard1Button, rpCard2Button, rpCard3Button) 
	 * in the go() method. This is an abstract superclass that is further 
	 * extended. Sub-classes implement the inherited actionPerformed method.
	 * 
	 * @author Junaid Zubair
	 * @version 1.0
	 */
	public abstract class ReplacementButton implements ActionListener {
		
		/**
		 * This method takes in an integer cardNumber representing the Card object
		 * in the hand of a player that is to be replaced and a JButton jBtn corresponding
		 * to the card being replaced. This method is a helper function to implement the
		 * actionPerformed method used in sub-classes, and performs all the actions required
		 * once a card replacement button is clicked.
		 * 
		 * @param cardNumber represents the card being replaced.
		 * @param jBtn represents the card's corresponding replacement button.
		 */
		public void performReplacement(int cardNumber, JButton jBtn) {
			playerHand.replaceCard(deck, cardNumber);
			Card c = playerHand.getCurrentHand().get(cardNumber - 1);
			playerImgIcons.set(cardNumber - 1, new ImageIcon(
					getClass().getResource(
							String.format("/Images/%s", c.getImageName()))));
			playerImgLabels.get(cardNumber - 1).setIcon(playerImgIcons.get(cardNumber - 1));
			jBtn.setEnabled(false);
			playerProfile.incrementNumberOfReplacementsUsed();
			if(playerProfile.getNumberOfReplacementsUsed() >= 2) {
				rpCard1Button.setEnabled(false); 
				rpCard2Button.setEnabled(false);
				rpCard3Button.setEnabled(false);
			}
		}
	}
	
	
	/**
	 * This class implements an ActionListener interface that is registered with
	 * the JButton rpCard1Button in the GUI / go() method.
	 * 
	 * @author Junaid Zubair
	 * @version 1.0
	 */
	public class ReplacementButton1 extends ReplacementButton{
		
		/**
		 * This method inherited from the ActionListener interface, takes an event,
		 * and performs the required actions once the event that this ReplacementButton1
		 * object is registered with occurs.
		 * 
		 * @param event represents the event that occurred.
		 */
		public void actionPerformed(ActionEvent event) {
			performReplacement(1, (JButton) event.getSource());
		}
	}
	
	
	/**
	 * This class implements an ActionListener interface that is registered with
	 * the JButton rpCard2Button in the GUI / go() method.
	 * 
	 * @author Junaid Zubair
	 * @version 1.0
	 */
	public class ReplacementButton2 extends ReplacementButton{
		
		/**
		 * This method inherited from the ActionListener interface, takes an event,
		 * and performs the required actions once the event that this ReplacementButton2 
		 * object is registered with occurs.
		 * 
		 * @param event represents the event that occurred.
		 */
		public void actionPerformed(ActionEvent event) {
			performReplacement(2, (JButton) event.getSource());
		}
	}
	
	
	/**
	 * This class implements an ActionListener interface that is registered with
	 * the JButton rpCard3Button in the GUI / go() method.
	 * 
	 * @author Junaid Zubair
	 * @version 1.0
	 */
	public class ReplacementButton3 extends ReplacementButton{
		
		/**
		 * This method inherited from the ActionListener interface, takes an event,
		 * and performs the required actions once the event that this ReplacementButton3
		 * object is registered with occurs.
		 * 
		 * @param event represents the event that occurred.
		 */
		public void actionPerformed(ActionEvent event) {
			performReplacement(3, (JButton) event.getSource());
		}
	}
	
	
	/**
	 * This class implements an ActionListener interface that is registered with
	 * the JButton resultButton within the JPanel betPlacementPanel in the go() method.
	 * 
	 * @author Junaid Zubair
	 * @version 1.0
	 */
	public class ResultButton implements ActionListener{
		
		/**
		 * This method inherited from the ActionListener interface, takes an event,
		 * and performs the required actions once the event that this ResultButton
		 * is registered with occurs.
		 * 
		 * @param event represents the event that occurred.
		 */
		public void actionPerformed(ActionEvent event) {
			
			for(int i = 0; i < 3; i++) {
				Card c = dealerHand.getCurrentHand().get(i);
				dealerImgIcons.set(i, new ImageIcon(
						getClass().getResource(
								String.format("/Images/%s", c.getImageName()))));
				dealerImgLabels.get(i).setIcon(dealerImgIcons.get(i));
			}
	        
			boolean hasWon = playerHand.hasWon(dealerHand);
			playerProfile.setNewMoney(hasWon);
			
			if(playerProfile.getMoney() == 0) {
				moneyTextLabel.setText("");
				moneyLabel.setText("");
				betTextLabel.setText("You have no more money! Please start a new game!");
				betLabel.setText("");
				JOptionPane.showMessageDialog(frame, 
						"Game Over!\nYou have no money left!\nPlease start a new game!",
			               "Message", JOptionPane.INFORMATION_MESSAGE);
				startButton.setEnabled(false);
			}
			else {
				if(hasWon) {
					playerProfile.setNewMoney(true);
					JOptionPane.showMessageDialog(frame, 
							"Congratulations! You're the winner of this round!",
							"Message", JOptionPane.INFORMATION_MESSAGE);
					moneyLabel.setText(String.format("$%d", playerProfile.getMoney()));
					betTextLabel.setText("Place your bet to play!");
					betLabel.setText("");
				}
				else {
					playerProfile.setNewMoney(false);
					JOptionPane.showMessageDialog(frame, 
							"Sorry! Dealer wins this round!",
							"Message", JOptionPane.INFORMATION_MESSAGE);
					moneyLabel.setText(String.format("$%d", playerProfile.getMoney()));
					betTextLabel.setText("Place your bet to play!");
					betLabel.setText("");
				}
				startButton.setEnabled(true);

				for(int i = 0; i<3; i++) {
					dealerImgIcons.set(i, new ImageIcon(
							getClass().getResource("/Images/card_back.gif")));
					dealerImgLabels.get(i).setIcon(dealerImgIcons.get(i));
					
					playerImgIcons.set(i, new ImageIcon(
							getClass().getResource("/Images/card_back.gif")));
					playerImgLabels.get(i).setIcon(playerImgIcons.get(i));
				}
			}
			
			resultButton.setEnabled(false); rpCard3Button.setEnabled(false);
	        rpCard2Button.setEnabled(false); rpCard1Button.setEnabled(false);
		}
	}
	
	
	/**
	 * This class implements an ActionListener interface that is registered with
	 * the JMenuItem instMenuItem within the JMenu helpMenu in the GUI / go() method.
	 * 
	 * @author Junaid Zubair
	 * @version 1.0
	 */
	public class HelpMenu implements ActionListener{
		
		/**
		 * This method inherited from the ActionListener interface, takes an event,
		 * and displays a message dialogue that shows the rules to determine who has better cards
		 * when the event occurs.
		 * 
		 * @param event represents the event that occurred.
		 */
		public void actionPerformed(ActionEvent event) {
			JOptionPane.showMessageDialog(frame, 
					"Rules to determine who has better cards:\n"
					+ "  Rule 1: The one with more special cards wins.\n"
					+ "  Rule 2: If both have the same number of special cards, add the face\n"
					+ "               values of the other card(s) and take the remainder after dividing\n"
					+ "               the sum by 10. The one with a bigger remainder wins.\n "
					+ "              (Note: Ace = 1)\n"
					+ "  Rule 3: The dealer wins if both rule 1 and rule 2 cannot distinguish the\n"
					+ "               winner.",
		               "Help", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	
	/**
	 * This class implements an ActionListener interface that is registered with
	 * the JMenuItem exitMenuItem within the JMenu controlMenu in the GUI / go() method.
	 * 
	 * @author Junaid Zubair
	 * @version 1.0
	 */
	public class ExitMenuItem implements ActionListener{
		
		/**
		 * This method inherited from the ActionListener interface, takes an event,
		 * and closes the window containing the GUI when this event occurs.
		 * 
		 * @param event represents the event that occurred.
		 */
		public void actionPerformed(ActionEvent event) {
			frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
		}
	}

}
