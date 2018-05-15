import java.io.*;
import java.util.*;
public class CompareShape implements Comparator<Shape> {

    public int compare (Shape s1, Shape s2)
    {
        double a = s1.computeArea();
        double b = s2.computeArea();
        int d=0;

        if(a==b)            d = 0;
        else if(a>b)        d = 1;
        else if(a<b)        d = -1;

        return d;
    }
}