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
      //Card.Test();
      //Hand.Test();
      Deck.Test();
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
   
   public static void resetHand()
   {
      myCards = new Card[MAX_CARDS];
      numCards = 0;
   }
   
   public static boolean takeCard(Card card)
   {  
      myCards[numCards] = card;
      numCards++;
      return true;
   }
   
   public static Card playCard()
   {
      Card returnCard = myCards[numCards - 1];
      
      myCards[numCards - 1] = null;
      numCards--;
      
      System.out.println("Playing " + returnCard);
      
      return returnCard;
   }
   
   public static Card inspectCard(int k)
   {
      return myCards[k];
   }
   
   public static void Test()
   {
      Hand testHand = new Hand();
      Card.Suit Hearts = Card.Suit.HEARTS;
      Card.Suit Clubs = Card.Suit.CLUBS;
      Card.Suit Spades = Card.Suit.SPADES;
      Card.Suit Diamonds = Card.Suit.DIAMONDS;
      
      Card firstCard = new Card('5', Hearts);
      Card secondCard = new Card('T', Clubs);
      Card thirdCard = new Card('9', Spades);
      Card fourthCard = new Card('2', Diamonds);
      
      
      System.out.println("Drawing 100 cards");
      
      for (int i = 0; i < Hand.MAX_CARDS / 4; i++)
      {
         Hand.takeCard(firstCard);
         Hand.takeCard(secondCard);
         Hand.takeCard(thirdCard);
         Hand.takeCard(fourthCard);
      }
      
      System.out.println("Inspecting Hand: ");
      
      for (int i = 0; i < Hand.MAX_CARDS; i++)
      {
         System.out.print("(" + i + ") - ");
         System.out.print(inspectCard(i) + ", ");
      }
      
      System.out.println("Playing all cards in hand: ");
      
      for (int i = 0; i < Hand.MAX_CARDS; i++)
      {
         Hand.playCard();
      }
      
      System.out.println("Inspecting Hand: ");
      
      for (int i = 0; i < Hand.MAX_CARDS; i++)
      {
         System.out.print(i + " - ");
         System.out.print(inspectCard(i) + ", ");
      }

      /*
      //System.out.println("values of first 3 cards added to hand 4th should be null");
      System.out.println(myCards[0] + " \n" + myCards[1] + " \n" + myCards[2] + "\n" + myCards[3]);
      
      resetHand();
      System.out.println("Aftrer resetHand all should be Null");
      System.out.println(myCards[0] + " \n" + myCards[1] + " \n" + myCards[2] + "\n" + myCards[3]);
      
      takeCard(firstCard);
      takeCard(secondCard);
      takeCard(thirdCard);
      System.out.println("values of first 3 cards added to hand 4th should be null");
      System.out.println(myCards[0] + " \n" + myCards[1] + " \n" + myCards[2] + "\n" + myCards[3]);
      
      System.out.println("----------TEST DIVIDER--------------");
      //playCard();
       */
   }
}

class Deck
{
   public final int MAX_CARDS = 6 * 52;
   
   private static Card[] masterPack;
   
   private Card[] cards;
   private int topCard;
   private static int numPacks;
   
   // Default constructor for Deck
   public Deck()
   {
      // create master pack
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
   
   // Overload Deck
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
     }
   
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
    }
   
   public static void Test()
   {
      Deck testDeck = new Deck(5);
      
      for(int i = 0; i < 52 * 5; i++)
      {
         System.out.println(i + ", " + testDeck.cards[i]);
      }

   }
    
   public void shuffle()
   {
      
   }
    
   /*
   public Card dealCard()
   {
      
   }
   
   public Card inspectCard(int k)
   {
      
   }
    
   private static void allocateMasterPack()
   {
      
   }
   */

}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     
     
     
   
