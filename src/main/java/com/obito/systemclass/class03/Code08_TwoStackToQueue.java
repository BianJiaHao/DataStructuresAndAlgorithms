package com.obito.systemclass.class03;

import java.util.Stack;

/**
 * @author obito
 */
public class Code08_TwoStackToQueue {

    public static class MyQueueByStack {
        private Stack<Integer> queue;
        private Stack<Integer> help;

        public MyQueueByStack() {
            queue = new Stack<>();
            help = new Stack<>();
        }

        public void push(Integer value) {
            queue.push(value);
            enableImportData();
        }

        public Integer pop() {
            enableImportData();
            return help.pop();
        }

        public Integer peek() {
            enableImportData();
            return help.peek();
        }

        public boolean isEmpty() {
            return queue.isEmpty() && help.isEmpty();
        }

        public void enableImportData() {
            if (help.isEmpty()) {
                while (!queue.isEmpty()) {
                    help.push(queue.pop());
                }
            }
        }
    }

    public static void main(String[] args) {
        MyQueueByStack myQueueByStack = new MyQueueByStack();

        for (int i = 0; i < 5; i++) {
            myQueueByStack.push(i);
        }

        System.out.println(myQueueByStack.pop());
        System.out.println(myQueueByStack.pop());

        for (int i = 5; i < 10; i++) {
            myQueueByStack.push(i);
        }

        while (!myQueueByStack.isEmpty()) {
            System.out.println(myQueueByStack.pop());
        }
    }
}
