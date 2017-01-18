/*
Austin Hasemeyer
CST-338 SP17

Main program
*/

import java.util.Arrays;
import java.util.Scanner;

public class Module2
{
	public static void main(String[] args)
	{
		int userWinnings = 0;
		int finalWinnings = 0;
		int userBet = 1000;
		int count = 0;
		
		while(userBet != 0)
		{
			TripleString slotMachine = new TripleString();    
			
			System.out.print(count + ". ");
			userBet = slotMachine.getBet();
			
			if (userBet == 0)
			{
				System.out.println("Thank you for playing at the Casino!");
				System.out.print("Your individual winnings were: ");
				slotMachine.displayWinnings(count);
				System.out.println("\nYour total winnings were: $" + finalWinnings);
				break;
			}
			else if (userBet < 0 || userBet > 100)
			{
				continue;
			}
		
			System.out.println("whirrrrrr .... and your pull is... ");
			
			TripleString userPull = slotMachine.pull();
			
			// Calculate user winnings for the round
			userWinnings = slotMachine.getUserWinnings(userPull, userBet);
			
			// Display user roll
			slotMachine.display(userPull, userBet);
			
			// Save all data
			slotMachine.saveWinnings(userWinnings, count);	
			finalWinnings = finalWinnings + userWinnings;
			count = count + 1;
			
			System.out.println("--------------------------------------------------------");
	        
		}
      
      
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
   
   public void saveWinnings(int winnings, int count)
   {
	   pullWinnings[count] = winnings;
   }
   
   public void displayWinnings(int count)
   {
	   for (int i = 0; i < count; i++)
	   {
		   System.out.print(pullWinnings[i] + ", ");
	   }
   }
   
   private static boolean validString(String str)
   {
	   return (str.length() < MAX_LEN);
   }
   
   public static int getBet()
   {
      Scanner keyboard = new Scanner(System.in);
	   
      System.out.print("How much would you like to bet (1 - 100) or 0 to quit? ");
      int betAmount = keyboard.nextInt();

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
		  string1 = "(space)";
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
		  string2 = "(space)";
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
   
   public String toString()
   {
	   return(getFirstString() + " " + getSecondString() + " " + getThirdString());
   }
   
   public static TripleString pull()
   {   
	   TripleString pullString = new TripleString();
	   pullString.setFirstString();
	   pullString.setSecondString();
	   pullString.setThirdString();
	     
	   return pullString;
	   
   }
   
   public static int getPayMultiplier(TripleString thePull)
   {
	   int payMultiplier;
	   if ((thePull.getFirstString().equals("cherries")) && (!thePull.getSecondString().equals("cherries")))
	   {
		   payMultiplier = 5;
	   }
	   else if ((thePull.getFirstString().equals("cherries")) && (thePull.getSecondString().equals("cherries"))
         && (!thePull.getThirdString().equals("cherries")))
	   {
		   payMultiplier = 15;
	   }
	   else if ((thePull.getFirstString().equals("cherries")) && (thePull.getSecondString().equals("cherries")) 
         && (thePull.getThirdString().equals("cherries")))
	   {
		   payMultiplier = 30;		   
	   }
	   else if ((thePull.getFirstString().equals("BAR")) && (thePull.getSecondString().equals("BAR")) 
         && (thePull.getThirdString().equals("BAR")))
	   {
		   payMultiplier = 50;			   
	   }
	   else if ((thePull.getFirstString().equals("7")) && (thePull.getSecondString().equals("7")) 
         && (thePull.getThirdString().equals("7")))
	   {
		   payMultiplier = 100;		   
	   }
	   else
	   {
		   payMultiplier = 0;
	   }
	   return payMultiplier;
   }
   
   public static int getUserWinnings(TripleString userPull, int userBet)
   {
	   return (userBet * getPayMultiplier(userPull));
   }
   
   public static void display(TripleString userPull, int userBet)
   {
      System.out.println(userPull.getFirstString() + " " + userPull.getSecondString() + " " + userPull.getThirdString());
      System.out.println("You won $" + getUserWinnings(userPull, userBet) + " dollars!");
   }
}
