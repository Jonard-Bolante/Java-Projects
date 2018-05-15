/**
 * Created by Jonard_Bolante on 9/16/2016.
 */
import java.util.Random;
public class Tester {
    public static void main(String[] args) {

        myFunction();   // CALLING MY METHOD WITH 2D ARRAYS
        Random r = new Random();
        System.out.println("\n");
// POPULATE AN EMPTY STRING WITH 8 RANDOM CHARACTERS
        String populate = "";
        char characters;
        for(int i=0; i<8; i++) {
            characters = (char) (r.nextInt(26) + 'a');
            populate += characters;
        }
        System.out.println(populate);



    }
// CREATING A 2D ARRAY AND USING THE RANDOM CLASS
    public static void myFunction() {
        int[][] myNumbers = new int[2][10];
        Random r = new Random();
        int randomNum = 0;
// Populating my 2D array with random numbers from 100-1000
// And then I print out the result of the array
        for (int x = 0; x < myNumbers.length; x++) {
            for (int y = 0; y < myNumbers[x].length; y++) {
                randomNum = (int) (Math.random() * 900) + 100;
                myNumbers[x][y] = randomNum;
            }
        }
        for (int[] a : myNumbers) {
            for (int b : a)
                System.out.print(b + "\t\t");
            System.out.println("\n");
        }
        System.out.println();
        System.out.println();


// Switching the top and bottom rows - then print array again to see results
        for(int i=0; i<myNumbers[1].length; i++){
            int temp = myNumbers[1][i];
            myNumbers[1][i] = myNumbers[0][i];
            myNumbers[0][i] = temp;
        }
        for(int x=0; x<myNumbers.length; x++){
            System.out.print("\n\n");
            for(int y =0; y<myNumbers[x].length; y++)
                System.out.print(myNumbers[x][y] + "\t\t");
        }
    }
}
