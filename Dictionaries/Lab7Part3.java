import java.io.*;
import java.util.*;

public class Lab7Part3
{
    public static void main(String args[])throws IOException
    {
        TreeSet<String> employeeSet;
        employeeSet = new TreeSet<String>();
        String temp[] = new String[4];
        Scanner stdin = null;
        stdin = new Scanner(new BufferedReader(new FileReader("employee.txt")));






        while (stdin.hasNext())
        {
            temp = stdin.nextLine().split(",");
            employeeSet.add(temp[0]);
        }





        System.out.println("Type the Name you want to verify");
        System.out.println("Enter ^z to end");
        Scanner stdin2= new Scanner(System.in);





        while (stdin2.hasNext())
        {
            String command = stdin2.next();
            if(employeeSet.contains(command))
                System.out.println(command+" is an employee.");
            else
                System.out.println(command+" is not an employee");

        }
    }
}
