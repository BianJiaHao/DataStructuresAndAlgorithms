package com.obito.systemclass.class12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author obito
 * 判断一棵树是否是搜索二叉树
 */
public class Code04_IsSearchBinaryTree {

    public static class TreeNode {
        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static class Info {
        private boolean isSearchBinaryTree;
        private int max;
        private int min;

        public Info(boolean isSearchBinaryTree, int max, int min) {
            this.isSearchBinaryTree = isSearchBinaryTree;
            this.max = max;
            this.min = min;
        }
    }

    public static boolean way1(TreeNode head) {
        List<TreeNode> list = new ArrayList<>();
        in(head,list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).value <= list.get(i - 1).value) {
                return false;
            }
        }
        return true;
    }

    private static void in(TreeNode head, List<TreeNode> list) {
        if (head == null) {
            return;
        }
        in(head.left,list);
        list.add(head);
        in(head.right,list);
    }

    public static boolean way2(TreeNode head) {
        if (head == null) {
            return true;
        }
        return process(head).isSearchBinaryTree;
    }

    public static Info process(TreeNode head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);

        int min = head.value;
        int max = head.value;

        if (leftInfo != null) {
            min = Math.min(min,leftInfo.min);
            max = Math.max(max,leftInfo.max);
        }

        if (rightInfo != null) {
            min = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
        }

        boolean isSearchBinaryTree = true;

        if (leftInfo != null && !leftInfo.isSearchBinaryTree) {
            isSearchBinaryTree = false;
        }

        if (rightInfo != null && !rightInfo.isSearchBinaryTree) {
            isSearchBinaryTree = false;
        }

        if (leftInfo != null && leftInfo.max >= head.value) {
            isSearchBinaryTree = false;
        }

        if (rightInfo != null && rightInfo.min <= head.value) {
            isSearchBinaryTree = false;
        }

        return new Info(isSearchBinaryTree,max,min);
    }

    public static TreeNode generateRandomBinaryTree(int maxLevel,int maxValue) {
        return generate(1,maxLevel,maxValue);
    }

    public static TreeNode generate(int level,int maxLevel,int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1,maxLevel,maxValue);
        head.right = generate(level + 1,maxLevel,maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 10;
        int maxValue = 100;
        int times = 10_0000;
        for (int i = 0; i < times; i++) {
            TreeNode head = generateRandomBinaryTree(maxLevel, maxValue);
            boolean process1 = way1(head);
            boolean process2 = way2(head);
            if (process1 != process2) {
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("finish");
    }


}
