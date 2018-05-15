//********************************************************************
//  Circle.java      
//
//********************************************************************

import java.text.*;

public class Circle extends Shape
{
   private int radius, x, y;

   //-----------------------------------------------------------------
   //  Constructor: Sets up this circle with the specified values.
   //-----------------------------------------------------------------
   public Circle (int size)
   {
      radius = size;
     
    }
   //-----------------------------------------------------------------
   //  Diameter mutator.
   //-----------------------------------------------------------------
   public void setRadius (int size)
   {
      radius = size;
   }

    //-----------------------------------------------------------------
   //  Diameter accessor.
   //-----------------------------------------------------------------
   public int getRadius ()
   {
      return radius;
   }
   
    //---------------------------------------------------------------------------
   //  Returns the calculated value of the area.
   //---------------------------------------------------------------------------
   
    public double computeArea() 
   {
      return 3.1416*(radius)*(radius);
   }
   
   //---------------------------------------------------------------------------
   //  Returns the calculated value of the perimeter.
   //---------------------------------------------------------------------------

     public double computePerimeter() 
   {
      return 3.1416 * 2 * radius;
   }

}
