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
	//TripleString.getBet();
	//TripleString.Test();
	//TripleString.pull();
	TripleString.setFirstString();
	TripleString.getFirstString();
	}
}

class TripleString
{
   public static final int MAX_LEN = 20;
   public static final int MAX_PULLS = 40;
   
   public static int[] pullWinnings = new int[MAX_PULLS];
   public static int numPulls = 0;
	
   private static String string1;
   private static String string2;
   private static String string3;
   
   public TripleString()
   {
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
   
   /*public TripleString pull()
   {
	   //blank so far
	   return;
   }
   */
   
   public static void setFirstString()
   {
      double randomNumber = (Math.random()*100);
	  
	  if ((randomNumber > 0) && (randomNumber <= 50))
	  {
		  string1 = "BAR";
	  }
	  else if ((randomNumber > 50) && (randomNumber <= 75))
	  {
		 string1 = "cherries"; 
	  }
	  else if ((randomNumber > 75) && (randomNumber <= 87.5))
	  {
		  string1 = "space";
	  }
	  else
	  {
		  string1 = "7";
	  }
   }
   
   public static String getFirstString()
   {   
	   System.out.print(string1);
	   return string1;
   }
   
   public static void Test()
   {
	   //Test method
   }
}



///GIT update test