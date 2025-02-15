import java.util.Scanner;
import java.util.Stack;

public class postfix {
    
    // Method to check if a character is an operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }
    
    // Method to define operator precedence
    private static int precedence(char ch) {
        switch (ch) {
            case '+': case '-': return 1;
            case '*': case '/': return 2;
            default: return -1;
        }
    }
    
    // Method to convert infix expression to postfix
    public static String infixToPostfix(String infix) {
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        System.out.println("Step by step derivation:");

        for (char ch : infix.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) { // Operand goes directly to postfix
                postfix.append(ch);
            } else if (ch == '(') {
                stack.push(ch);
            } else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop(); // Remove '('
            } else if (isOperator(ch)) {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
            // Display stack and postfix state at each step
            System.out.println("Stack: " + stack + " | Postfix: " + postfix);
        }
        
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
            System.out.println("Stack: " + stack + " | Postfix: " + postfix);
        }
        
        return postfix.toString();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice;
        
        do {
            System.out.print("Enter an infix expression: ");
            String infix = scanner.nextLine();
            
            String postfix = infixToPostfix(infix);
            System.out.println("Final Postfix Expression: " + postfix);
            
            System.out.print("Do you want to try again? (yes/no): ");
            choice = scanner.nextLine().toLowerCase();
        } while (choice.equals("yes"));
        
        scanner.close();
    }
}
