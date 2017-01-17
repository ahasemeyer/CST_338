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
		do
		{
		   TripleString.getBet();
		   System.out.println("whirrrrrr .... and your pull is ... ");
		   TripleString.pull();
		   System.out.println(TripleString.pull());
		} while (TripleString.getBet() != 0);
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
   
      public static void setSecondString()
   {
      double randomNumber = (Math.random()*100);
	  
	  if ((randomNumber > 0) && (randomNumber <= 50))
	  {
		  string2 = "BAR";
	  }
	  else if ((randomNumber > 50) && (randomNumber <= 75))
	  {
		 string2 = "cherries"; 
	  }
	  else if ((randomNumber > 75) && (randomNumber <= 87.5))
	  {
		  string2 = "space";
	  }
	  else
	  {
		  string2 = "7";
	  }
   }
   
      public static void setThirdString()
   {
      double randomNumber = (Math.random()*100);
	  
	  if ((randomNumber > 0) && (randomNumber <= 50))
	  {
		  string3 = "BAR";
	  }
	  else if ((randomNumber > 50) && (randomNumber <= 75))
	  {
		 string3 = "cherries"; 
	  }
	  else if ((randomNumber > 75) && (randomNumber <= 87.5))
	  {
		  string3 = "(space)";
	  }
	  else
	  {
		  string3 = "7";
	  }
   }
   
   public static String getFirstString()
   {   
      return string1;
   }
   
   public static String getSecondString()
   {   
      return string2;
   }
   
   public static String getThirdString()
   {   
      return string3;
   }
   
   public static void Test()
   {
	   //Test method
   }
   
   public String toString()
   {
	   return(getFirstString() + " " + getSecondString() + " " + getThirdString());
   }
   
   public static TripleString pull()
   {   
	   TripleString testTriple = new TripleString();
	   testTriple.setFirstString();
	   testTriple.setSecondString();
	   testTriple.setThirdString();
	
	   return testTriple;
	   
   }
}



///GIT update test