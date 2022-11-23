package com.obito.systemclass.class12;

/**
 * @author obito
 * 判断一棵树是否是平衡二叉树
 */
public class Code02_IsBalanceBinaryTree {

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
        private boolean isBalanceTree;
        private int height;

        public Info(boolean isBalanceTree, int height) {
            this.isBalanceTree = isBalanceTree;
            this.height = height;
        }
    }

    public static boolean way1(TreeNode head) {
        boolean[] ans = new boolean[1];
        ans[0] = true;
        process1(head,ans);
        return ans[0];
    }

    private static int process1(TreeNode head, boolean[] ans) {
        if (!ans[0] || head == null) {
            return - 1;
        }
        int leftHeight = process1(head.left,ans);
        int rightHeight = process1(head.right,ans);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            ans[0] = false;
        }

        return Math.max(leftHeight,rightHeight) + 1;

    }

    public static boolean way2(TreeNode head) {
       return process2(head).isBalanceTree;
    }

    public static Info process2(TreeNode head) {
        if (head == null) {
            return new Info(true,0);
        }
        Info leftInfo = process2(head.left);
        Info rightInfo = process2(head.right);
        int height;
        boolean isBalanceTree = false;

        height = Math.max(leftInfo.height,rightInfo.height) + 1;
        if (leftInfo.isBalanceTree && rightInfo.isBalanceTree && Math.abs(leftInfo.height - rightInfo.height) <= 1) {
            isBalanceTree = true;
        }

        return new Info(isBalanceTree,height);
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
        int maxLevel = 10;
        int maxValue = 100;
        int times = 1_0000;
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
