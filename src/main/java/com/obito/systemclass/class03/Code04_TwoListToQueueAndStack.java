package com.obito.systemclass.class03;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author obito
 */
public class Code04_TwoListToQueueAndStack {

    public static class Node{
        public int value;
        public Node last;
        public Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public static class MyQueue{
        private final int limit;
        private int size;
        private Node head;
        private Node tail;

        public MyQueue(int limit) {
            this.limit = limit;
            size = 0;
            head = null;
            tail = null;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("队列满了");
            }
            Node node = new Node(value);
            Node pre;
            if (head == null) {
                head = node;
                tail = node;
            }else {
                pre = tail;
                tail = node;
                pre.next = tail;
                tail.last = pre;
            }
            size++;
        }

        public int pull() {
            if (size == 0) {
                throw new RuntimeException("队列为空");
            }
            int ans = head.value;
            head = head.next;
            if (head != null) {
                head.last = null;
            }
            size--;
            return ans;
        }

        public int peek() {
            if (size == 0) {
                throw new RuntimeException("队列为空");
            }
            return head.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static class MyStack{
        private final int limit;
        private int size;
        private Node head;

        public MyStack(int limit) {
            this.limit = limit;
            size = 0;
            head = null;
        }

        public void push(int value) {
            if (size == limit) {
                throw new RuntimeException("栈满了");
            }
            Node node = new Node(value);
            Node pre;
            if (head == null) {
                head = node;
            }else {
                pre = head;
                head = node;
                pre.next = node;
                head.last = pre;
            }
            size++;
        }

        public int poll() {
            if (size == 0) {
                throw new RuntimeException("栈为空");
            }
            int ans = head.value;
            head = head.last;
            if (head != null) {
                head.next = null;
            }
            size--;
            return ans;
        }

        public int peek() {
            if (size == 0) {
                throw new RuntimeException("栈为空");
            }
            return head.value;
        }

        public boolean isEmpty() {
            return size == 0;
        }
    }

    public static int generateRandom(int limit) {
        return (int) (Math.random() * limit + 1);
    }

    public static void main(String[] args) {
        System.out.println("测试开始");
        int limit = 100000;

        MyQueue myQueue = new MyQueue(limit);
        Queue<Integer> queue = new ArrayDeque<>();

        MyStack myStack = new MyStack(limit);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < limit; i++) {
           int num = generateRandom(100);
           queue.add(num);
           myQueue.push(num);

           myStack.push(num);
           stack.push(num);
        }

        while (!myQueue.isEmpty() && !queue.isEmpty()) {
            int value1 = myQueue.pull();
            int value2 = queue.poll();

            int value3 = myStack.poll();
            int value4 = stack.pop();

            if (value1 != value2) {
                throw new RuntimeException("出错了");
            }

            if (value3 != value4) {
                throw new RuntimeException("出错了");
            }

        }

        System.out.println("测试结束");



    }
}
