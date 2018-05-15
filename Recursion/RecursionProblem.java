import java.util.Scanner;

/**
 * Created by Jonard_Bolante on 9/21/2016.
 */
public class RecursionProblem {


//    A better recursive version:
    double rpow2(int x, int n)  // x is the base and n is the exponent
    {
        if (n == 0)                          // n = 0 is base part of recursive
            return 1.0;
        if (n % 2 == 1) // n is odd
        {
            double y = rpow2(x, (n - 1) / 2);
            return x * y * y;
        } else
        {
            double y = rpow2(x, n / 2);
            return y * y;
        }
    }


//    Recursive version:
    double rpow(int x, int n)
    {
        if (n == 0)
            return 1.0;
        return x * rpow(x, n - 1);
    }







// THIS FUNCTION FINDS THE FACTORIAL OF ONLY ODD/EVEN NUMBERS
    public long oddevenfact(long n){
// If the number is even/odd, then do THIS recursion
        if(n == 1 || n == 0)
                return 1;
        return oddevenfact(n-2) * n;
    }
}
