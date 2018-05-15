import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class RunnerClass {
    public static void main(String[] args) throws IOException{

        File it = new File ("inventory.txt");
        BST<String, String>  bt = new BST<String, String>();
        BSTNode<String,String> node = new BSTNode<String,String>();
        Scanner input = null;
        String MyNewString = new String();
        String temp = new String();

        if(it.exists()) {
            FileReader fr = new FileReader(it);
            BufferedReader br = new BufferedReader(fr);
            String s;
            bt.clear();
            System.out.println("List the input records");
/*
________________________________________________________________
________________________________________________________________
________________________________________________________________
 */
            while ((s = br.readLine()) != null)
            {
                bt.insert(s, s);
            }
/*
________________________________________________________________
________________________________________________________________
________________________________________________________________
*/
            br.close();
            System.out.println("Inorder of the tree is in Sorted Order");
            System.out.println(bt.toString(0));
        }
        else
            System.out.println("File named inventory.txt does not exist");
/*
________________________________________________________________
________________________________________________________________
________________________________________________________________
 */
        boolean lp = true;
        while (lp)
        {
            System.out.println("enter A to Add or D to delete or r to record");
            input = new Scanner(System.in);
            MyNewString = input.nextLine();
            if(MyNewString.length() > 0) {
                if (MyNewString.toUpperCase().equals("R"))
                {
                    System.out.println("Enter value to find the record ");
                    input = new Scanner(System.in);
                    MyNewString = input.nextLine();
                    temp = bt.find(MyNewString);
                    if (temp != null)
                        System.out.println("Find " + temp);
                    else
                        System.out.println(MyNewString + " Not Found");
                } else if (MyNewString.toUpperCase().equals("D")) {
                    System.out.println("Enter value to delete");
                    input = new Scanner(System.in);
                    MyNewString = input.nextLine();
                    temp = bt.remove(MyNewString);
                    if (temp != null)
                    {
                        System.out.println(temp + " deleted");
                        bt.remove(MyNewString);
                    }
                    else
                        System.out.println(MyNewString + " not on the list");
                }
                else if (MyNewString.toUpperCase().equals("A"))
                {
                    System.out.println("Enter value to add");
                    input = new Scanner(System.in);
                    MyNewString = input.nextLine();

                    temp = bt.find(MyNewString);
                    if (temp == null)
                    {
                        System.out.println(MyNewString + " added ");
                        bt.insert(MyNewString, MyNewString);
                    }
                    else
                        System.out.println(MyNewString + " is on the list");
                }
                else
                    System.out.println("Invalid option !! Try again");
            }
            else
                lp = false;
        }









// PART 2
        System.out.println();
        System.out.println("inorder of the tree is " + bt.toString(0));
        System.out.println("postorder of the tree is " + bt.toString(1));
        System.out.println("preorder of the tree is " + bt.toString(2));
        System.out.println("BPTree size is: " + bt.size());







//PART 2
        System.out.println("enter low value for the range ");
        input = new Scanner(System.in);
        MyNewString = input.nextLine();

        BSTNode<String,String> low = new BSTNode<String, String>(MyNewString, MyNewString);
        System.out.println("Enter high value for the range ");
        input = new Scanner(System.in);
        MyNewString = input.nextLine();
        BSTNode<String, String> high = new BSTNode<String, String>(MyNewString, MyNewString);
        node = bt.getRoot();
        System.out.println("From: " + low.element()+"    to: "+MyNewString+" are ");

        bt.printRange(node,high.key(), low.key());






//PART 3
        System.out.println("inorder of the tree is " + bt.toString(0));
        System.out.println("Stack printed of the tree is " + bt.toStackString());
    }
}
