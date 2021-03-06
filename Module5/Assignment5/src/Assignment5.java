import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import javax.swing.border.*;


public class Assignment5
{
   static int NUM_CARDS_PER_HAND = 7;
   static int  NUM_PLAYERS = 2;
   static JLabel[] computerLabels = new JLabel[NUM_CARDS_PER_HAND];
   static JLabel[] humanLabels = new JLabel[NUM_CARDS_PER_HAND];  
   static JLabel[] playedCardLabels  = new JLabel[NUM_PLAYERS]; 
   static JLabel[] playLabelText  = new JLabel[NUM_PLAYERS]; 
   
   static Card generateRandomCard()
   {
	   Card returnCard;
	   Random rand = new Random();
	   
	   int randomValue;
	   int randomSuit;
	   
	   randomValue = rand.nextInt(14);
	   randomSuit = rand.nextInt(4);
	   
	   char[] setValue = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'X'};
	   Card.Suit[] allSuits = Card.Suit.values();
	   
	   
	   returnCard = new Card(setValue[randomValue], allSuits[randomSuit]);
	   return returnCard;
   }
   
   
   
   
   public static void main(String[] args)
   {
      int k;
      Icon tempIcon;
      
      int numPacksPerDeck = 1;
      int numJokersPerPack = 0;
      int numUnusedCardsPerPack = 0;
      Card[] unusedCardsPerPack = null;

      CardGameFramework highCardGame = new CardGameFramework( 
            numPacksPerDeck, numJokersPerPack,  
            numUnusedCardsPerPack, unusedCardsPerPack, 
            NUM_PLAYERS, NUM_CARDS_PER_HAND);
      
      highCardGame.deal();
      
      
      // establish main frame in which program will run
      CardTable myCardTable 
         = new CardTable("CardTable", NUM_CARDS_PER_HAND, NUM_PLAYERS);
      myCardTable.setSize(800, 600);
      myCardTable.setLocationRelativeTo(null);
      myCardTable.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      // show everything to the user
      myCardTable.setVisible(true);

      // CREATE LABELS ----------------------------------------------------
      GUICard.loadCardIcons();
      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
    	  computerLabels[k] = new JLabel(GUICard.getBackCardIcon());
      }
      
      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
    	  humanLabels[k] = new JLabel(GUICard.getIcon(highCardGame.getHand(0).inspectCard(k + 1)));
      }
      
      for (k = 0; k < NUM_PLAYERS; k++)
      {
    	  playedCardLabels[k] = new JLabel(GUICard.getIcon(highCardGame.getHand(k).playCard()));
      }
      
	  playLabelText[0] = new JLabel("You", JLabel.CENTER);
	  playLabelText[1] = new JLabel("Computer", JLabel.CENTER);
	  
	  
	  JButton playButton = new JButton("High Card");
	  playButton.addActionListener(new highCardListener());
	  
      // ADD LABELS TO PANELS -----------------------------------------
      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
    	  myCardTable.pnlComputerHand.add(computerLabels[k]);
      }
      
      for (k = 0; k < NUM_CARDS_PER_HAND; k++)
      {
    	  myCardTable.pnlHumanHand.add(humanLabels[k]);
      }
      
      // and two random cards in the play region (simulating a computer/hum ply)
      for (k = 0; k < NUM_PLAYERS; k++)
      {
    	  myCardTable.pnlPlayArea.add(playedCardLabels[k]);
      }
      
      for (k = 0; k < NUM_PLAYERS; k++)
      {
    	  myCardTable.pnlPlayArea.add(playLabelText[k]);
      }
      
      myCardTable.pnlPlayArea.add(playButton);

      myCardTable.setVisible(true);
   }
}


class highCardListener extends JFrame implements ActionListener
{	  
      public void actionPerformed(ActionEvent e)
      {
    	  String buttonString = e.getActionCommand();
			   
    	  if (buttonString.equals("High Card"))
    	  {
    		  System.out.println("NO CLUE");
    	  }
			
      }
	  
	  public highCardListener()
	  {
		  JButton playButton = new JButton("High Card");
		  playButton.addActionListener(this);
	  }
}


class CardTable extends JFrame
{
	static int MAX_CARDS_PER_HAND = 56;
	static int MAX_PLAYERS = 2;  // for now, we only allow 2 person games
   
	private int numCardsPerHand;
	private int numPlayers;

	public JPanel pnlComputerHand, pnlHumanHand, pnlPlayArea;	
 
	   
	public CardTable(String title, int numCardsPerHand, int numPlayers)
	{		
		numCardsPerHand = this.numCardsPerHand;
		numPlayers = this.numPlayers;
		setTitle(title);		
		
		pnlComputerHand = new JPanel();
		pnlComputerHand.setLayout(new GridLayout(1, numCardsPerHand));		
		pnlComputerHand.setBorder(BorderFactory.createTitledBorder("Computer Hand"));
		add(pnlComputerHand, BorderLayout.NORTH);	
		
		pnlHumanHand = new JPanel();
		pnlHumanHand.setLayout(new GridLayout(1, numCardsPerHand));
		pnlHumanHand.setBorder(BorderFactory.createTitledBorder("Your Hand"));		
		add(pnlHumanHand, BorderLayout.SOUTH);
		
		pnlPlayArea = new JPanel();
		pnlPlayArea.setLayout(new GridLayout(3, numPlayers));
		pnlPlayArea.setBorder(BorderFactory.createTitledBorder("Playing Area"));
		add(pnlPlayArea, BorderLayout.CENTER);		
	}	   
}
   

class GUICard extends JFrame
{
	private static Icon[][] iconCards = new ImageIcon[14][4]; // 14 = A thru K + joker
    private static Icon iconBack;
    static boolean iconsLoaded = false;
	 
    static void loadCardIcons()
    {
    	String[] suit = {"C", "D", "H", "S"};
        String[] value = {"A","2","3","4","5","6","7","8","9","T","J","Q","K","X"};
        
    	for (int i = 0; i <= 13; i++)
    	{
    		for (int k = 0; k <= 3; k++)
    		{
    			iconCards[i][k] = new ImageIcon("images/" + value[i] + suit[k] + ".gif");
    		}
    	}	      
    	iconBack = new ImageIcon("images/BK.gif", "back of deck");
    }	
    
    
    
    static public Icon getIcon(Card card)
    {
    	
    	return iconCards[valueAsInt(card)][suitAsInt(card)];
    }
    
    
    static public Icon getBackCardIcon()
    {
    	return iconBack;
    }
    
    
    static private int valueAsInt(Card card)
    {
    	int valueAsInt = 0;
    	char[] setValue = {'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'X'};
    	
    	for ( int i = 0; i < setValue.length; i++)
    	{
    		if(setValue[i] == card.getValue())
    		{
    			valueAsInt = i;
    			break;
    		}
    	}
    	return valueAsInt;
    }
    
    
    
    static private int suitAsInt(Card card)
    {
    	int suitAsInt = 0;
    	Card.Suit[] allSuits = Card.Suit.values();
    	
    	for ( int i = 0; i < allSuits.length; i++)
    	{
    		if(allSuits[i] == card.getSuit())
    		{
    			suitAsInt = i;
    			break;
    		}
    	}	
    	return suitAsInt;
    } 
}
   
   
   
   

/****************CARD CLASS******************/
//Card Class will create cards to be used for game. Example Ace of Spades.
class Card
{
   public enum Suit{CLUBS, HEARTS, DIAMONDS, SPADES}; 
   public static char[] valueRanks = {'X', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
   private char value;
   private int intValue; 
   private Suit suit;
   private boolean errorFlag; 

   //constructors 
   Card(char value, Suit suit)
   {
      set(value, suit);
   }
   // creates default value of Ace of Spades
   Card()
   {
      set('A', Suit.valueOf("SPADES"));
   }
   
   //checks to see if the input is proper for a card
   private boolean isValid(char value, Suit suit)
   {
      boolean isValid = true;
      Suit[] possibleSuit = Suit.values(); //create an array with predefined values
      
       if (value == '1' || value == '2' || value == '3' || value == '4'|| value == '5'|| value == '6' || value == '7'
            || value == '8' || value == '9' || value == 'T'|| value == 'J'|| value == 'K'|| value == 'Q'|| value == 'A' || value == 'X')
      {
         for (int i = 0; i < possibleSuit.length; i++)
         {
            if (suit == possibleSuit[i])
            {
               isValid = false;
            }   
         }
      }
   
      return isValid;
   }
   
   
   //Will assign an int value to a card value, then sorts by card value
   static void arraySort(Card[] card, int arraySize)
   {
      Card temp;        
      
      for(int i = 0; i < arraySize; i++)
      {
         for(int j = 0; j <  card.length; j++)
            if(card[j].value == valueRanks[i])
            {
               card[j].intValue = i;
               break;
            }
      }
      
      for(int i = 0; i < arraySize; i++)
      {           
         for(int j = 1; j < (arraySize - i); j++)
         {
            if(card[j - 1].intValue > card[j].intValue)
            {
               temp = card[j-1];
               card[j - 1] = card[j];
               card[j] = temp;
            }
         }
      }
   }
  
   
   
   //sets values for private members and runs through to make sure isValid is good using isValid method
   public boolean set(char value, Suit suit)
   {
      this.value = value;
      this.suit = suit;
      if (isValid(value, suit) == false)
      {
         this.errorFlag = false;
      }
      else
      {
         this.errorFlag = true;
      }
      return errorFlag;
      
   }
   //to string method allows main println
   public String toString()
   {   
      if (this.errorFlag == true)
      {
         return ("***INVALID***");
      }
      return (value + " " + suit);
   }
   
   //Accessors 
   public Suit getSuit()
   {
      return this.suit;
   }
   
   public char getValue()
   {
      return this.value;
   }
   
   public boolean getErrorFlag()
   {
      return this.errorFlag;
   }
   
   public boolean equals(Card card)
   {
      boolean isEqual = true;
      Card cardCopy = new Card(card.getValue(), card.getSuit());
      if (cardCopy.value != card.value ||cardCopy.suit != card.suit)
      {
         isEqual = false;
      }
      return isEqual;
   }   
}


//************* Class Hand ************
//This class is for the cards that are in the player's hand
class Hand
{
	public int MAX_CARDS = 50; //max number of cards a player can have
	private Card[] myCards;  
	private int numCards = 0;  //cards currently in hand

	//Constructors
	//default
	public Hand()
	{
		myCards = new Card[MAX_CARDS];
	}

	//removes all cards from the hand
	public void resetHand()
	{
		numCards = 0;
	}

	//sort the hand
	public void sort()
	{
		Card.arraySort(myCards, myCards.length);
	}

	//adds a card to the next available position giving player a new card in hand
	public boolean takeCard(Card card)
	{
		boolean result;
		if (numCards >= MAX_CARDS)
		{
			result = false;
		}
		else
		{
			myCards[numCards] = new Card(card.getValue(), card.getSuit());
			numCards++;
			result = true;
		}     
		return result;
         
	}

	//returns and removes card in the top occupied position of the array
	//if hand is empty, return card with error flag set
	public Card playCard()
	{
		if(numCards == 0)
			return new Card('Z', Card.Suit.SPADES); //throw error flag
		Card card = new Card(myCards[numCards - 1].getValue(), myCards[numCards - 1].getSuit());
		numCards = numCards - 1;
		return card;
	}


	//stringizer to display cards
	public String toString()
	{
		int cardLength = numCards;
		String cardString = "Hand = (";
		for (int i=0; i<cardLength; i++)
		{
			String stringVal = String.valueOf(myCards[i]);
			cardString += stringVal + ",";
		}   
		cardString += ")";
		return cardString;
	}

	//Accessor for numCards
	public int numCards()
	{
		//returns number of cards
		return numCards;
	}

	//returns Card at cards[k], if k is invalid, returns a card with error flag.
	public Card inspectCard(int k)
	{
		Card card1;
		if (k > numCards || k < 0)
		{
			card1 = new Card('Z', Card.Suit.SPADES); //creates a card that will not work so error flag returns true
		}
		else
		{
			card1 = new Card(myCards[k - 1].getValue(), myCards[k - 1].getSuit());
		}
		return card1;
	} 
}


//************** Class Deck *************

//Deck of cards, can be 1-6 packs of 52 cards.  Creates deck, shuffles, and deals
class Deck
{
	// Deck MEMBERS
	//6 packs of 52 cards max
	public final int MAX_CARDS = 336; 

	//To refer to instead of creating new instances of cards for each deck
	private static Card[] masterPack = new Card[56];

	//cards in deck, with topCard referring to the "card on top". Refers to cards from masterPack
	private Card[] cards;
	private int topCard;

	// Deck CONSTRUCTORS

	//creates masterPack if not already done and deck with 1 pack
	Deck()
	{
		if(masterPack[0] == null)
			allocateMasterPack();
		init(1);
	}

	//creates masterPack if not already done and deck with given number of packs
	Deck(int numPacks)
	{
		if(masterPack[0] == null)
			allocateMasterPack();
		init(numPacks);
	}

	// Deck METHODS
	 
	//Will add a card to the the Card[] cards
	public boolean addCard(Card card)
	{
		Card temp;
		temp = cards[topCard];
		cards[topCard + 1] = new Card();
		cards[topCard + 1] = card;
		topCard++;
   
		return true;
	}

	//Will remove a card from Card[] cards, then will make the topcard fill the vacant slot
	//which was where the removed card was
	public boolean removeCard(Card card)
	{
		Card temp;
		
		for(int i = 0; i < topCard; i++)
		{
			if(cards[i].getValue() == card.getValue() && cards[i].getSuit() == card.getSuit())
			{         
				temp = this.cards[i];
				cards[i] = this.cards[topCard];
				this.cards[topCard] = temp;
         
				this.cards[topCard] = null;
				topCard--;
			}
		}
		return true;
	}

	//sorts the deck using arraySort
	public void sort()
	{
		Card.arraySort(cards, getNumCards());
	}

	//returns the number of cards in the deck
	public int getNumCards()
	{
		int numCards = topCard;
		return numCards + 1;
	}


	//initializes deck with references to cards in masterPack for given number of packs
	public void init(int numPacks)
	{
		//get number of cards and lower to max if needed
		int numCards = numPacks * 56;
		if(numCards > MAX_CARDS)
			numCards = MAX_CARDS;
		cards = new Card[numCards];
   
		//fill with references to cards in masterPack
		for(int i = 0; i < numCards; i++)
		{
			cards[i] = masterPack[i % 56];
		}
   
		//set the top of the deck
		topCard = numCards - 1;
	}

	//uses random gen to shuffle cards in deck. (Fisher-Yates algorithm)
	public void shuffle()
	{
		Random rand = new Random();
		int randIndex = 0;
		Card tempCard = cards[0];
   
		//count from top of deck down, get random index from cards below, swap with counter
		for(int i = this.getTopCard(); i > 0; i--)
		{
			randIndex = rand.nextInt(i + 1);
			tempCard = cards[i];
			cards[i] = cards[randIndex];
			cards[randIndex] = tempCard;
		}
	}

	//returns copy of top card, decrements topCard counter
	//if deck is empty, return card with error flag set
	public Card dealCard()
	{
		if (topCard < 0)
			return new Card('M', Card.Suit.SPADES);
		Card newCard = new Card(cards[topCard].getValue(), cards[topCard].getSuit());
		topCard--;
		return newCard;
	}

	//returns the top card location of deck
	public int getTopCard()
	{
		return topCard;
	}

	//returns Card at cards[k], if k is invalid, returns a card with error flag.
	public Card inspectCard(int k)
	{
		//if k is valid location in deck, return copy of card at k
		if (k <= this.getTopCard() && k >= 0)
		{
			Card newCard = new Card(cards[k].getValue(), cards[k].getSuit());
			return newCard;
		}
		//if k is invalid, return card with error flag
		else
		{
			return new Card('M', Card.Suit.CLUBS);
		}
	}

	//build static master pack of 52 cards, to refer to by various decks
	private static void allocateMasterPack()
	{
		int cardCount = 0;
		char cardVal;
		
		//cycle through the 4 suit options
		for(int suit = 0; suit < 4; suit++)
		{
			//cycle through the 13 card value options
			for(int val = 0; val < 14; val++)
			{
				// get card value character
				switch(val)
				{
				case 0:
					cardVal = 'A';
					break;
				case 9:
					cardVal = 'T';
					break;
				case 10:
					cardVal = 'J';
					break;
				case 11:
					cardVal = 'Q';
					break;
				case 12:
					cardVal = 'K';
					break;
				case 13:
					cardVal = 'X';
					break;
				default:
					cardVal = (char)(val + 49);
					break;
				}
				//get suit and put card in deck
				switch(suit)
				{
	            case 0:
	               masterPack[cardCount] = new Card(cardVal, Card.Suit.CLUBS);
	               break;
	            case 1:
	               masterPack[cardCount] = new Card(cardVal, Card.Suit.DIAMONDS);
	               break;
	            case 2:
	               masterPack[cardCount] = new Card(cardVal, Card.Suit.HEARTS);
	               break;
	            case 3:
	               masterPack[cardCount] = new Card(cardVal, Card.Suit.SPADES);
	               break;
	         }
	         cardCount++;
	      }
	   }
	}
}


//class CardGameFramework  ----------------------------------------------------
class CardGameFramework extends JFrame
{	
   private static final int MAX_PLAYERS = 50;

   private int numPlayers;
   private int numPacks;            // # standard 52-card packs per deck
                                  // ignoring jokers or unused cards
   private int numJokersPerPack;    // if 2 per pack & 3 packs per deck, get 6
   private int numUnusedCardsPerPack;  // # cards removed from each pack
   private int numCardsPerHand;        // # cards to deal each player
   private Deck deck;               // holds the initial full deck and gets
                                  // smaller (usually) during play
   private Hand[] hand;             // one Hand for each player
   private Card[] unusedCardsPerPack;   // an array holding the cards not used
                                      // in the game.  e.g. pinochle does not
                                      // use cards 2-8 of any suit

   
   
   public CardGameFramework( int numPacks, int numJokersPerPack,
		   int numUnusedCardsPerPack,  Card[] unusedCardsPerPack,
		   int numPlayers, int numCardsPerHand)
   {	 
	  int k;

      // filter bad values
	  if (numPacks < 1 || numPacks > 6)
    	numPacks = 1;
	  if (numJokersPerPack < 0 || numJokersPerPack > 4)
		  numJokersPerPack = 0;
	  if (numUnusedCardsPerPack < 0 || numUnusedCardsPerPack > 50) //  > 1 card
		  numUnusedCardsPerPack = 0;
	  if (numPlayers < 1 || numPlayers > MAX_PLAYERS)
		  numPlayers = 4;
	  // one of many ways to assure at least one full deal to all players
	  if  (numCardsPerHand < 1 ||
			  numCardsPerHand >  numPacks * (52 - numUnusedCardsPerPack)
			  / numPlayers )
		  numCardsPerHand = numPacks * (52 - numUnusedCardsPerPack) / numPlayers;

	  // allocate
	  this.unusedCardsPerPack = new Card[numUnusedCardsPerPack];
	  this.hand = new Hand[numPlayers];
	  for (k = 0; k < numPlayers; k++)
		  this.hand[k] = new Hand();
	  deck = new Deck(numPacks);

	  // assign to members
	  this.numPacks = numPacks;
	  this.numJokersPerPack = numJokersPerPack;
	  this.numUnusedCardsPerPack = numUnusedCardsPerPack;
	  this.numPlayers = numPlayers;
	  this.numCardsPerHand = numCardsPerHand;
	  for (k = 0; k < numUnusedCardsPerPack; k++)
		  this.unusedCardsPerPack[k] = unusedCardsPerPack[k];
	

	  // prepare deck and shuffle
	  newGame();
   }

   // constructor overload/default for game like bridge
   public CardGameFramework()
   {
	   this(1, 0, 0, null, 4, 13);
   }

   public Hand getHand(int k)
   {
	   // hands start from 0 like arrays

	   // on error return automatic empty hand
	   if (k < 0 || k >= numPlayers)
 	     return new Hand();

	   return hand[k];
   }

   public Card getCardFromDeck() { return deck.dealCard(); }

   public int getNumCardsRemainingInDeck() { return deck.getNumCards(); }

   public void newGame()
   {
	   int k, j;

	   // clear the hands
	   for (k = 0; k < numPlayers; k++)
		   hand[k].resetHand();

	   // restock the deck
	   deck.init(numPacks);

	   // remove unused cards
	   for (k = 0; k < numUnusedCardsPerPack; k++)
		   deck.removeCard( unusedCardsPerPack[k] );

	   // add jokers
	   for (k = 0; k < numPacks; k++)
		   for ( j = 0; j < numJokersPerPack; j++)
			   deck.addCard( new Card('X', Card.Suit.values()[j]) );

	   // shuffle the cards
	   deck.shuffle();
   }

   public boolean deal()
   {
	   // returns false if not enough cards, but deals what it can
	   int k, j;
	   boolean enoughCards;

	   // clear all hands
	   for (j = 0; j < numPlayers; j++)
		   hand[j].resetHand();

	   enoughCards = true;
	   for (k = 0; k < numCardsPerHand && enoughCards ; k++)
	   {
		   for (j = 0; j < numPlayers; j++)
			   if (deck.getNumCards() > 0)
				   hand[j].takeCard( deck.dealCard() );
			   else
	          {
	             enoughCards = false;
	             break;
	          }
	   }
	   return enoughCards;
   }

   void sortHands()
   {
	   int k;

	   for (k = 0; k < numPlayers; k++)
		   hand[k].sort();
   }

   
   Card playCard(int playerIndex, int cardIndex)
   {
	   // returns bad card if either argument is bad
	   if (playerIndex < 0 ||  playerIndex > numPlayers - 1 ||
			   cardIndex < 0 || cardIndex > numCardsPerHand - 1)
	   {
		   //Creates a card that does not work
		   return new Card('M', Card.Suit.SPADES);      
	   }

	   // return the card played
	   return hand[playerIndex].playCard();

   }

   boolean takeCard(int playerIndex)
   {
	   // returns false if either argument is bad
	   if (playerIndex < 0 || playerIndex > numPlayers - 1)
		   return false;
  
	   // Are there enough Cards?
	   if (deck.getNumCards() <= 0)
		   return false;
	   return hand[playerIndex].takeCard(deck.dealCard());
   }
}


