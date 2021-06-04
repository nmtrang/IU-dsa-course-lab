/*
@created 22/03/2021 - 5:32 PM
@project LAB03
@author Trang Nguyen
*/
package ProblemStatement;

import java.util.Stack;

public class Question02 {
    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray(); // convert every character in the input to a single element to be processed
        Stack<Integer> values = new Stack<Integer>(); // create a stack to store number elements
        Stack<Character> operands = new Stack<Character>(); // create a stack to store operand elements

        for (int i = 0; i < tokens.length; i++) { // process the expression with a for loop
            if (tokens[i] != ' ') { // check if an element is a whitespace
                if (tokens[i] >= '0' && tokens[i] <= '9') { // check if an element is a single number
                    StringBuffer s = new StringBuffer();

                    while (i < tokens.length && (tokens[i] >= '0' && tokens[i] <= '9')) {
                        s.append(tokens[i++]); // every single number of the input is appended into s
                    }

                    values.push(Integer.parseInt(s.toString())); // every single number of s is push into number stack
                } else if (tokens[i] == '(') // check if an element contains an open parenthesis
                    operands.push(tokens[i]); // push it to operands stack
                else if (tokens[i] == ')') { // check if an element contains a close parenthesis
                    while (operands.peek() != '(') // whenever the top layer of the stack contains an open parenthesis
                        values.push(applyOperators(operands.pop(), values.pop(), values.pop())); // push the new value that is calculated by applyOperators() to the values stack

                    operands.pop();
                } else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') { // if a token contains an operand
                    while (!operands.empty() && hasPrecedence(tokens[i], operands.peek())) // whenever operand stack is not empty and has no precedence
                        values.push(applyOperators(operands.pop(), values.pop(), values.pop()));
                    operands.push(tokens[i]);
                }
            }
        }
        while (!operands.empty())
            values.push(applyOperators(operands.pop(), values.pop(), values.pop()));
        return values.pop();
    }

    public static boolean hasPrecedence(char op1, char op2) {
        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;
    }

    public static int applyOperators(char op, int b, int a) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new ArithmeticException("Divide by zero!");
                return a / b;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(evaluate("30 + 10 / 2 + ( 2 - 5 * 3 )"));
    }
}