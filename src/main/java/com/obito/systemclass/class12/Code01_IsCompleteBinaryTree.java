package com.obito.systemclass.class12;


import java.util.LinkedList;
import java.util.Queue;

/**
 * @author obito
 * 判断一颗二叉树是否是完全二叉树
 */
public class Code01_IsCompleteBinaryTree {

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
        private boolean isBST;
        private boolean isFST;
        private int height;

        public Info(boolean isBST, boolean isFST, int height) {
            this.isBST = isBST;
            this.isFST = isFST;
            this.height = height;
        }
    }

    public static boolean way1(TreeNode head) {
        if (head == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        boolean noBothHaveLeftAndRight = false;
        boolean isCompleteTree = true;
        TreeNode left;
        TreeNode right;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            left = head.left;
            right = head.right;

            if ((noBothHaveLeftAndRight && (left != null || right != null)) || (left == null && right != null)) {
                return false;
            }

            if (left != null) {
                queue.add(left);
            }

            if (right != null) {
                queue.add(right);
            }

            if (left == null || right == null) {
                noBothHaveLeftAndRight = true;
            }
        }

        return isCompleteTree;
    }

    public static boolean way2(TreeNode head) {
        return process(head).isBST;
    }

    private static Info process(TreeNode head) {
        if (head == null) {
            return new Info(true,true,0);
        }
        Info leftInfo = process(head.left);
        Info rightInfo = process(head.right);
        boolean isBST = false;
        boolean isFST;
        int height;

        height = Math.max(leftInfo.height,rightInfo.height) + 1;
        isFST = leftInfo.isFST && rightInfo.isFST && leftInfo.height == rightInfo.height;
        if (isFST) {
            isBST = true;
        }
        if (leftInfo.isBST && rightInfo.isFST && rightInfo.height == leftInfo.height - 1) {
            isBST = true;
        }
        if (leftInfo.isFST && rightInfo.isFST && leftInfo.height == rightInfo.height + 1) {
            isBST = true;
        }
        if (leftInfo.isFST && rightInfo.isBST && leftInfo.height == rightInfo.height) {
            isBST = true;
        }
        return new Info(isBST,isFST,height);
    }

    public static TreeNode generateRandomBinaryTree(int maxLevel,int maxValue) {
        return generate(1,maxLevel,maxValue);
    }

    private static TreeNode generate(int level, int maxLevel, int maxValue) {
        if (level > maxLevel || Math.random() < 0.5) {
            return null;
        }
        TreeNode head = new TreeNode((int) (Math.random() * maxValue));
        head.left = generate(level + 1,maxLevel,maxValue);
        head.right = generate(level + 1,maxLevel,maxValue);
        return head;
    }

    public static void main(String[] args) {
        int maxLevel = 5;
        int maxValue = 100;
        int times = 1_0000;

        for (int i = 0; i < times; i++) {
            TreeNode head = generateRandomBinaryTree(maxLevel, maxValue);
            boolean process1 = way1(head);
            boolean process2 = way2(head);
            if (process1 != process2) {
                System.out.println("Oops");
            }
        }

        System.out.println("finish");
    }


}
