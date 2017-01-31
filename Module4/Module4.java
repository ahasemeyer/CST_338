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
      char image_data[][] = new char[MAX_WIDTH][MAX_HEIGHT];
      for(int i = 0; i < MAX_WIDTH - 1; i++)
      {
         for(int j = 0; j < MAX_HEIGHT - 1; j++)
         {
            image_data[i][j] = '*';
         }
      } 
   }
   
   public void displayToConsole()
   {
      for(int i = 0; i < MAX_WIDTH - 1; i++)
      {
         for(int j = 0; j < MAX_HEIGHT - 1; j++)
         {
            System.out.print(image_data[i][j]);
         }
         System.out.println();
      }
   }
   
   
   public static void Test()
   {
      BarcodeImage testImage = new BarcodeImage();
      testImage.displayToConsole();
   }
   /*
    public Object clone()
    {
       
    }
    */
}

class DataMatrix implements BarcodeIO
{
   public static final char BLACK_CHAR= '*';
   public static final char WHITE_CHAR = ' ';
   
   private BarcodeImage image;
   private String text;
   private int actualWidth, actualHeight;
   
   /*
   public boolean scan(BarcodImage bc)
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
