import java.io.*;
import java.util.*;
public class Lab7
{
    public static void main(String args[])throws IOException
    {
        UALdictionary namesDic = new UALdictionary();
        StaffMember temp = new StaffMember();
        String hold[] = new String[4];
        UALdictionary ssDic = new UALdictionary();





/*
    CHECK IF THE FILE IS INSIDE AND READ IT
    OBTAIN DATA FROM SCANNER AND POPULATE DICTIONARY
 */
        try
        {
            File it = new File("employee.txt");
            Scanner stdin =new Scanner( new BufferedReader(new FileReader(it)));
            while(stdin.hasNext())
            {
                String temp2;
                hold=stdin.nextLine().split(",");
                temp.SetStaffMember(hold[0],hold[1],hold[2],hold[3], Double.parseDouble(hold[4]));
                temp2=temp.toString();
                namesDic.insert(temp.name,temp2);
                ssDic.insert(hold[3],temp2);
            }
        }




/*
DO "THIS" IF THE FILE DOES NOT EXIST OR CANNOT FILE THE CORRECT FILE
 */
        catch(FileNotFoundException e)
        {
            System.out.println("SORRY, CAN YOU CHECK IF THE FILE EXISTS?");
        }
        System.out.println("Type 'Name' which is going to be followed by a space\n " +
                            "and then the name you want to search or type 'Social' followed \n" +
                            "by a space and social security number you want to search\n" +
                            "Capitalization matters.");
        System.out.println("Enter ^z to end");
        Scanner stdin2= new Scanner(System.in);






/*
CONSTANTLY CHECK FOR COMMANDS BY THE USER.
 */
        while (stdin2.hasNext())
        {
            String command = stdin2.next();
            if(command.equalsIgnoreCase("name"))
            {
                String nam = stdin2.next();
                if(namesDic.find(nam)==null)
                    System.out.println(nam+" not in dictionary");
                else
                    System.out.println(namesDic.find(nam));
            }
            else if(command.equalsIgnoreCase("social"))
            {
                String soc = stdin2.next();
                if(ssDic.find(soc)==null)
                    System.out.println(soc+" not in dictionary");
                else
                    System.out.println(ssDic.find(soc));
            }
            else
                System.out.println("Bad command try again");
        }// END OF WHILE LOOP
    }// END OF MAIN() METHOD
}// END OF CLASS
