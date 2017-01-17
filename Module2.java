/*
Austin Hasemeyer
CST-338 SP17

Main program
*/

import java.util.Scanner;

public class Module2
{
	public static void main(String[] args)
	{
	TripleString.getBet();
	//TripleString.Test();
	}
}

class TripleString
{
   public static final int MAX_LEN = 20;
   public static final int MAX_PULLS = 40;
   
   public static int[] pullWinnings = new int[MAX_PULLS];
   public static int numPulls = 0;
	
   private String string1;
   private String string2;
   private String string3;
   
   public TripleString()
   {
   pullWinnings[0] = 0;
   string1 = "";
   string2 = "";
   string3 = "";
   }
   
   private static boolean validString(String str)
   {
	   return (str.length() < MAX_LEN);
   }
   
   public static int getBet()
   {
      Scanner keyboard = new Scanner(System.in);
	   
      System.out.println("How much would you like to bet (1 - 100) or 0 to quit?");
      int betAmount = keyboard.nextInt();
	  if (betAmount == 0)
	  {
		  System.out.print("Thank you for playing at the Casino!");
	  }
	  else
	  {
         while ((betAmount < 0) || (betAmount > 100))
            {
               System.out.println("Enter a between 0 - 100.");
               betAmount = keyboard.nextInt();
            }
	  }
	  return betAmount;
   }
   
   public static void Test()
   {
      String testString = "less thanalkdfsjklasdjfklajsdlkfjklsdf 20";
	  if (validString(testString))
	  {
		  System.out.print("IT wokrs");
	  }
	  else
	  {
		  System.out.print("fucked up0");
	  }
   }
}