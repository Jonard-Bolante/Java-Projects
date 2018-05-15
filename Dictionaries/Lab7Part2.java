import java.io.*;
import java.util.*;

public class Lab7Part2
{
    public static void main(String args[])
    {
        Shape s1 = new Rectangle(20,5);
        Shape s2 = new Circle(6);
        max(s1,s2);
    }




    public static void max(Shape st1, Shape st2)
    {
        CompareShape s = new CompareShape();
        if(s.compare(st1,st2)==0)
            System.out.println("The shapes are equal in area");
        else if(s.compare(st1,st2)>0)
        {
            if(st1 instanceof Rectangle)
                System.out.println("Shape 1, a rectangle, has more area");
            else if(st1 instanceof Circle)
                System.out.println("Shape 1, a circle, has more area");
        }
        else if(s.compare(st1,st2)<0)
        {
            if(st2 instanceof Rectangle)
                System.out.println("Shape 2, a rectangle, has more area");
            else if(st2 instanceof Circle)
                System.out.println("Shape 2, a circle, has more area");
        }

    }
}
