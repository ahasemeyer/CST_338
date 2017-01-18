/* 
 * @author Austin Hasemeyer
 * @author Samuel Roy
 * @author Ali Asrani

 * Programming Assignment 2, Write a Java program: Casino (4 hrs) Casino with Methods and a Class
 * School: CSU, Monterey Bay
 * Course: CST 338 Software Design
 * Professor: Jesse Cecil, MS
 */

import java.util.Arrays;
import java.util.Scanner;

public class Module2
{
	public static void main(String[] args)
	{
		// Initialize main variables, userBet at 1000 is arbitrary, just can't be 0
		int userWinnings = 0;
		int finalWinnings = 0;
		int userBet = 1000;
		int count = 0;

		// While the user has not entered a 0 to end the main loop
		while(userBet != 0)
		{
			// Initialize TripleString class 
			TripleString slotMachine = new TripleString();    

			// Print out the current roll in program execution, I found this helpful
			//System.out.print(count + ". ");

			// Call getBet() and store in integer variable
			userBet = slotMachine.getBet();

			// If the user enters zero, thank them for playing and display their winnings, break loop
			if (userBet == 0)
			{
				System.out.println("Thank you for playing at the Casino!");
				System.out.print("Your individual winnings were: ");
				slotMachine.displayWinnings(count);
				System.out.println("\nYour total winnings were: $" + finalWinnings);
				break;
			}
			// Ignore any input that is not between 0-100
			else if (userBet < 0 || userBet > 100)
			{
				continue;
			}

			// Make a cool sound
			System.out.println("whirrrrrr .... and your pull is... ");

			// Initialize userPull to the TripleString slotMachine
			TripleString userPull = slotMachine.pull();

			// Calculate user winnings for the round
			userWinnings = slotMachine.getUserWinnings(userPull, userBet);

			// Display user roll
			slotMachine.display(userPull, userBet);

			// Save all data
			slotMachine.saveWinnings(userWinnings, count);	
			finalWinnings = finalWinnings + userWinnings;
			count = count + 1;

			// Formatting, so user is not disoriented 
			System.out.println("--------------------------------------------------------");

		}


	}
}

// Creation of primary class
class TripleString
{
	// Create class members
	public static final int MAX_LEN = 20;
	public static final int MAX_PULLS = 40;

	// Integer to store round winnings in array max 40
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

	// Saves the current round winnings into an array using the loop count
	public void saveWinnings(int winnings, int count)
	{
		pullWinnings[count] = winnings;
	}

	// Display each round by looping back through the original array
	public void displayWinnings(int count)
	{
		for (int i = 0; i < count; i++)
		{
			System.out.print(pullWinnings[i] + " ");
		}
	}

	private static boolean validString(String str)
	{
		return (str.length() < MAX_LEN);
	}

	// Asks user for a bet, takes in data using Scanner and returns their input
	public static int getBet()
	{
		Scanner keyboard = new Scanner(System.in);

		System.out.print("How much would you like to bet (1 - 100) or 0 to quit? ");
		int betAmount = keyboard.nextInt();

		return betAmount;
	}
   
   //Returns a string based on the propbablity of that string occuring 
   public static String randString()
   {
      String str = "";
      double randomNumber = (Math.random()*100);
      
		if ((randomNumber > 0) && (randomNumber <= 50))
		{
         str = "BAR";
		}
		else if ((randomNumber > 50) && (randomNumber <= 75))
		{
			str = "cherries"; 
		}
		else if ((randomNumber > 75) && (randomNumber <= 87.5))
		{
			str = "(space)";
		}
		else
		{
			str = "7";
		}
      
      return str;
   }
   
   //Sets the first string to a random string
	public static void setFirstString()
	{
      string1 = randString();
	}

   //Sets the second string to a random string
	public static void setSecondString()
	{
      string2 = randString();
	}

   //Sets the third string to a random string
	public static void setThirdString()
	{
      string3 = randString();
	}

   //Returns string1
	public static String getFirstString()
	{   
		return string1;
	}

   //Returns string2
	public static String getSecondString()
	{   
		return string2;
	}

   //Returns string3
	public static String getThirdString()
	{   
		return string3;
	}

   //Combines all 3 strings to 1 full string
	public String toString()
	{
		return(getFirstString() + " " + getSecondString() + " " + getThirdString());
	}

   //Assigns random strings to each string variable
	public static TripleString pull()
	{   
		TripleString pullString = new TripleString();
		pullString.setFirstString();
		pullString.setSecondString();
		pullString.setThirdString();

		return pullString;

	}

   //Applies a payMultiplier based on the combination of the strings
	public static int getPayMultiplier(TripleString thePull)
	{
		int payMultiplier;
      //cherries, not cherries, any : pays 5 x bet
		if ((thePull.getFirstString().equals("cherries")) && (!thePull.getSecondString().equals("cherries")))
		{
			payMultiplier = 5;
		}
      //cherries, cherries, not cherries : pays 15 x bet
		else if ((thePull.getFirstString().equals("cherries")) && (thePull.getSecondString().equals("cherries"))
				&& (!thePull.getThirdString().equals("cherries")))
		{
			payMultiplier = 15;
		}
      //cherries, cherries, cherries : pays 30 x bet
		else if ((thePull.getFirstString().equals("cherries")) && (thePull.getSecondString().equals("cherries")) 
				&& (thePull.getThirdString().equals("cherries")))
		{
			payMultiplier = 30;		   
		}
      //BAR, BAR, BAR : pays 50 x bet
		else if ((thePull.getFirstString().equals("BAR")) && (thePull.getSecondString().equals("BAR")) 
				&& (thePull.getThirdString().equals("BAR")))
		{
			payMultiplier = 50;			   
		}
      //7, 7, 7 : pays 100 x bet
		else if ((thePull.getFirstString().equals("7")) && (thePull.getSecondString().equals("7")) 
				&& (thePull.getThirdString().equals("7")))
		{
			payMultiplier = 100;		   
		}
      //all other combinations pay 0
		else
		{
			payMultiplier = 0;
		}
		return payMultiplier;
	}

	// Gets user winnings by multiplying userbet with getPayMultiplier functions
	public static int getUserWinnings(TripleString userPull, int userBet)
	{
		return (userBet * getPayMultiplier(userPull));
	}

	// Displays the current roll and how much the user has won during the roll
	public static void display(TripleString userPull, int userBet)
	{
		System.out.println(userPull.getFirstString() + " " + userPull.getSecondString() + " " + userPull.getThirdString());
		System.out.println("You won $" + getUserWinnings(userPull, userBet) + " dollars!");
	}
}
