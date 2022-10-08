package com.obito.systemclass.class03;

/**
 * @author obito
 */
public class Code03_DeletesSpecifiedElement {

    public static class Node {

        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public static Node deleteSpecifiedElement(Node head,int num) {

        if (head == null) {
            return null;
        }

        while (head != null) {
            if (head.value != num) {
                break;
            }
            head = head.next;
        }

        Node cur = head;
        Node pre = head;
        while (cur != null) {
            if (cur.value == num) {
                pre.next = cur.next;
            }else {
                pre = cur;
            }
            cur = cur.next;
        }

        return head;
    }
}
