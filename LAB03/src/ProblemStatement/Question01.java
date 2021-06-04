/*
@created 22/03/2021 - 1:50 PM
@project LAB03
@author Trang Nguyen
*/
package ProblemStatement;
import java.util.Stack;

public class Question01 {

    public static String decToOct(int dec) {
        Stack<Integer> octForm = new Stack<>();
        String s = new String();

        if (dec == 0)
            octForm.push(0);

        while (dec > 0) {
            octForm.push(dec % 8);
            dec /= 8;
        }

        while (octForm.isEmpty() != true) {
            s += octForm.peek().toString();
            octForm.pop();
        }

        return s;
    }

    public static <T> Stack<T> concatenate(Stack<T> stack1, Stack<T> stack2) {
        Stack<T> st1 = (Stack<T>) stack1.clone();
        Stack<T> st2 = (Stack<T>) stack2.clone();
        Stack<T> stTemp = new Stack<T>();

        while (!st2.isEmpty()) {
            stTemp.push(st2.peek());
            st2.pop();
        }
        while (!stTemp.isEmpty()) {
            st1.push(stTemp.peek());
            stTemp.pop();
        }
        return st1;
    }

    public static <T> String checkStackIdentical(Stack<T> stack1, Stack<T> stack2) {
        if (stack1.size() != stack2.size())
            return "Different!";

        while (!stack1.isEmpty()) {
            if (!stack1.peek().equals(stack2.peek()))
                return "Different!";
            stack1.pop();
            stack2.pop();
        }
        return "Identical!";
    }

    public static void main(String[] args) {
        System.out.println("Octal value = " + decToOct(10));

        // CONCATENATE 2 STACKS //
        Stack<Integer> st1 = new Stack<Integer>();
        Stack<Integer> st2 = new Stack<Integer>();

        st1.push(1);
        st1.push(2);
        st1.push(3);

        st2.push(7);
        st2.push(8);
        st2.push(9);

        Stack<Integer> st;
        st = concatenate(st1, st2);
        while (!st.isEmpty()) {
            System.out.print(st.peek() + " ");
            st.pop();
        }
        System.out.println();

        // CHECK IDENTICAL BETWEEN 2 STACKS //
        st1.clear();
        st2.clear();

        st1.push(1);
        st1.push(2);
        st1.push(3);
        st1.push(4);
        st1.push(5);

        st2.push(1);
        st2.push(2);
        st2.push(3);
        st2.push(4);
        st2.push(5);

        System.out.println(checkStackIdentical(st1, st2));
    }
}
