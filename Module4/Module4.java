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
      //BarcodeImage.Test();
      DataMatrix.Test();
      
   }
}

interface BarcodeIO
{
   /*
   public boolean scan(BarcodeImage bc);
   public boolean readText(String text);
   public boolean generateImageFromText();
   public boolean translateImageToText();
   */
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
      return image_data[row][col] = value;
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
      scan(image);
   }
   
   public DataMatrix(String text)
   {
      readText(text);
      image = new BarcodeImage();
      actualWidth = 0;
      actualHeight = 0;
   }
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
   */
   
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
      System.out.println(i);
      } 
   }
   
   public void readText(String text)
   {
      this.text = text;
   }
   
   public void scan(BarcodeImage image)
   {
      this.image = image.clone();
   }
   
   private void cleanImage()
   {
      
   }
   
   private void moveImageToLowerLeft()
   {
      
   }
   
   private void shiftImageDown(int offset)
   {
      for(int i = 0; i < BarcodeImage.MAX_HEIGHT; i++)
      {
         for(int j = 0; j < BarcodeImage.MAX_WIDTH; j++)
            
      }
   }
   
   private void shiftImageLeft(int offset)
   {
      
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
      testDM.displayTextToConsole();
      System.out.println("-------------Test Image---------------");
      testDM.displayImageToConsole();
      System.out.println("\n\n-------------Test Image with string---------------\n\n");  
      DataMatrix testDmStr = new DataMatrix(testString);
      testDmStr.displayTextToConsole();
      testDmStr.displayImageToConsole(); 
      
      
   }   
}
