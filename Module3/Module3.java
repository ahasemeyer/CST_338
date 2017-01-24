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
       
    }
 }
 
 
 public class Card
 {
    enum Suit {CLUBS, DIAMONDS, HEARTS, SPADES};
    
    private char value;
    private Suit suit;
    private boolean errorFlag;
    
    public Card()
    {
       value = 'A';
       suit = Suit.valueOf("SPADES");
    }
    
    public static void Test()
    {
       Card();
       System.out.print(Card.value);
    }
 }
 
 //TEST  