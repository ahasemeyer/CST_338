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
