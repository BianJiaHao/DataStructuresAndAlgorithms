package com.obito.systemclass.class03;

/**
 * @author obito
 */
public class Code05_ArrayToQueueAndStack {

    public static class MyQueue{
        private final int limit;
        private int size;
        private int[] queue;
        private int putIndex;
        private int pullIndex;

        public MyQueue(int limit) {
            this.limit = limit;
            size = 0;
            queue = new int[limit];
            putIndex = 0;
            pullIndex = 0;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了");
            }
            queue[putIndex] = value;
            size++;
            putIndex = nextIndex(putIndex);
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("队列为空");
            }
            int ans = queue[pullIndex];
            size--;
            pullIndex = nextIndex(pullIndex);
            return ans;
        }

        public int peek() {
            if (size == 0) {
                throw new RuntimeException("队列为空");
            }
            return queue[pullIndex];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public int nextIndex(int index) {
            return index == limit - 1 ? 0 : index + 1;
        }
    }

    public static class MyStack{
        private int[] stack;
        private int putIndex;
        private final int limit;
        private int size;

        public MyStack(int limit) {
            stack = new int[limit];
            putIndex = 0;
            this.limit = limit;
            size = 0;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("栈满了");
            }
            stack[putIndex] = value;
            size++;
            putIndex++;
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("栈为空");
            }
            int ans = stack[--putIndex];
            size--;
            return ans;
        }

        public int peek() {
            if (size == 0) {
                throw new RuntimeException("栈为空");
            }
            return stack[putIndex - 1];
        }

        public boolean isEmpty() {
            return size == 0;
        }

    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue(5);
        MyStack myStack = new MyStack(5);
        for (int i = 0; i < 5; i++) {
            myQueue.push(i);
        }

        System.out.println(myQueue.poll());
        System.out.println(myQueue.poll());

        myQueue.push(50);
        myQueue.push(51);

        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.poll());
        }

        System.out.println("----------------------");

        for (int i = 0; i < 5; i++) {
            myStack.push(i);
        }

        System.out.println(myStack.poll());
        System.out.println(myStack.poll());

        myStack.push(50);
        myStack.push(51);

        while (!myStack.isEmpty()) {
            System.out.println(myStack.poll());
        }

    }
}
