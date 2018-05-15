import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by Jonard Bolante on 11/16/2016.
 */
public class Lab9Runner
{
    public static void main(String[] args) throws IOException {
        File myFile = new File("patient.txt");
        String tempArray[] = new String[3];
        Scanner input = null;       int id;
        PriorityQueue<Patient> pq = new PriorityQueue<Patient>(20, howICompare);

        if(myFile.exists())
        {
            FileReader fr = new FileReader(myFile);
            BufferedReader br = new BufferedReader(fr);
            Patient s;

            System.out.println("This is a List of all my records that were inputted\n" +
                               "****************************************************");
            input = new Scanner(new BufferedReader(new FileReader(myFile)));
            while(input.hasNext())
            {
                tempArray = input.nextLine().split(",");
                id = Integer.valueOf(tempArray[0]);
                s = new Patient(id, tempArray[1],tempArray[2]);
                System.out.println("Record of PAtient: "+s.toString());
                pq.offer(s);
            }
            br.close();
            System.out.println("\n\n\n");
            System.out.println("This is a Priority Queue: \n" +
                               "****************************");

            while(true)
            {
                Patient currentPatient = pq.poll();
                if(currentPatient == null)
                {
                    break;
                }
                System.out.println(currentPatient.toString());
            }

        }
        else
            System.out.println("File named cust.txt does not exist");
    }































    public static Comparator<Patient> howICompare = new Comparator<Patient>()
    {
        public int compare(Patient p1, Patient p2)
        {
            return (int) (p1.getId() - p2.getId());
        }
    };
}
