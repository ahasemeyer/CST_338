/**
@author Austin Hasemeyer
@author Samuel Roy
@author Ali Asrani

Programming Assignment 4
School: CSU, Monterey Bay
Course: CST 338 Software Design
Professor: Jesse Cecil, MS
*/


public class Module4
{
   public static void main(String[] args)
   {
      BarcodeImage.Test();
      
   }
}

interface BarcodeIO
{
   /*
   public boolean scan(BarcodeImage bc);
   public boolean readText(String text);
   public boolean generateImageFromText();
   public boolean translateImageToText();
   public void displayTextToConsole();
   public void displayImageToConsole();
   */
}

class BarcodeImage implements Cloneable
{
   public static final int MAX_HEIGHT = 30;
   public static final int MAX_WIDTH = 65;
   
   private char[][] image_data = new char[MAX_HEIGHT][MAX_WIDTH];;
   
   public BarcodeImage()
   {
      for(int i = 0; i < MAX_HEIGHT; i++)
      {
         for(int j = 0; j < MAX_WIDTH; j++)
         {
            image_data[i][j] = '*';
         }
      } 
   }
   
   
   
   public BarcodeImage(String[] str_data)
   {
      char[] charArray = new char[MAX_HEIGHT];
      
      for (int i = 0; i < str_data.length; i++)
      {
         charArray = str_data[i].toCharArray();
         for (int j = 0; j < charArray.length; j++)
         {
            image_data[MAX_HEIGHT - i - 1][j] = charArray[j];
         }
      }
   }
      
   


   
   
   
   
   public void displayToConsole() 
   {
      for(int i = 0; i < MAX_HEIGHT; i++)
      {
         for(int j = 0; j < MAX_WIDTH; j++)
         {
            System.out.print(image_data[i][j]);
         }
         System.out.println(i);
      } 
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
      


   }
   /*
    public Object clone()
    {
       
    }
    *
}

class DataMatrix implements BarcodeIO
{
   public static final char BLACK_CHAR= '*';
   public static final char WHITE_CHAR = ' ';
   
   private BarcodeImage image;
   private String text;
   private int actualWidth, actualHeight;
   
   
   /*
   public boolean scan(BarcodeImage bc)
   {
      
   }
   
   public boolean readText(String text)
   {
      
   }
   
   public boolean generateImageFromText()
   {
      
   }
   
   public boolean translateImageToText()
   {
      
   }
   
   public void displayTextToConsole()
   {
      
   }
   
   public void displayImageToConsole()
   {
      
   }
   */
}
