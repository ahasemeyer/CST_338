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
   
   private boolean[][] image_data;
   
   public BarcodeImage()
   {
      boolean image_data[][] = new boolean[MAX_HEIGHT][MAX_WIDTH];
      for(int i = 0; i < MAX_HEIGHT; i++)
      {
         for(int j = 0; j < MAX_WIDTH; j++)
         {
            image_data[i][j] = false;
            System.out.print(image_data[i][j]);
         }
         System.out.println(i);
      } 
   }
   
   public BarcodeImage(String[] str_data)
   {
      boolean image_data[][] = new boolean[MAX_HEIGHT][MAX_WIDTH];
      
      for(int i = MAX_HEIGHT; i > 0; i--)
      {
         for(int j = MAX_WIDTH; j > 0; j--)
         {
            
         }
      }
      
   }
   
   
   
      /*()
      for (int i = 0; i < str_data.length; i++)
      {
         for (int k = 0; k < str_data[k].length(); k++)
         {
            boolean image_data[][] = new boolean[i][k];
         }
      }
      */

   
   
   
   
   public void displayToConsole()
   {
      for(int i = 0; i < MAX_WIDTH; i++)
      {
         for(int j = 0; j < MAX_HEIGHT; j++)
         {
            System.out.print(image_data[i][j]);
         }
         System.out.println();
      }
   }
   
   
   public static void Test()
   {
      BarcodeImage testImage = new BarcodeImage();
     // testImage.displayToConsole();
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
