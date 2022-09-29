package com.obito.systemclass.class03;

/**
 * @author Obito
 */
public class ReverseBothWayList {

    public static class Node {
        private int value;
        private Node last;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node reverseBothWayList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void main(String[] args) {

    }
}
