/**
 * Created by Jonard Bolante on 10/17/2016.
 */
import java.io.*;
import java.util.*;
public class StacksMain {





    public static void main(String[] args) throws IOException {
        FileReader infile = new FileReader("C:\\Users\\Jonard Bolante\\IdeaProjects\\NJIT Assignments\\src\\infix.dat");
        BufferedReader fileReader = new BufferedReader(infile);
        String line;
        fileReader.mark(100);       // This creates a mark if I ever needed to return to first line of my file.
        line = fileReader.readLine();
//  PART 1
        while (line != null){
            System.out.println(line);
            try {
                String postfix = toPostfix(line);
                System.out.println("postfix = " + postfix);
                System.out.println(computePostfix(postfix));

            } catch (Exception e) {
                System.out.println("Invalid expression");
            }
            line = fileReader.readLine();
            System.out.println();
            System.out.println();
            System.out.println();
        }
        System.out.println("______________________________________");
        System.out.println("______________________________________");
        System.out.println("______________________________________");
        System.out.println("______________________________________\n\n\n");
//  PART 2
        FileReader secondFile = new FileReader("C:\\Users\\Jonard Bolante\\IdeaProjects\\NJIT Assignments\\src\\postfix.dat");
        BufferedReader secondReader = new BufferedReader(secondFile);
        line = secondReader.readLine();
        while (line != null){
            System.out.println(line);
            try {
                System.out.print("postfix = ");
                System.out.println(computePostfix(line));

            } catch (Exception e) {
                System.out.println("Invalid expression");
            }
            line = secondReader.readLine();
            System.out.println();
            System.out.println();
            System.out.println();
        }
    }




// CONVERT ALL INFIX EXPRESSIONS TO POST FIX AND CALCULATE
    public static String toPostfix(String infix) {

        try {
            String postfix = "";
            boolean unary = true;
            Stacke<String> stack = new Stacke<String>();
            StringTokenizer st = new StringTokenizer(infix, "()+-/%* ", true);
            while (st.hasMoreTokens()) {
                String token = st.nextToken().trim();
                if (token.equals("")) {         // THIS SKIPS ANY EMPTY 'TOKEN' OR SPACE
                } else if (token.equals("(")) {
                    stack.push(token);
                } else if (token.equals(")")) {
                    String op;
                    while (!(op = stack.pop()).equals("("))
                        postfix += " " + op;
                } else if (token.equals("*")
                        || token.equals("+") || token.equals("-")
                        || token.equals("%") || token.equals("/")) {
                    if (unary) {
                        token = "u" + token;
                        stack.push(token);
                    } else {
                        int p = operatorPrecedence(token);
                        while (!stack.isEmpty() && !stack.top().equals("(")
                                && operatorPrecedence(stack.top()) >= p) {
                            String op = stack.pop();
                            postfix += " " + op;
                        }
                        stack.push(token);
                    }
                    unary = true;
                } else {
                    Integer.parseInt(token);
                    postfix += " " + token;
                    unary = false;
                }
            }
            while (!stack.isEmpty()) {
                String op = stack.pop();
                postfix += " " + op;
            }
            return postfix;
        } catch (EmptyStackException ese) {throw new ExpressionFormatException();}
          catch (NumberFormatException nfe) {throw new ExpressionFormatException();}
    }








    public static int computePostfix(String postfix) {
        try {
            Stack<Integer> stack = new Stack<Integer>();
            StringTokenizer st = new StringTokenizer(postfix);
            while (st.hasMoreTokens()) {
                String token = st.nextToken();
                if (token.equals("*")
                        ||
                        token.equals("+") || token.equals("-")
                        || token.equals("%") || token.equals("/")
                        || token.equals("u+") || token.equals("u-")) {
                    applyOperator(token, stack);
                } else
                    stack.push(new Integer(token));
            }
            int result = ((Integer) stack.pop()).intValue();
         // BY NOW, THE STACK SHOULD BE EMPTY. IF NOT, THROW EXCEPTION
            if (!stack.isEmpty())
                throw new ExpressionFormatException();
            return result;
        } catch (EmptyStackException ese) {throw new ExpressionFormatException();}
          catch (NumberFormatException nfe) {throw new ExpressionFormatException();}
    }








    private static void applyOperator(String operator, Stack<Integer> s) {
        int op1 = s.pop();
        if (operator.equals("u-"))
            s.push(-op1);
        else if (operator.equals("u+"))
            s.push(op1);
        else {
            int op2 = s.pop();
            int result;
            if (operator.equals("+"))
                result = op2 + op1;
            else if (operator.equals("-"))
                result = op2 - op1;
            else if (operator.equals("/"))
                result = op2 / op1;
            else if (operator.equals("%"))
                result = op2 % op1;
            else if (operator.equals("*"))
                result = op2 * op1;
            else
                throw new IllegalArgumentException();
            s.push(result);
        }
    }








    private static int operatorPrecedence(String operator) {
        if (operator.equals("u-") || operator.equals("u+")) {
            return 2;
        } else if (operator.equals("*") || operator.equals("/")
                || operator.equals("%")) {
            return 1;
        } else if (operator.equals("-") || operator.equals("+")) {
            return 0;
        } else {
            throw new ExpressionFormatException();
        }
    }



}