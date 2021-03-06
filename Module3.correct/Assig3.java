/*  Model solution
 * Assignment 3
 * Title: "Deck of Cards"
 *
 */

import java.util.Scanner;
import java.util.Random;

public class Assig3
{
   public static Scanner keyboardInput = new Scanner(System.in);
   public static void main(String[] args)
   {
      /*
      /////////// Card Testing ////////////////
      
      //Check default constructor
      Card myCards = new Card();
      
      //Check good Card
      Card myCards2 = new Card('K', Card.Suit.HEARTS);
      
      //Checking for bad value
      Card myCards3 = new Card('L', Card.Suit.HEARTS);
      
      // Good card that will be altered later to bad
      Card myCards4 = new Card('2', Card.Suit.CLUBS);
      
      //printing values
      System.out.println("\n*************** Testing Card Class *******************\n");
      System.out.println(myCards);
      System.out.println(myCards2);
      System.out.println(myCards3);
      System.out.println(myCards4);
      
      //change bad card to good and good card to bad
      myCards3.set('K', Card.Suit.valueOf("DIAMONDS"));
      myCards4.set('B', Card.Suit.valueOf("DIAMONDS"));
      
      //printing new values after set()
      System.out.println(myCards3);
      System.out.println(myCards4);
      
      /////////// Hand Testing ////////////////
      Hand myHand = new Hand();
      Card[] testCards = new Card[3];
      testCards[0] = myCards;
      testCards[1] = myCards2;
      testCards[2] = myCards3;
      
      //loading cards into hand
      boolean stillRoom = true;
      int cardCounter = 0;
      while(stillRoom)
      {
         stillRoom = myHand.takeCard(testCards[cardCounter]);
         cardCounter++;
         if(cardCounter >= testCards.length)
            cardCounter = 0;
      }
      
      //Print full hand
      System.out.println("\n*************** Testing Hand Class *******************\n");
      System.out.println("Hand full \nAfter deal");
      System.out.println(myHand);
      
      //Testing inspectCard()
      System.out.println("\nTesting inspectCard()");
      System.out.println(myHand.inspectCard(15));
      System.out.println(myHand.inspectCard(100));
      
      //playing cards out of hand
      System.out.println("\nPlaying cards out from hand:");
      cardCounter = 0;
      boolean stillCards = true;
      Card playedCard;
      
      //print cards as played, stop when invalid card
      while(stillCards)
      {
         playedCard = myHand.playCard();
         if(playedCard.getErrorFlag())
            stillCards = false;
         else
            System.out.println(playedCard);
      }
      System.out.println("\nAfter playing all cards");
      System.out.println(myHand);
      
      
      /////////// Deck Testing ////////////////
      */
      System.out.println("\n*************** Testing Deck Class *******************\n");
      Card testCard = new Card('2', Card.Suit.HEARTS);
      //Create new deck of 1 packs
      System.out.println("1 packs, unshuffled");
      Deck myDeck = new Deck(1);
      myDeck.removeCard(testCard);
      myDeck.addCard(testCard);
      System.out.println(myDeck.getNumCards());
      myDeck.sort();
      dealToScreen(myDeck);
      System.out.println("\n****************add card**************************\n");
      //System.out.println("\n******************remove card from deck******************\n");
      
      //Re-initialize deck with 2 packs, shuffle
      //System.out.println("2 packs, shuffled");
      //myDeck.init(2);
      //myDeck.shuffle();
      //dealToScreen(myDeck);

      //Re-initialize deck with 1 pack
      //System.out.println("1 pack, unshuffled");
      //myDeck.init(1);
      //dealToScreen(myDeck);

      //Re-initialize deck with 1 pack, shuffle
      //System.out.println("1 pack, shuffled");
      //myDeck.init(1);
      //myDeck.shuffle();
      //dealToScreen(myDeck);
      /*
      /////////// DECK & HAND TESTING ///////////////
      System.out.println("\n*************** Testing Hand & Deck *******************\n");
      myDeck.init(1);
      int numHands = 0;
      
      //get number of hands
      while(numHands < 1 || numHands > 10)
      {
         System.out.println("Please select the number of players one through ten:  ");
         numHands = keyboardInput.nextInt();
      }
      
      //unshuffled
      System.out.println("\nHere are our hands, from unshuffled deck: ");
      dealToHands(myDeck, numHands);
      
      //shuffled
      System.out.println("\nHere are our hands, from shuffled deck: ");
      myDeck.init(1);
      myDeck.shuffle();
      dealToHands(myDeck, numHands);
      */
   } 
   
    //deal deck out to hands and display, for Deck/Hand test
   private static void dealToHands(Deck myDeck, int numHands)
   {
      int deckSize = myDeck.getTopCard() + 1;
      Hand[] hands = new Hand[numHands];
      for(int j=0; j<numHands; j++)
         hands[j] = new Hand();
      
      //deal deck into hands
      for(int i = 0; i < deckSize; i++)
      {
         hands[i % numHands].takeCard(myDeck.dealCard());
      }
      
      //display hands
      for(int j = 0; j < numHands; j++)
      {
         System.out.println(hands[j].toString());
      }
   }
   
   //deal deck out to screen
   private static void dealToScreen(Deck myDeck)
   {
      int deckSize = myDeck.getTopCard() + 1;
      String deckString = "";
      String deckLineString = "";
      
      //deal cards into string
      for(int i = 0; i < deckSize; i++)
      {
         deckString += myDeck.dealCard().toString() + " / ";
      }
      
      //insert line breaks at every 70 chars
      for(int j = 0; j < deckString.length(); j += 70)
      {
         if(j + 70 > deckString.length())
            deckLineString += deckString.substring(j, deckString.length());
         else
            deckLineString += deckString.substring(j, j + 70);
         
         deckLineString += "\n";
      }
      System.out.println(deckLineString);
   }
   
}   



/****************CARD CLASS******************/
//Card Class will create cards to be used for game. Example Ace of Spades.
class Card
{
   public enum Suit{CLUBS, HEARTS, DIAMONDS, SPADES}; 
   public static char[] valueRanks = {'X', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K'};
   private char value;
   private int intValue; 
   private Suit suit;
   private boolean errorFlag; 

   //constructors 
   Card(char value, Suit suit)
   {
      set(value, suit);
   }
   // creates default value of Ace of Spades
   Card()
   {
      set('A', Suit.valueOf("SPADES"));
   }
   
   //checks to see if the input is proper for a card
   private boolean isValid(char value, Suit suit)
   {
      boolean isValid = true;
      Suit[] possibleSuit = Suit.values(); //create an array with predefined values
      
       if (value == '1' || value == '2' || value == '3' || value == '4'|| value == '5'|| value == '6' || value == '7'
            || value == '8' || value == '9' || value == 'T'|| value == 'J'|| value == 'K'|| value == 'Q'|| value == 'A' || value == 'X')
      {
         for (int i = 0; i < possibleSuit.length; i++)
         {
            if (suit == possibleSuit[i])
            {
               isValid = false;
            }   
         }
      }
   
      return isValid;
   }
   
   static void arraySort(Card[] card, int arraySize)
   {
      Card temp;        
      
      for(int i = 0; i < arraySize; i++)
      {
         for(int j = 0; j <  valueRanks.length; j++)
         {
            if(card[i].value == valueRanks[j])
            {
               card[i].intValue = j;
               break;
            }
         }
      }  
         for(int i = 0; i < arraySize; i++)
         {           
            for(int j = 1; j < (arraySize - i); j++)
            {
               if(card[j - 1].intValue > card[j].intValue)
               {
                  temp = card[j-1];
                  card[j - 1] = card[j];
                  card[j] = temp;
               }
            }
         }
   }
  
   
   
   //sets values for priviate members and runs through to make sure isValid is good using isValid method
   public boolean set(char value, Suit suit)
   {
      this.value = value;
      this.suit = suit;
      if (isValid(value, suit) == false)
      {
         this.errorFlag = false;
      }
      else
      {
         this.errorFlag = true;
      }
      return errorFlag;
      
   }
   //to string method allows main println
   public String toString()
   {   
      if (this.errorFlag == true)
      {
         return ("***INVALID***");
      }
      return (value + " " + suit);
   }
   
   //Accessors 
   public Suit getSuit()
   {
      return this.suit;
   }
   
   public char getValue()
   {
      return this.value;
   }
   
   public boolean getErrorFlag()
   {
      return this.errorFlag;
   }
   
   public boolean equals(Card card)
   {
      boolean isEqual = true;
      Card cardCopy = new Card(card.getValue(), card.getSuit());
      if (cardCopy.value != card.value ||cardCopy.suit != card.suit)
      {
         isEqual = false;
      }
      return isEqual;
   }
   
   
}

//************* Class Hand ************
//This class is for the cards that are in the player's hand
class Hand
{
   public int MAX_CARDS = 50; //max number of cards a player can have
   private Card[] myCards;  
   private int numCards = 0;  //cards currently in hand
   
   //Constructors
   //default
   public Hand()
   {
      myCards = new Card[MAX_CARDS];
   }
   
   //removes all cards from the hand
   public void resetHand()
   {
      numCards = 0;
   }
   
   //sort the hand
   public void sort()
   {
      Card.arraySort(myCards, myCards.length);
   }
   
   //adds a card to the next available position giving player a new card in hand
   public boolean takeCard(Card card)
   {
      boolean result;
      if (numCards >= MAX_CARDS)
      {
          result = false;
      }
      
      else
      {
          myCards[numCards] = new Card(card.getValue(), card.getSuit());

          numCards++;
          result = true;
      }     
      return result;
            
   }
   
   //returns and removes card in the top occupied position of the array
   //if hand is empty, return card with error flag set
   public Card playCard()
   {
      if(numCards == 0)
         return new Card('Z', Card.Suit.SPADES); //throw error flag
      Card card = new Card(myCards[numCards - 1].getValue(), myCards[numCards - 1].getSuit());
      numCards = numCards - 1;
      return card;
   }
   
   
   //stringizer to display cards
   public String toString()
   {
      int cardLength = numCards;
      String cardString = "Hand = (";
      for (int i=0; i<cardLength; i++)
      {
          String stringVal = String.valueOf(myCards[i]);
          cardString += stringVal + ",";
      }   
      cardString += ")";
      return cardString;
   }
   
   //Accessor for numCards
   public int numCards()
   {
      //returns number of cards
      return numCards;
   }
   
   //returns Card at cards[k], if k is invalid, returns a card with error flag.
   public Card inspectCard(int k)
   {
      Card card1;
      if (k > numCards || k < 0)
      {
         card1 = new Card('Z', Card.Suit.SPADES); //creates a card that will not work so error flag returns true
      }

      else
      {
         card1 = new Card(myCards[k - 1].getValue(), myCards[k - 1].getSuit());
      }
      return card1;
   }
   
}


//************** Class Deck *************

//Deck of cards, can be 1-6 packs of 52 cards.  Creates deck, shuffles, and deals
class Deck
{
   // Deck MEMBERS
   
   //6 packs of 52 cards max
   public final int MAX_CARDS = 336; 
   
   //To refer to instead of creating new instances of cards for each deck
   private static Card[] masterPack = new Card[56];
   
   //cards in deck, with topCard referring to the "card on top". Refers to cards from masterPack
   private Card[] cards;
   private int topCard;
   
   // Deck CONSTRUCTORS
   
   //creates masterPack if not already done and deck with 1 pack
   Deck()
   {
      if(masterPack[0] == null)
         allocateMasterPack();
      init(1);
   }
   
   //creates masterPack if not already done and deck with given number of packs
   Deck(int numPacks)
   {
      if(masterPack[0] == null)
         allocateMasterPack();
      init(numPacks);
   }
   
   // Deck METHODS
   
   public boolean addCard(Card card)
   {
      Card temp;
      temp = cards[topCard];
      cards[topCard + 1] = new Card();
      cards[topCard + 1] = card;
      topCard++;
      
      return true;
   }
   
   public boolean removeCard(Card card)
   {
      Card temp;
      
      for(int i = 0; i < topCard; i++)
      {
         if(cards[i].getValue() == card.getValue() && cards[i].getSuit() == card.getSuit())
         {         
            temp = this.cards[i];
            cards[i] = this.cards[topCard];
            this.cards[topCard] = temp;
            
            this.cards[topCard] = null;
            topCard--;
         }
      }
      return true;
   }
   
   public void sort()
   {
      Card.arraySort(cards, getNumCards());
   }
   
   public int getNumCards()
   {
      int numCards = topCard;
      return numCards + 1;
   }
   
   
   //initializes deck with references to cards in masterPack for given number of packs
   public void init(int numPacks)
   {
      //get number of cards and lower to max if needed
      int numCards = numPacks * 56;
      if(numCards > MAX_CARDS)
         numCards = MAX_CARDS;
      cards = new Card[numCards];
      
      //fill with references to cards in masterPack
      for(int i = 0; i < numCards; i++)
      {
         cards[i] = masterPack[i % 56];
      }
      
      //set the top of the deck
      topCard = numCards - 1;
   }
   
   //uses random gen to shuffle cards in deck. (Fisher-Yates algorithm)
   public void shuffle()
   {
      Random rand = new Random();
      int randIndex = 0;
      Card tempCard = cards[0];
      
      //count from top of deck down, get random index from cards below, swap with counter
      for(int i = this.getTopCard(); i > 0; i--)
      {
         randIndex = rand.nextInt(i + 1);
         tempCard = cards[i];
         cards[i] = cards[randIndex];
         cards[randIndex] = tempCard;
      }
   }
   
   //returns copy of top card, decrements topCard counter
   //if deck is empty, return card with error flag set
   public Card dealCard()
   {
      if (topCard < 0)
         return new Card('M', Card.Suit.SPADES);
      Card newCard = new Card(cards[topCard].getValue(), cards[topCard].getSuit());
      topCard--;
      return newCard;
   }
   
   //returns the top card location of deck
   public int getTopCard()
   {
      return topCard;
   }
   
   //returns Card at cards[k], if k is invalid, returns a card with error flag.
   public Card inspectCard(int k)
   {
      //if k is valid location in deck, return copy of card at k
      if (k <= this.getTopCard() && k >= 0)
      {
         Card newCard = new Card(cards[k].getValue(), cards[k].getSuit());
         return newCard;
      }
      //if k is invalid, return card with error flag
      else
      {
         return new Card('M', Card.Suit.CLUBS);
      }
   }
   
   //build static master pack of 52 cards, to refer to by various decks
   private static void allocateMasterPack()
   {
      int cardCount = 0;
      char cardVal;
      
      //cycle through the 4 suit options
      for(int suit = 0; suit < 4; suit++)
      {
         //cycle through the 13 card value options
         for(int val = 0; val < 14; val++)
         {
            // get card value character
            switch(val)
            {
               case 0:
                  cardVal = 'A';
                  break;
               case 9:
                  cardVal = 'T';
                  break;
               case 10:
                  cardVal = 'J';
                  break;
               case 11:
                  cardVal = 'Q';
                  break;
               case 12:
                  cardVal = 'K';
                  break;
               case 13:
                  cardVal = 'X';
                  break;
               default:
                  cardVal = (char)(val + 49);
                  break;
            }

            //get suit and put card in deck
            switch(suit)
            {
               case 0:
                  masterPack[cardCount] = new Card(cardVal, Card.Suit.CLUBS);
                  break;
               case 1:
                  masterPack[cardCount] = new Card(cardVal, Card.Suit.DIAMONDS);
                  break;
               case 2:
                  masterPack[cardCount] = new Card(cardVal, Card.Suit.HEARTS);
                  break;
               case 3:
                  masterPack[cardCount] = new Card(cardVal, Card.Suit.SPADES);
                  break;
            }
            cardCount++;
         }
      }
   }
}
/*

*************** Testing Card Class *******************

A SPADES
K HEARTS
***INVALID***
2 CLUBS
K DIAMONDS
***INVALID***

*************** Testing Hand Class *******************

Hand full 
After deal
Hand = (A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,K DIAMONDS,A SPADES,K HEARTS,)

Testing inspectCard()
K DIAMONDS
***INVALID***

Playing cards out from hand:
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES
K DIAMONDS
K HEARTS
A SPADES

After playing all cards
Hand = ()

*************** Testing Deck Class *******************

2 packs, unshuffled
K SPADES / Q SPADES / J SPADES / T SPADES / 9 SPADES / 8 SPADES / 7 SP
ADES / 6 SPADES / 5 SPADES / 4 SPADES / 3 SPADES / 2 SPADES / A SPADES
 / K HEARTS / Q HEARTS / J HEARTS / T HEARTS / 9 HEARTS / 8 HEARTS / 7
 HEARTS / 6 HEARTS / 5 HEARTS / 4 HEARTS / 3 HEARTS / 2 HEARTS / A HEA
RTS / K DIAMONDS / Q DIAMONDS / J DIAMONDS / T DIAMONDS / 9 DIAMONDS /
 8 DIAMONDS / 7 DIAMONDS / 6 DIAMONDS / 5 DIAMONDS / 4 DIAMONDS / 3 DI
AMONDS / 2 DIAMONDS / A DIAMONDS / K CLUBS / Q CLUBS / J CLUBS / T CLU
BS / 9 CLUBS / 8 CLUBS / 7 CLUBS / 6 CLUBS / 5 CLUBS / 4 CLUBS / 3 CLU
BS / 2 CLUBS / A CLUBS / K SPADES / Q SPADES / J SPADES / T SPADES / 9
 SPADES / 8 SPADES / 7 SPADES / 6 SPADES / 5 SPADES / 4 SPADES / 3 SPA
DES / 2 SPADES / A SPADES / K HEARTS / Q HEARTS / J HEARTS / T HEARTS 
/ 9 HEARTS / 8 HEARTS / 7 HEARTS / 6 HEARTS / 5 HEARTS / 4 HEARTS / 3 
HEARTS / 2 HEARTS / A HEARTS / K DIAMONDS / Q DIAMONDS / J DIAMONDS / 
T DIAMONDS / 9 DIAMONDS / 8 DIAMONDS / 7 DIAMONDS / 6 DIAMONDS / 5 DIA
MONDS / 4 DIAMONDS / 3 DIAMONDS / 2 DIAMONDS / A DIAMONDS / K CLUBS / 
Q CLUBS / J CLUBS / T CLUBS / 9 CLUBS / 8 CLUBS / 7 CLUBS / 6 CLUBS / 
5 CLUBS / 4 CLUBS / 3 CLUBS / 2 CLUBS / A CLUBS / 

2 packs, shuffled
3 SPADES / Q SPADES / K SPADES / 9 DIAMONDS / 3 HEARTS / 5 DIAMONDS / 
Q SPADES / J HEARTS / 9 DIAMONDS / 8 HEARTS / 8 SPADES / T CLUBS / T H
EARTS / 8 DIAMONDS / A CLUBS / 7 CLUBS / 3 DIAMONDS / 5 HEARTS / A CLU
BS / 2 SPADES / 5 CLUBS / J SPADES / 7 SPADES / 7 DIAMONDS / 4 HEARTS 
/ 4 SPADES / K DIAMONDS / T CLUBS / 2 DIAMONDS / 6 DIAMONDS / 7 HEARTS
 / 5 HEARTS / J DIAMONDS / 4 DIAMONDS / 3 CLUBS / 3 HEARTS / 7 DIAMOND
S / 4 CLUBS / Q DIAMONDS / T SPADES / 6 CLUBS / 9 SPADES / A SPADES / 
K CLUBS / 5 DIAMONDS / J DIAMONDS / K HEARTS / 7 CLUBS / 8 CLUBS / T H
EARTS / 4 DIAMONDS / T DIAMONDS / 7 SPADES / 4 SPADES / 6 HEARTS / 9 H
EARTS / 2 SPADES / K CLUBS / Q DIAMONDS / 3 DIAMONDS / 8 SPADES / T SP
ADES / 9 HEARTS / 6 SPADES / Q CLUBS / A DIAMONDS / 8 DIAMONDS / 2 HEA
RTS / A DIAMONDS / 9 SPADES / 9 CLUBS / 7 HEARTS / K SPADES / Q HEARTS
 / A HEARTS / 4 HEARTS / 8 HEARTS / Q HEARTS / 6 HEARTS / Q CLUBS / 6 
SPADES / 2 DIAMONDS / 8 CLUBS / 5 SPADES / K DIAMONDS / J CLUBS / 3 SP
ADES / 5 CLUBS / J CLUBS / 6 CLUBS / J HEARTS / 4 CLUBS / 2 HEARTS / A
 HEARTS / K HEARTS / A SPADES / J SPADES / 6 DIAMONDS / 3 CLUBS / 2 CL
UBS / 5 SPADES / 9 CLUBS / T DIAMONDS / 2 CLUBS / 

1 pack, unshuffled
K SPADES / Q SPADES / J SPADES / T SPADES / 9 SPADES / 8 SPADES / 7 SP
ADES / 6 SPADES / 5 SPADES / 4 SPADES / 3 SPADES / 2 SPADES / A SPADES
 / K HEARTS / Q HEARTS / J HEARTS / T HEARTS / 9 HEARTS / 8 HEARTS / 7
 HEARTS / 6 HEARTS / 5 HEARTS / 4 HEARTS / 3 HEARTS / 2 HEARTS / A HEA
RTS / K DIAMONDS / Q DIAMONDS / J DIAMONDS / T DIAMONDS / 9 DIAMONDS /
 8 DIAMONDS / 7 DIAMONDS / 6 DIAMONDS / 5 DIAMONDS / 4 DIAMONDS / 3 DI
AMONDS / 2 DIAMONDS / A DIAMONDS / K CLUBS / Q CLUBS / J CLUBS / T CLU
BS / 9 CLUBS / 8 CLUBS / 7 CLUBS / 6 CLUBS / 5 CLUBS / 4 CLUBS / 3 CLU
BS / 2 CLUBS / A CLUBS / 

1 pack, shuffled
6 DIAMONDS / A DIAMONDS / 4 DIAMONDS / Q DIAMONDS / K SPADES / J HEART
S / 5 DIAMONDS / 6 SPADES / Q SPADES / A SPADES / 9 CLUBS / 4 HEARTS /
 6 HEARTS / 6 CLUBS / A HEARTS / Q CLUBS / 3 SPADES / 5 SPADES / 3 CLU
BS / 7 DIAMONDS / K CLUBS / 7 SPADES / 8 SPADES / Q HEARTS / 9 HEARTS 
/ 5 CLUBS / 2 SPADES / T DIAMONDS / 4 SPADES / K DIAMONDS / 3 HEARTS /
 7 HEARTS / J SPADES / 7 CLUBS / 8 CLUBS / 4 CLUBS / J CLUBS / 3 DIAMO
NDS / K HEARTS / 5 HEARTS / T SPADES / 2 HEARTS / 8 DIAMONDS / J DIAMO
NDS / 9 SPADES / T HEARTS / T CLUBS / 9 DIAMONDS / 2 DIAMONDS / 2 CLUB
S / 8 HEARTS / A CLUBS / 


*************** Testing Hand & Deck *******************

Please select the number of players one through ten:  
7

Here are our hands, from unshuffled deck: 
Hand = (K SPADES,6 SPADES,Q HEARTS,5 HEARTS,J DIAMONDS,4 DIAMONDS,T CLUBS,3 CLUBS,)
Hand = (Q SPADES,5 SPADES,J HEARTS,4 HEARTS,T DIAMONDS,3 DIAMONDS,9 CLUBS,2 CLUBS,)
Hand = (J SPADES,4 SPADES,T HEARTS,3 HEARTS,9 DIAMONDS,2 DIAMONDS,8 CLUBS,A CLUBS,)
Hand = (T SPADES,3 SPADES,9 HEARTS,2 HEARTS,8 DIAMONDS,A DIAMONDS,7 CLUBS,)
Hand = (9 SPADES,2 SPADES,8 HEARTS,A HEARTS,7 DIAMONDS,K CLUBS,6 CLUBS,)
Hand = (8 SPADES,A SPADES,7 HEARTS,K DIAMONDS,6 DIAMONDS,Q CLUBS,5 CLUBS,)
Hand = (7 SPADES,K HEARTS,6 HEARTS,Q DIAMONDS,5 DIAMONDS,J CLUBS,4 CLUBS,)

Here are our hands, from shuffled deck: 
Hand = (J CLUBS,A SPADES,3 SPADES,5 HEARTS,9 HEARTS,Q CLUBS,6 CLUBS,9 DIAMONDS,)
Hand = (A DIAMONDS,K DIAMONDS,A HEARTS,3 CLUBS,8 HEARTS,Q DIAMONDS,K HEARTS,3 HEARTS,)
Hand = (8 DIAMONDS,2 HEARTS,J HEARTS,A CLUBS,9 CLUBS,K CLUBS,2 CLUBS,5 CLUBS,)
Hand = (7 CLUBS,T CLUBS,2 DIAMONDS,T HEARTS,6 DIAMONDS,T DIAMONDS,8 CLUBS,)
Hand = (K SPADES,4 SPADES,2 SPADES,5 DIAMONDS,3 DIAMONDS,6 SPADES,7 SPADES,)
Hand = (8 SPADES,5 SPADES,7 HEARTS,9 SPADES,4 CLUBS,Q SPADES,4 DIAMONDS,)
Hand = (Q HEARTS,J DIAMONDS,6 HEARTS,J SPADES,7 DIAMONDS,T SPADES,4 HEARTS,)


//////////////////Hand and Deck testing for invalid user input///////////
*************** Testing Hand & Deck *******************

Please select the number of players one through ten:  
20
Please select the number of players one through ten:  
-1
Please select the number of players one through ten:  
30
Please select the number of players one through ten:  
5

Here are our hands, from unshuffled deck: 
Hand = (K SPADES,8 SPADES,3 SPADES,J HEARTS,6 HEARTS,A HEARTS,9 DIAMONDS,4 DIAMONDS,Q CLUBS,7 CLUBS,2 CLUBS,)
Hand = (Q SPADES,7 SPADES,2 SPADES,T HEARTS,5 HEARTS,K DIAMONDS,8 DIAMONDS,3 DIAMONDS,J CLUBS,6 CLUBS,A CLUBS,)
Hand = (J SPADES,6 SPADES,A SPADES,9 HEARTS,4 HEARTS,Q DIAMONDS,7 DIAMONDS,2 DIAMONDS,T CLUBS,5 CLUBS,)
Hand = (T SPADES,5 SPADES,K HEARTS,8 HEARTS,3 HEARTS,J DIAMONDS,6 DIAMONDS,A DIAMONDS,9 CLUBS,4 CLUBS,)
Hand = (9 SPADES,4 SPADES,Q HEARTS,7 HEARTS,2 HEARTS,T DIAMONDS,5 DIAMONDS,K CLUBS,8 CLUBS,3 CLUBS,)

Here are our hands, from shuffled deck: 
Hand = (9 DIAMONDS,K DIAMONDS,8 DIAMONDS,3 CLUBS,5 DIAMONDS,9 HEARTS,3 DIAMONDS,T SPADES,J DIAMONDS,7 DIAMONDS,9 SPADES,)
Hand = (5 SPADES,A HEARTS,8 CLUBS,Q SPADES,3 SPADES,4 CLUBS,Q HEARTS,7 HEARTS,8 SPADES,J SPADES,2 CLUBS,)
Hand = (4 DIAMONDS,8 HEARTS,3 HEARTS,5 HEARTS,6 CLUBS,6 HEARTS,K SPADES,4 HEARTS,2 DIAMONDS,2 SPADES,)
Hand = (9 CLUBS,2 HEARTS,6 SPADES,A CLUBS,7 CLUBS,7 SPADES,J CLUBS,K CLUBS,T HEARTS,T DIAMONDS,)
Hand = (6 DIAMONDS,A DIAMONDS,Q CLUBS,Q DIAMONDS,5 CLUBS,A SPADES,J HEARTS,K HEARTS,4 SPADES,T CLUBS,)


*/
