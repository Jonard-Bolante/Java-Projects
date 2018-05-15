/**
 * Created by Jonard Bolante on 10/20/2016.
 */
import java.util.*;
public class TicketCounter {
    private final static int PROCESS = 120;
    private final static int MAX_CASHIERS = 10;
    private final static int NUM_CUSTOMERS = 100;

    public static void main(String[] args) {
        TicketBuyer customer;
        Queue<TicketBuyer> customerQueue = new LinkedList<TicketBuyer>();
        int[] cashierTime = new int[MAX_CASHIERS];
        int totalTime, averageTime, departs, start;

        for(int cashiers = 0; cashiers < MAX_CASHIERS; cashiers++){
            for(int count=0; count<cashiers; count++)
                cashierTime[count] = 0;

            for(int count = 1; count <= NUM_CUSTOMERS; count++){
                customerQueue.add(new TicketBuyer(count * 15));
            }



            totalTime = 0;



            while(!customerQueue.isEmpty()){
                for(int count = 0; count <= cashiers; count++){
                    if(!customerQueue.isEmpty()){
                        customer = customerQueue.remove();
                        if(customer.getArrivalTime() > cashierTime[count])
                            start = customer.getArrivalTime();
                        else
                            start = cashierTime[count];
                        departs = start + PROCESS;
                        customer.setDepartureTime(departs);
                        cashierTime[count] = departs;
                        totalTime += customer.totalTime();
                    }
                }
            }






            averageTime = totalTime/NUM_CUSTOMERS;
            System.out.println("Number of cashiers: " + (cashiers + 1));
            System.out.println("Average time: " + averageTime + "\n");
        }



    }
}
