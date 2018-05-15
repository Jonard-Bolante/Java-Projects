import java.io.FileNotFoundException;
import java.util.TreeSet;
import java.io.*;
import java.util.Scanner;
import java.util.Locale;
import java.util.StringTokenizer;


/**
 * A staff is a employee.
 * 
 */
public class StaffEmployee
{
	private TreeSet<String> employeeSet;
	
	/**
	 * Sets up the employee name list by reading in the names from
	 * a file and storing them in a TreeSet.
	 * @throws FileNotFoundException
	 */
	public StaffEmployee() throws FileNotFoundException
	{
		employeeSet = new TreeSet<String>();
  
      String temp[] = new String[4];

		Scanner s = null;
      s = new Scanner(new BufferedReader(new FileReader("employee.txt")));
		
		while (s.hasNext())
		{
         temp = s.nextLine().split(",");
			employeeSet.add(temp[0]);
		}
	}
	
	/**
	 * Checks to see if the specified name is on the list.
	 * 
	 * @return true if the name is there and false otherwise
	 */
	public boolean employeeIsverified(String person )
	{
		return employeeSet.contains(person);
	}
}
