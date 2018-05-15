import sun.awt.image.ImageWatched;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Jonard Bolante on 10/19/2016.
 */
public class QueueMain {
    public static void main(String[] args) {
// PART 1
        for (int x = 0; x < 10; x++) {
            System.out.printf("Cycle:%d\n",x+1);
            Random random = new Random();
            int numOfTellers = random.nextInt(4) + 1;
            int numOfCustomers = random.nextInt(6);
            Line customerLine = new Line();

            System.out.printf("numOfCustomers:%d\n", numOfCustomers);
            System.out.printf("numOfTellers:%d\n", numOfTellers);

            for (int i = 0; i < numOfCustomers; i++) {
                Customer customer = new Customer(i + 1);
                customerLine.addCustomer(customer);
                System.out.printf("Customer %s goes on line%n", customer.toString());
            }




            while (!customerLine.isEmpty()) {
                if (customerLine.size() < numOfTellers)
                    System.out.println("Teller is waiting");
                for (int i = 1; i < numOfTellers + 1; i++) {
                    if (customerLine.isEmpty()) { break; }
                    String currentId = customerLine.nextCustomer().toString();
                    System.out.printf("Customer %s is being served\n", currentId);
                    if (customerLine.size() < numOfTellers)
                        System.out.println("Teller is waiting");
                }
            }
            if(customerLine.isEmpty())
                System.out.println("Teller is waiting...");
            System.out.println("Line empty, all customers served");
        }



    }
}


