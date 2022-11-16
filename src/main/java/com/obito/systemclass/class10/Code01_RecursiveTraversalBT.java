package com.obito.systemclass.class10;

/**
 * @author admin
 * 递归序遍历二叉树
 */
public class Code01_RecursiveTraversalBT {

    public static class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void firstSequence(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.value);
        firstSequence(head.left);
        firstSequence(head.right);
    }

    public static void middleSequence(Node head) {
        if (head == null) {
            return;
        }
        middleSequence(head.left);
        System.out.println(head.value);
        middleSequence(head.right);
    }

    public static void lastSequence(Node head) {
        if (head == null) {
            return;
        }
        lastSequence(head.left);
        lastSequence(head.right);
        System.out.println(head.value);
    }

}
