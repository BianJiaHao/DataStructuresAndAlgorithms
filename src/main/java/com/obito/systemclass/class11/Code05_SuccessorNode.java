package com.obito.systemclass.class11;

/**
 * @author obito
 * 给定一颗二叉树上的一个节点，找出他的后继节点
 */
public class Code05_SuccessorNode {

    class Node {
        private int value;
        private Node left;
        private Node right;
        private Node parent;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
            parent = null;
        }
    }

    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        Node cur = node;
        if (node.right == null) {
            Node parent = cur.parent;
            while (parent != null && parent.right == cur) {
                cur = cur.parent;
                parent = cur.parent;
            }
        }else {
            cur = node.right;
            while (cur.left != null) {
                cur = cur.left;
            }
        }

        return cur;
    }
}
