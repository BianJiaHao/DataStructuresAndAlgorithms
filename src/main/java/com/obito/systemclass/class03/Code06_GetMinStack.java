package com.obito.systemclass.class03;

import java.util.Stack;

/**
 * @author obito
 */
public class Code06_GetMinStack {

    public static class MinStack{

        private Stack<Integer> dataStack;
        private Stack<Integer> helpStack;

        public MinStack() {
            dataStack = new Stack<>();
            helpStack = new Stack<>();
        }

        public void push(Integer value) {
            if (dataStack.isEmpty()) {
                dataStack.push(value);
                helpStack.push(value);
            }else {
                dataStack.push(value);
                Integer currentMin = helpStack.peek();
                helpStack.push(value < currentMin ? value : currentMin);
            }

        }

        public Integer poll() {
            Integer ans = dataStack.pop();
            helpStack.pop();
            return ans;
        }

        public Integer peek() {
            return dataStack.peek();
        }

        public boolean isEmpty() {
            return dataStack.isEmpty();
        }

        public Integer getMin() {
            return helpStack.peek();
        }

    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(7);
        minStack.push(78);
        minStack.push(2);

        minStack.poll();
        minStack.push(3);

        System.out.println(minStack.getMin());
    }
}
