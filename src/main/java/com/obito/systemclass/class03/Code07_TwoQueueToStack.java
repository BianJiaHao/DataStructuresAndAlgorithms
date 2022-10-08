package com.obito.systemclass.class03;

import java.util.LinkedList;

/**
 * @author obito
 */
public class Code07_TwoQueueToStack {

    public static class MyStackByQueue{
        private LinkedList<Integer> stack;
        private LinkedList<Integer> help;

        public MyStackByQueue() {
            stack = new LinkedList<>();
            help = new LinkedList<>();
        }

        public void push(int value) {
            stack.offer(value);
        }

        public int pop() {
            while (stack.size() > 1) {
                help.offer(stack.pop());
            }
            Integer ans = stack.pop();
            LinkedList<Integer> tmp;
            tmp = stack;
            stack = help;
            help = tmp;
            return ans;
        }

        public int peek() {
            while (stack.size() > 1) {
                help.offer(stack.pop());
            }
            Integer ans = stack.pop();
            help.offer(ans);
            LinkedList<Integer> tmp;
            tmp = stack;
            stack = help;
            help = tmp;
            return ans;
        }

        public boolean isEmpty() {
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStackByQueue myStackByQueue = new MyStackByQueue();
        for (int i = 0; i < 10; i++) {
            myStackByQueue.push(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(myStackByQueue.peek());
        }

        while (!myStackByQueue.isEmpty()) {
            System.out.println(myStackByQueue.pop());
        }
    }
}
