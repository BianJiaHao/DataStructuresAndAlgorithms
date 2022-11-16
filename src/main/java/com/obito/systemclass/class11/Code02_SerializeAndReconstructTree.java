package com.obito.systemclass.class11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author admin
 * 序列化反序列化二叉树
 */
public class Code02_SerializeAndReconstructTree {

    static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static Queue<String> preSerial(Node head) {
        Queue<String> queue = new LinkedList<>();
        pres(head,queue);
        return queue;

    }

    public static void pres(Node head, Queue<String> queue) {
        if (head == null) {
            queue.add(null);
        }
        queue.add(String.valueOf(head.value));
        pres(head.left,queue);
        pres(head.right,queue);
    }

    public static Node reconstructPre(Queue<String> queue) {
        if (queue.isEmpty()) {
            return null;
        }
        return buildPre(queue);
    }

    public static Node buildPre(Queue<String> queue) {
        String head = queue.poll();
        if (head == null) {
            return null;
        }
        Node node = new Node(Integer.parseInt(head));
        node.left = buildPre(queue);
        node.right = buildPre(queue);
        return node;
    }

    public static Queue<String> posSerial(Node head) {
        if (head == null) {
            return null;
        }
        Queue<String> ans = new LinkedList<>();
        poss(head,ans);
        return ans;
    }

    private static void poss(Node head, Queue<String> ans) {
        if (head == null) {
            ans.add(null);
        }
        poss(head.left,ans);
        poss(head.right,ans);
        ans.add(String.valueOf(head.value));
    }

    public static Node reconstructPos(Queue<String> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        Stack<String> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        return buildPos(stack);
    }

    private static Node buildPos(Stack<String> stack) {
        String value = stack.pop();
        if (value == null) {
            return null;
        }
        Node node = new Node(Integer.parseInt(value));
        node.right = buildPos(stack);
        node.left = buildPos(stack);
        return node;
    }


    public static Queue<String> levelSerial(Node head) {
        if (head == null) {
            return null;
        }
        Queue<String> ans = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        ans.add(String.valueOf(head.value));
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                queue.add(head.left);
                ans.add(String.valueOf(head.left));
            }else {
                ans.add(null);
            }
            if (head.right != null) {
                queue.add(head.right);
                ans.add(String.valueOf(head.right));
            }else {
                ans.add(null);
            }
        }
        return ans;
    }

    public static Node buildByLevel(Queue<String> queue) {
        if (queue == null || queue.size() == 0) {
            return null;
        }
        Node head = generateNode(queue.poll());
        Queue<Node> list = new LinkedList<>();
        list.add(head);
        while (!list.isEmpty()) {
            Node node = list.poll();
            node.left = generateNode(queue.poll());
            node.right = generateNode(queue.poll());
            if (node.left != null) {
                list.add(node.left);
            }
            if (node.right != null) {
                list.add(node.right);
            }
        }


        return head;
    }

    public static Node generateNode(String val) {
        if (val == null) {
            return null;
        }
        return new Node(Integer.parseInt(val));
    }



}
