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
    }
 }
 
 

 class Card
 {
    enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES};
    
    private char value;
    private static Suit suit;
    private boolean errorFlag;
    
    public Card()
    {
       value = 'A';
       suit = Suit.valueOf("SPADES");
       errorFlag = false;
    }

    public Card(char value, Suit suit)
    {
       
    }
    
    public static void Test()
    {
      Card test = new Card();
      System.out.println(test.suit);
      System.out.println("");
      if (test.errorFlag)
         System.out.println("True");
      else
         System.out.println("False");
    }
 }

 class Hand
 {
     public static int MAX_CARDS = 100;
     
     private Card[] myCards;
     private int numCards;
     
     public Hand()
     {
         
     }
     
     void resetHand()
     {
         
     }
     
     boolean takeCard(Card card)
     {
         
     }
     
     Card playCard()
     {
         
     }
     
     String toString()
     {
         
     }
     
     Card inspectCard(int k)
     {
        
     }
     
 }
 
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
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     
     
     
   
