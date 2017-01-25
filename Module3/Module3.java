/**
@author Austin Hasemeyer
@author Samuel Roy
@author Ali Asrani

Programming Assignment 3
School: CSU, Monterey Bay
Course: CST 338 Software Design
Professor: Jesse Cecil, MS
*/

import java.util.Scanner;

public class Module3
{
   
   public static void main(String[] arg)
   {
      //Card.Test();
      //Hand.Test();
      //Deck.Test();
      
      int count = 0;
      int input = 4;
      
      Deck firstDeck = new Deck(1);
      Hand[] playerHand = new Hand[input];
      
      for (int i = 0; i < input; i++)
      {
         playerHand[i] = new Hand();
      }

      
      //playerHand[0].takeCard(firstDeck.dealCard()); 
      //System.out.println(playerHand[0].inspectCard(0));
      
      
      while(firstDeck.inspectCard(firstDeck.getTopCard() - 1) != null)
      {
         playerHand[count].takeCard(firstDeck.dealCard());
         
         count++;
         
         if(count == input)
            count = 0;
      }

      for (int i = 0; i < input; i++)
      {
         System.out.println("\nHand " + i + " ");
         
         for(int j = 0; j < 52/count; j++)
         {
            System.out.print(playerHand[i].inspectCard(j) + ", ");
         }
         
      }
      
      firstDeck.init(1);
      
      for (int i = 0; i < input; i++)
      {
         playerHand[i].resetHand();
      }
      
      firstDeck.shuffle();
      
      while(firstDeck.inspectCard(firstDeck.getTopCard() - 1) != null)
      {
         playerHand[count].takeCard(firstDeck.dealCard());
         
         count++;
         
         if(count == input)
            count = 0;
      }

      for (int i = 0; i < input; i++)
      {
         System.out.println("\nHand " + i + " ");
         
         for(int j = 0; j < 52/count; j++)
         {
            System.out.print(playerHand[i].inspectCard(j) + ", ");
         }
         
      }
      
     
      /** TESTING Deck Class **
      Deck testDeck = new Deck(2);
      System.out.println("Dealing 2 decks! ");
      
      for (int i = testDeck.getTopCard(); i > 0; i--)
      {
         testDeck.dealCard();
      }
      
      System.out.println("Initializing 2 more decks! ");
      testDeck.init(2);
      
      System.out.println("Shuffling cards! ");
      testDeck.shuffle();
      
      for (int i = testDeck.getTopCard(); i > 0; i--)
      {
         testDeck.dealCard();
      }
      
      Deck testSingleDeck = new Deck(1);
      System.out.println("Dealing 1 decks! ");
      
      for (int i = testSingleDeck.getTopCard(); i > 0; i--)
      {
         testSingleDeck.dealCard();
      }
      
      System.out.println("Initializing 1 more decks! ");
      testSingleDeck.init(1);
      
      System.out.println("Shuffling cards! ");
      testSingleDeck.shuffle();
      
      for (int i = testSingleDeck.getTopCard(); i > 0; i--)
      {
         testSingleDeck.dealCard();
      }
      **/
      
      
   }
}
 

/**
   Definition of the class Card, which will store a playing cards information
   such as its Value and its Suit this class will also determine if the entered
   values are legal.
*/
class Card
{
   enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES};
   
   private char value;
   private Suit suit;
   private static boolean errorFlag;
   
   /**
      Default constructor for Card
   */
   public Card()
   {
      value = 'A';
      suit = Suit.valueOf("SPADES");
      errorFlag = false;
   }
   
   /**
      Constructor for the class card with parameters
      @param char value and Suit suit
   */
   public Card(char value, Suit suit)
   {
      if(!isValid(value, suit))
      {
         errorFlag(value, suit);
      }
      else
      {
         this.value = value;
         this.suit = suit;
      }
   }
   
   /**
      Mutator set will set the value and suit to an object of type card
      @param char value and Suit suit
   */
   public void set(char value, Suit suit)
   {
      if(!isValid(value, suit))
      {
         errorFlag(value, suit);
      }
      else
      {
         this.value = value;
         this.suit = suit;
      }
   }

   /**
      Accesses a cards Value
      @return value
   */
   public char getValue()
   {
      return value;
   }
   
   /**
      Accesses a cards Suit
      @return suit
   */
   public Suit getSuit()
   {
      return suit;
   }
   
   /**
      Converts an object of type Card to a string
      @return "A of SPADES"
   */
   public String toString()
   {
      return(value + " of " + suit);
   }
    
   /**
      Tests two objects of type card to see if they are equals
      @return true if equal flase is not equal
   */
   public boolean equals(Card otherCard)
   {
      return((this.suit == otherCard.suit) && (this.value == otherCard.value));
   }
   
   /**
      Tests if the values entered are compatible with the type Card
      @return true if they are compatible false if not
   */
   private static boolean errorFlag(char value, Suit suit)
   {
      if(isValid(value, suit))
      {
         return false;
      }
      else
      {
         System.out.println("** illegal **");
         return true;
      }
   }
   
   /**
      Tests to see if Value and Suit are allowed by checking our predefined allSuits and allValues
      @return true if entered values exist and false if not
   */
   private static boolean isValid(char value, Suit suit)
   {
      Suit[] allSuits = Suit.values();
      char[] allValues = {'2', '3', '4', '5', '6' , '7', '8', '9' ,'T', 'J', 'Q', 'K', 'A'};
      for(int i = 0; i < allSuits.length; i++)  //First checks to see if suit is in allSuits
      {
         if (suit == allSuits[i])
         {
            for(int j = 0; j < allValues.length; j++) //Then checks to see if value is in allValues
               if(value == allValues[j])
               {
                  return true;
               }
         }
      }
      return false;
   }
    

   public static void Test()
   {
      /*Use this function to test methods of type card */
   }
   
}

/**
   Definition of class Hand. This class will collect the cards 
   that are in a players hand.
*/
class Hand
{
   public static int MAX_CARDS = 100;
    
   private static Card[] myCards;
   private static int numCards;
    
   /**
   Default constructor for Hand() makes an uninitalized hand that can
   take up to 100 cards
   */    
   public Hand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   /**
   Will reset Hand back to the inital uninitialized values
   */
   public static void resetHand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
 
   /**
   Will add your card to the array myCards using numCards to count the amount
   of cards in your hand
   @param takes an object of type Card
   @return will return true if the card is accepted
   */ 
   public static boolean takeCard(Card card)
   {  
      myCards[numCards] = card;
      numCards++;
      return true;
   }
   
   /**
   Discard the top card from your hand and return it
   @return returns top card in hand
   */
   public static Card playCard()
   {
      Card returnCard = myCards[numCards - 1];
      
      myCards[numCards - 1] = null;
      numCards--;
      
      System.out.println("Playing " + returnCard);
      
      return returnCard;
   }
   
   /**
   Returns a card at the appropriate index
   @param int k, which is the index for the card
   @return returns card at index k
   */
   public static Card inspectCard(int k)
   {
      return myCards[k];
   }
   
   public static void Test()
   {
      /* Test methods of type Hand */
   }
}

/**
Defintion of the class Deck which will create a Deck of cards or multiple
decks of cards and perform various functions on them
*/
class Deck
{
   public final int MAX_CARDS = 6 * 52;
   
   private static Card[] masterPack;
   
   private Card[] cards;
   private int topCard;
   private static int numPacks;
   
   /**
   Allocates a master pack that is 52 cards in order
   */
   private static void allocateMasterPack()
   {
      masterPack = new Card[52];
      char[] allValues = {'2', '3', '4', '5', '6' , '7', '8', '9' ,'T', 'J', 'Q', 'K', 'A'};
      
      int count = 0;
      
      for (Card.Suit suits : Card.Suit.values())
         for (int i = 0; i < allValues.length; i++)
         {
            masterPack[count] = new Card(allValues[i], suits);
            count++;

            if (count == 52)
               break;
         }  
   }
   
   /**
   Default constructor for Deck
   */
   public Deck()
   {
      allocateMasterPack();     
   }
   
   /**
   Will create decks depending on the amount of packs that you would like to use
   @param Number of Packs
   */
   public Deck(int numPacks)
   {
      Deck master = new Deck();
      
      cards = new Card[52 * numPacks];
      
      int count = 0;
      
      for (int i = 0; i < numPacks; i++)
         for (int k = 0; k < 52; k++)
         {
            cards[count] = master.masterPack[k];
            
            count++;
            
            if (count == 52 * numPacks)
               break;
         }
      
      topCard = cards.length - 1;
     }
     
   /**
   Reinitiates a master pack that is unaltered depending on the number of packs
   you would like to use
   @param Number of Packs
   */
    public void init(int numPacks)
    {
       Deck master = new Deck();
       
       cards = new Card[52 * numPacks];
       
       int count = 0;
       
       for (int i = 0; i < numPacks; i++)
          for (int k = 0; k < 52; k++)
          {
             cards[count] = master.masterPack[k];
             
             count++;
             
             if (count == 52 * numPacks)
                break;
          }
       
       topCard = cards.length - 1;
    }

   /**
   Shuffles the deck
   */    
   public void shuffle()
   {
      for (int i = cards.length - 1; i > 0; i--)
      {
         int random = (int)(Math.random()*(i + 1));
         Card temp = cards[i];
         cards[i] = cards[random];
         cards[random] = temp;
      }
   }
    
   /**
   Will deal a card from the deck while removing it from the deck so it can 
   not be delt again
   @return the card that was delt
   */
   public Card dealCard()
   {
      
      Card dealtCard = cards[topCard];
      
      cards[topCard] = null;
      topCard--;
      
      System.out.println("Dealing " + dealtCard);
      
      return dealtCard;
   }

   /**
   Accessor for the top card
   @return topCard
   */
   public int getTopCard()
   {
      return topCard;
   }
   
   /**
   Will give you a card at and index
   @param the index of your card
   @return the card at the given index
   */
   public Card inspectCard(int k)
   {
      if(k < topCard && k >= 0)
         return cards[k];
      else
      {
         System.out.print("Not an actual card: ");
         return null;
      }
   }

   public static void Test()
   {
        /*Use to test methods of type Deck */
   }
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     
     
     
   
