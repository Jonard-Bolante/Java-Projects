import java.util.Scanner;

/**
 * Created by Jonard_Bolante on 9/21/2016.
 */
public class RecursionMain {
    public static void main(String[] args) {
//First create a Scanner variable to prompt the user for a number
        Scanner input = new Scanner(System.in);
        RecursionProblem user = new RecursionProblem();
        System.out.println("Welcome to Jonard's factorial program!");
// This is NOT the calculation. This is only just checking to see if the user types a valid NUMBER, no letters or special characters
        String base = "";
        String exponent = "";
        int baseNum = 0;
        int expoNum = 0;
        // This is the prompt for both base and exponents
        System.out.println("Please type any number. This number will be the base.\n");
        base = input.nextLine();
        System.out.println("Now for the exponent. Pick a number for the exponent\n");
        exponent = input.nextLine();
// THE USER BETTER ENTER AN INTEGER, NO SPECIAL CHARACTERS. IF SO, IT WILL REPEAT AND LOOP AND LOOP AND LOOP AND LOOP.
        while(true){
            try
            {   // If the number cannot concantenate into an integer, the user did NOT type a number
                baseNum = Integer.parseInt(base);
                expoNum = Integer.parseInt(exponent);
                break;
            }
            catch(NumberFormatException e)
            {
                System.out.println("ERROR! Please type a base and exponent as NUMBERS");
                base = input.nextLine();
                exponent = input.nextLine();

            }
        }
        int startTime = 0;
        int endTime = 0;
        int timeOne = 0;
        int timeTwo = 0;

//Now I am running the code and comparing the length it took in nanoseconds
//I first have to time it before AND after the method begins to get the time it took for the method to finish
        startTime = (int)System.nanoTime();
        System.out.println(user.rpow(baseNum,expoNum));
        endTime = (int)System.nanoTime();
        timeOne = endTime - startTime;
        System.out.println("The time it took for the first method to run is " + timeOne + " in nanoseconds");
        startTime = (int)System.nanoTime();
        System.out.println(user.rpow2(baseNum,expoNum));
        endTime = (int)System.nanoTime();
        timeTwo = endTime - startTime;
        System.out.println("The time it took for the second method to run is " + timeOne + " in nanoseconds");

        System.out.println("The time difference is " + (timeTwo-timeOne));



// LAST PART
// WERE GONNA TEST THE ODDEVENFACT FUNCTION FOR BOTH
// ODD AND EVEN NUMBERS
        System.out.println("5! factorial is " + user.oddevenfact(5));
        System.out.println("6! factorial is " + user.oddevenfact(6));
    }
}
