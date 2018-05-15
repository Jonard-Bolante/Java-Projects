/**
 * Created by Jonard_Bolante on 10/1/2016.
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ArrayListMainProgram {
    public static void main(String[] args) {
// Initialize my list and create a variable to hold all the data from the Staff class
        ArrayList<StaffMember> myList = new ArrayList<StaffMember>();
        Staff variable = new Staff();
// Add the arrays that were created in 'Staff' to my list
        for(int i=0; i<variable.getSize(); i++)
            myList.add(i, variable.getStaff(i));
// Printing my list to make sure I did it correctly. Display my list
        for(StaffMember x: myList)
            System.out.println(x);

// Time to prompt the user for an employee name
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nHello user. Please type an employee name");
        String employeeName = input.nextLine();

// Is the name the user typed inside the list? If so, prompt the user what he/she wants to do with employee record
        for(int i=0; i<myList.size(); i++)
            if (employeeName.equalsIgnoreCase(variable.getStaff(i).name)) {
                System.out.println("Good, the employee is in our system. Do you want to 'display', 'delete', or 'modify' " +
                        "the employee record? Type anything else to stop the program");
                String action = input.nextLine();
// DISPLAY? MODIFY? OR DELETE?
                if(action.equalsIgnoreCase("display"))
                    System.out.println(variable.getStaff(i));
                if(action.equalsIgnoreCase("modify"))           //THIS ALLOWS THE USER TO MODIFY EMPLOYEE RECORDS
                {
                    System.out.println("Name?");        String newName = input.nextLine();
                    System.out.println("Address?");     String newAddress = input.nextLine();
                    System.out.println("Phone Number?");String newNumber = input.nextLine();

                    variable.getStaff(i).name = newName;
                    variable.getStaff(i).address = newAddress;
                    variable.getStaff(i).phone = newNumber;
                    System.out.println("\n\nEmployee modified. Here is the information: \n" + variable.getStaff(i) + variable.getStaff(i).pay());
                }
                if(action.equalsIgnoreCase("delete"))
                {
                    myList.remove(i);
                    System.out.println(myList.get(i).name + " HAS BEEN DELETED");
                }
            }
            else{
                System.exit(0);
            }




    }
}