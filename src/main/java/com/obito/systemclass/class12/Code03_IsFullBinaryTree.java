package com.obito.systemclass.class12;


/**
 * @author obito
 * 判断一棵树是否是满二叉树
 */
public class Code03_IsFullBinaryTree {

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

    public static class Info1 {
        private int height;
        private int nodes;

        public Info1(int height, int nodes) {
            this.height = height;
            this.nodes = nodes;
        }
    }

    public static class Info2 {
        private boolean isFullTree;
        private int height;

        public Info2(boolean isFullTree, int height) {
            this.isFullTree = isFullTree;
            this.height = height;
        }
    }

    public static boolean way1(TreeNode head) {
        Info1 info = process1(head);
        return (1 << info.height) - 1 == info.nodes;
    }

    private static Info1 process1(TreeNode head) {
        if (head == null) {
            return new Info1(0,0);
        }
        Info1 leftInfo = process1(head.left);
        Info1 rightInfo = process1(head.right);
        int height;
        int nodes;
        height = Math.max(leftInfo.height,rightInfo.height) + 1;
        nodes = leftInfo.nodes + rightInfo.nodes + 1;
        return new Info1(height,nodes);
    }

    public static boolean way2(TreeNode head) {
        return process2(head).isFullTree;
    }

    public static Info2 process2(TreeNode head) {
        if (head == null) {
            return new Info2(true,0);
        }
        Info2 leftInfo = process2(head.left);
        Info2 rightInfo = process2(head.right);

        boolean isFullTree = false;
        int height;

        height = Math.max(leftInfo.height,rightInfo.height) + 1;
        if (leftInfo.isFullTree && rightInfo.isFullTree && leftInfo.height == rightInfo.height) {
            isFullTree = true;
        }

        return new Info2(isFullTree,height);
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
