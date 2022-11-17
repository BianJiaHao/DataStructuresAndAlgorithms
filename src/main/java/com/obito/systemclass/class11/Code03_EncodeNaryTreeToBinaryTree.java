package com.obito.systemclass.class11;

import java.util.ArrayList;
import java.util.List;

/**
 * @author obito
 * 将一颗多叉树装换成一颗唯一的二叉树
 */
public class Code03_EncodeNaryTreeToBinaryTree {

    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode encode(Node root) {
        if (root == null) {
            return null;
        }
        TreeNode head = new TreeNode(root.val);
        head.left = en(root.children);
        return head;
    }

    private static TreeNode en(List<Node> children) {
        TreeNode cur = null;
        TreeNode head = null;
        for (Node child : children) {
            TreeNode treeNode = new TreeNode(child.val);
            if (head == null) {
                head = treeNode;
            }else {
                cur.right = treeNode;
            }
            cur = treeNode;
            cur.left = en(child.children);
        }
        return head;
    }

    public static Node decode(TreeNode head) {
        if (head == null) {
            return null;
        }
        return new Node(head.val, de(head.left));
    }

    private static List<Node> de(TreeNode root) {
        List<Node> child = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            Node node = new Node(cur.val, de(cur.left));
            child.add(node);
            cur = cur.right;
        }
        return child;
    }
}
