/**
@author Austin Hasemeyer
@author Samuel Roy
@author Ali Asrani

Programming Assignment 4
School: CSU, Monterey Bay
Course: CST 338 Software Design
Professor: Jesse Cecil, MS
*/
import java.lang.Integer;

public class Module4
{
   public static void main(String[] args)
   {
      String[] sImageIn =
      {
         "                                               ",
         "                                               ",
         "                                               ",
         "     * * * * * * * * * * * * * * * * * * * * * ",
         "     *                                       * ",
         "     ****** **** ****** ******* ** *** *****   ",
         "     *     *    ****************************** ",
         "     * **    * *        **  *    * * *   *     ",
         "     *   *    *  *****    *   * *   *  **  *** ",
         "     *  **     * *** **   **  *    **  ***  *  ",
         "     ***  * **   **  *   ****    *  *  ** * ** ",
         "     *****  ***  *  * *   ** ** **  *   * *    ",
         "     ***************************************** ",  
         "                                               ",
         "                                               ",
         "                                               "

      };      
            
         
      
      String[] sImageIn_2 =
      {
            "                                          ",
            "                                          ",
            "* * * * * * * * * * * * * * * * * * *     ",
            "*                                    *    ",
            "**** *** **   ***** ****   *********      ",
            "* ************ ************ **********    ",
            "** *      *    *  * * *         * *       ",
            "***   *  *           * **    *      **    ",
            "* ** * *  *   * * * **  *   ***   ***     ",
            "* *           **    *****  *   **   **    ",
            "****  *  * *  * **  ** *   ** *  * *      ",
            "**************************************    ",
            "                                          ",
            "                                          ",
            "                                          ",
            "                                          "

      };
      
     
      BarcodeImage bc = new BarcodeImage(sImageIn);
      DataMatrix dm = new DataMatrix(bc);
     
      // First secret message
      dm.translateImageToText();
      dm.displayTextToConsole();
      dm.displayImageToConsole();
      
      // second secret message
      bc = new BarcodeImage(sImageIn_2);
      dm.scan(bc);
      dm.translateImageToText();
      dm.displayTextToConsole();
      dm.displayImageToConsole();
      
      // create your own message
      dm.readText("What a great resume builder this is!");
      dm.generateImageFromText();
      dm.displayTextToConsole();
      dm.displayImageToConsole();
   }  
}

interface BarcodeIO
{
   
   public boolean scan(BarcodeImage bc);
   public boolean readText(String text);
   public boolean generateImageFromText();
   public boolean translateImageToText();
   public void displayTextToConsole();
   public void displayImageToConsole();
   
}

class BarcodeImage implements Cloneable
{
   public static final int MAX_HEIGHT = 30;
   public static final int MAX_WIDTH = 65;
   
   private boolean[][] image_data = new boolean[MAX_HEIGHT][MAX_WIDTH];;
   
   public BarcodeImage()
   {
      for(int i = 0; i < MAX_HEIGHT; i++)
      {
         for(int j = 0; j < MAX_WIDTH; j++)
         {
            image_data[i][j] = false;
         }
      } 
   }
   
   
   
   public BarcodeImage(String[] str_data)
   {
      //needs to check if str_dat is okay
      char[] charArray = new char[MAX_HEIGHT];

      for (int i = MAX_HEIGHT - str_data.length; i > 0; i--)
      {
         charArray = str_data[i].toCharArray();
         for (int j = 0; j < charArray.length; j++)
         {
            if(charArray[j] == '*')
            {
            image_data[i + (MAX_HEIGHT - str_data.length)][j] = true;               
            }
            else
            {
            image_data[i + (MAX_HEIGHT - str_data.length)][j] = false;      
            }
         }
      }
   }
   

   public BarcodeImage(BarcodeImage object)
   {   
      for(int i = 0; i < MAX_HEIGHT; i++)
      {
         for(int j = 0; j < MAX_WIDTH; j++)
         {
            this.image_data[i][j] = object.image_data[i][j];
         }
      }   
   }
   
   boolean getPixel(int row, int col)
   {
      //if(row <= MAX_WIDTH && col <= MAX_HEIGHT)
      //{
         return image_data[col][row];
      //}

   }
   
   boolean setPixel(int row, int col, boolean value)
   {
      //needs condition
      return image_data[col][row] = value;
   }

   
   
   
   
   public void displayToConsole() 
   {
      for(int i = 0; i < MAX_HEIGHT; i++)
      {
         for(int j = 0; j < MAX_WIDTH; j++)
         {
            if(image_data[i][j] == true)
            {
               System.out.print('*');
            }
            else
               System.out.print(' ');
         }
         System.out.println(i);
      } 
   }
   
   
   public BarcodeImage clone()
   {
      return new BarcodeImage(this);
   }
   
   
   public static void Test()
   {
      System.out.print("\n\n -----------------Test Default Constructor--------------------\n\n");
      BarcodeImage testImage = new BarcodeImage();
      testImage.displayToConsole();
      
      
      String[] sImageIn =
      {
         "                                               ",
         "                                               ",
         "                                               ",
         "     * * * * * * * * * * * * * * * * * * * * * ",
         "     *                                       * ",
         "     ****** **** ****** ******* ** *** *****   ",
         "     *     *    ****************************** ",
         "     * **    * *        **  *    * * *   *     ",
         "     *   *    *  *****    *   * *   *  **  *** ",
         "     *  **     * *** **   **  *    **  ***  *  ",
         "     ***  * **   **  *   ****    *  *  ** * ** ",
         "     *****  ***  *  * *   ** ** **  *   * *    ",
         "     ***************************************** ",  
         "                                               ",
         "                                               ",
         "                                               "

      };  
      
      System.out.print("\n\n -----------------Test Str Param Constructor--------------------\n\n");      
      BarcodeImage testArray = new BarcodeImage(sImageIn);
      testArray.displayToConsole();
      
      System.out.print("\n\n -----------------Test getPixel--------------------\n\n");    
      System.out.println("The Pixel is 10, 16: " + testArray.getPixel(10, 16));
      testArray.displayToConsole();
      
      System.out.print("\n\n -----------------Test setPixel--------------------\n\n");   
      System.out.println("Set Pixel 10, 16 to: " + testArray.setPixel(10, 16, true));
      testArray.displayToConsole();

      System.out.print("\n\n -----------------Test clone()--------------------\n\n");    
      BarcodeImage testClone;
      testClone = testArray.clone();
      testClone.displayToConsole();
      System.out.println("Set Pixel in clone 11, 16 to: " + testClone.setPixel(11, 16, true));
      testClone.displayToConsole(); //tests to make sure that only clone is effected and not the original object
      System.out.print("\n\n -----------------Test cloned object to make sure non altered--------------------\n\n");       
      testArray.displayToConsole();      
   }
   
    
}

class DataMatrix implements BarcodeIO
{
   public static final char BLACK_CHAR= '*';
   public static final char WHITE_CHAR = ' ';
   
   private BarcodeImage image;
   private String text;
   private int actualWidth, actualHeight;
   
   public DataMatrix()
   {
      text = "undefined";
      image = new BarcodeImage();
      actualWidth = 0;
      actualHeight = 0;
   }
   
   public DataMatrix(BarcodeImage image)
   {
      this.text = "undefined";
      this.scan(image);
   }
   
   public DataMatrix(String text)
   {
      readText(text);
      image = new BarcodeImage();
      actualWidth = 0;
      actualHeight = 0;
   }
   
    
   public boolean generateImageFromText()
   {
      char[] arrayText = text.toCharArray();
      //System.out.println(Integer.toBinaryString((int)arrayText[0]));
      
            for(int i = 0; i < arrayText.length; i++)
            {
               System.out.println(Integer.toBinaryString((int)arrayText[i]));           
            }          
      return true;
   }
   
   
   
   public boolean translateImageToText()
   {
      int jTotal = 0;
      for(int i = 1; i < this.getActualWidth() - 1; i++)
      {
         for(int j = BarcodeImage.MAX_HEIGHT - 1; j > (BarcodeImage.MAX_HEIGHT - this.getActualHeight()); j--)
         {
            if(this.image.getPixel(i, j) == true)
            {
               switch(j)
               {
                  case 28: jTotal += 1;
                           break;
                  case 27: jTotal += 2;
                           break;
                  case 26: jTotal += 4;
                           break;
                  case 25: jTotal += 8;
                           break;
                  case 24: jTotal += 16;
                           break;
                  case 23: jTotal += 32;
                           break;
                  case 22: jTotal += 64;
                           break;
                  case 21: jTotal += 128;
                           break;
                  default: jTotal = 0;
               }
            }
         }
      System.out.print((char)jTotal);
      jTotal = 0;
      } 
      return true;
   }
   
   
   public void displayTextToConsole()
   {
      System.out.println(this.text);
   }
   
   public void displayImageToConsole()
   {
      for(int i = 0; i < BarcodeImage.MAX_HEIGHT; i++)
      {
         for(int j = 0; j < BarcodeImage.MAX_WIDTH; j++)
         { 
         if(image.getPixel(j, i) == true)
         {
            System.out.print('*');
         }
         else
         {
            System.out.print(' ');
         }
         }
      System.out.println();
      } 
   }
   
   
   
   public boolean readText(String text)
   {
      this.text = text;
      return true;
   }
   
   
   
   public boolean scan(BarcodeImage image)
   {
      this.image = image.clone();
      this.cleanImage();
      this.computeSignalWidth();
      this.computeSignalHeight();
      return true;
   }
   
   
   
   private void cleanImage()
   {
      this.moveImageToLowerLeft();
   }
   
   
   
   private void moveImageToLowerLeft()
   {
      this.shiftImageDown(3);
      this.shiftImageLeft(5);     
   }
   
   
   
   private void shiftImageDown(int offset)
   {
      boolean temp;
      
      for (int k = 0; k < offset; k++)
      {
         for(int i = BarcodeImage.MAX_HEIGHT - 1; i > 0; i--)
         {
            for(int j = BarcodeImage.MAX_WIDTH - 1; j > 0; j--)
            {
               temp = image.getPixel(j , i - 1);
               image.setPixel(j, i,temp);
            }
         }
      }
   }
   
   
   public int getActualWidth()
   {
      return actualWidth;
   }
   
   
   public int getActualHeight()
   {
      return actualHeight;
   }
   
   
   private int computeSignalWidth()
   {
      for(int i = 0; i < BarcodeImage.MAX_WIDTH; i++)
      {
         if(this.image.getPixel(i , BarcodeImage.MAX_HEIGHT - 1) == true)
         {
            actualWidth++;
         }
      }
      return actualWidth;
   }
   
   
   private int computeSignalHeight()
   {
      for(int i = 0; i < BarcodeImage.MAX_HEIGHT; i++)
      {
         if(this.image.getPixel(0 , i) == true)
         {
            actualHeight++;
         }
      }
      return actualHeight;
   }
   
   
   
   private void shiftImageLeft(int offset)
   {
      boolean temp;
      
      for (int k = 0; k < offset; k++)
      {
         for(int i = 0; i < BarcodeImage.MAX_HEIGHT; i++)
         {
            for(int j = 0; j < BarcodeImage.MAX_WIDTH - 1; j++)
            {
               temp = image.getPixel(j + 1, i);
               image.setPixel(j, i,temp);
            }
         }
      }
   }
   
   
   
   public static void Test()
   {
      String[] sImageIn =
      {
         "                                               ",
         "                                               ",
         "                                               ",
         "     * * * * * * * * * * * * * * * * * * * * * ",
         "     *                                       * ",
         "     ****** **** ****** ******* ** *** *****   ",
         "     *     *    ****************************** ",
         "     * **    * *        **  *    * * *   *     ",
         "     *   *    *  *****    *   * *   *  **  *** ",
         "     *  **     * *** **   **  *    **  ***  *  ",
         "     ***  * **   **  *   ****    *  *  ** * ** ",
         "     *****  ***  *  * *   ** ** **  *   * *    ",
         "     ***************************************** ",  
         "                                               ",
         "                                               ",
         "                                               "
      };  
      String testString = "It accepts strings";     
      BarcodeImage testBar = new BarcodeImage(sImageIn);
      
      DataMatrix testDM = new DataMatrix(testBar);
      //testDM.displayTextToConsole();
      //System.out.println("-------------Test Image---------------");
      ////testDM.displayImageToConsole();
      //System.out.println("\n\n-------------Test Image with string---------------\n\n");  
      DataMatrix testDmStr = new DataMatrix(testString);
      //testDmStr.displayTextToConsole();
      //testDmStr.displayImageToConsole(); 
      //System.out.println("\n\n-------------Test Image with shift---------------\n\n");  
      //testDM.displayImageToConsole();
      //testDM.translateImageToText();
      testDM.generateImageFromText();
      
   }   
}


/*
Test Run

CSUMB CSIT online program is top notch.undefined




















* * * * * * * * * * * * * * * * * * * * *
*                                       *
****** **** ****** ******* ** *** *****
*     *    ******************************
* **    * *        **  *    * * *   *
*   *    *  *****    *   * *   *  **  ***
*  **     * *** **   **  *    **  ***  *
***  * **   **  *   ****    *  *  ** * **
*****  ***  *  * *   ** ** **  *   * *
*****************************************
 É ? C A å ? A ß ? A ? ? Å ? ?         undefined



















 * * * * * * * * * * * * * * * *
                                *
*** **   ***** ****   *********
********* ************ **********
     *    *  * * *         * *
 *  *           * **    *      **
* *  *   * * * **  *   ***   ***
         **    *****  *   **   **
 *  * *  * **  ** *   ** *  * *
*********************************

1010111
1101000
1100001
1110100
100000
1100001
100000
1100111
1110010
1100101
1100001
1110100
100000
1110010
1100101
1110011
1110101
1101101
1100101
100000
1100010
1110101
1101001
1101100
1100100
1100101
1110010
100000
1110100
1101000
1101001
1110011
100000
1101001
1110011
100001
What a great resume builder this is!



















 * * * * * * * * * * * * * * * *
                                *
*** **   ***** ****   *********
********* ************ **********
     *    *  * * *         * *
 *  *           * **    *      **
* *  *   * * * **  *   ***   ***
         **    *****  *   **   **
 *  * *  * **  ** *   ** *  * *
*********************************

*/



