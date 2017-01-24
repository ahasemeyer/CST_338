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
       this.value = value;
       this.suit = suit;
    }
    
    
    public void setValue(char value)
    {
       this.value = value;
    }
    
    public void setSuit(Suit suit)
    {
       this.suit = suit;
    }
    
    public void getValue()
    {
       return value;
    }
    
    public void getSuit()
    {
       return suit;
    }
    
    /*
    private boolean errorFlag(char value, Suit suit)
    {
       
    }
    */
    
    public static void Test()
    {
      Suit testSuit = Suit.valueOf("CLUBS");
       
      Card test = new Card('K', testSuit);
      System.out.println(test.value);
      System.out.println(test.suit);
      test.setValue('J');
      test.setSuit(Suit.HEARTS);
      System.out.println(test.value);
      System.out.println(test.suit);

;
    }
 }
/*
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
 
 
 */
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
     
     
     
   
