package Q0012_Min_Stack;

import java.util.Stack;

class MinStack {
    
    int min = Integer.MAX_VALUE;
    Stack<Integer> stack = new Stack<>();
    
    public MinStack() {
        // do intialization if necessary
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if (number <= min) {
            stack.push(min);
            min = number;
        } 
        stack.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        int top = stack.pop();
        if (top == min) {
            min = stack.pop();
        }
        return top;
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min;
    }
}