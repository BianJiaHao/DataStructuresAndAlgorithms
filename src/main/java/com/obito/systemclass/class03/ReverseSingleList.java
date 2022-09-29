package com.obito.systemclass.class03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author obito
 */
public class ReverseSingleList {

    public static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

    }

    public static Node reverseSingleList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node pre = null;
        Node next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static Node testReverseSingleList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        List<Node> help = new ArrayList<>();
        while (head != null) {
            help.add(head);
            head = head.next;
        }
        help.get(0).next = null;
        for (int i = help.size() - 1; i > 0; i--) {
            help.get(i).next = help.get(i - 1);
        }
        return help.get(help.size() - 1);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        Node newNode = testReverseSingleList(node1);

        while (newNode != null) {
            System.out.println(newNode.value);
            newNode = newNode.next;
        }
    }
}
