/**
* @author Austin Hasemeyer
* @author Samuel Roy
* @author Ali Asrani

* Programming Assignment 3
* School: CSU, Monterey Bay
* Course: CST 338 Software Design
* Professor: Jesse Cecil, MS
*/
 
public class Module3
{
   public static void main(String[] arg)
   {
      Card.Test();
      Hand.Test();
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
      char[] allValues = {'1', '2', '3', '4', '5', '6' , '7', '8', '9' ,'T', 'J', 'Q', 'K', 'A'};
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
   {}
   
}

class Hand
{
   public static int MAX_CARDS = 100;
    
   private static Card[] myCards;
   private static int numCards;
     
   public Hand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   public void resetHand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   public static boolean takeCard(Card card)
   {  
      Hand.myCards[Hand.numCards] = card;
      numCards++;
      return true;
   }
   
   public static void Test()
   {
      Hand testHand = new Hand();
      Card.Suit Hearts = Card.Suit.HEARTS;
      Card.Suit Clubs = Card.Suit.CLUBS;
      Card.Suit Spades = Card.Suit.SPADES;
      Card firstCard = new Card('5', Hearts);
      Card secondCard = new Card('T', Clubs);
      Card thirdCard = new Card('9', Spades);
      
      takeCard(firstCard);
      takeCard(secondCard);
      takeCard(thirdCard);
      
      System.out.println(myCards[0] + " \n" + myCards[1] + " \n" + myCards[2]);
      
   }
}

/*

class Deck
{
   public final int MAX_CARDS = 6 * 52;
   
   private static Card[] masterPack;
   
   private Card[] cards;
   private int topCard;
   private int numPacks;
    
   public Deck(int numPacks)
   {
      
   }
    
   public void init(int numPacks)
   {
      
   }
    
   public void shuffle()
   {
      
   }
    
   public Card dealCard()
   {
      
   }
   
   public Card inspectCard(int k)
   {
      
   }
    
   private static void allocateMasterPack()
   {
      
   }
   
}
 
 
*/
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     
     
     
   
