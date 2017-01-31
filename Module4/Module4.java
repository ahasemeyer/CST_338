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
   
}

public interface BarcodeIO
{
   public boolean scan(BarcodImage bc);
   public boolean readText(String text);
   public boolean generateImageFromText();
   public boolean translateImageToText();
   public void displayTextToConsole();
   public void displayImageToConsole();
}

public class BarcodeImage implements Cloneable
{
   public static final int MAX_HEIGHT = 30;
   
   private boolean[][] image_data;
   /*
    public Object clone()
    {
       
    }
    */
}

public class DataMatrix implements BarcodeIO
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
