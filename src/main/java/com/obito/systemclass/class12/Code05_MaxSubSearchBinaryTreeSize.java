package com.obito.systemclass.class12;

import java.util.ArrayList;
import java.util.List;

/**
 * @author obito
 * 最大子搜索二叉树的个数
 */
public class Code05_MaxSubSearchBinaryTreeSize {

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
        private int allSize;
        private int maxSubSearchBinaryTreeSize;
        private int min;
        private int max;

        public Info(int allSize, int maxSubSearchBinaryTreeSize, int min, int max) {
            this.allSize = allSize;
            this.maxSubSearchBinaryTreeSize = maxSubSearchBinaryTreeSize;
            this.min = min;
            this.max = max;
        }
    }

    public static int way1(TreeNode head) {
        if (head == null) {
            return 0;
        }
        int size = getSearchBinaryTreeSize(head);
        if (size != 0) {
            return size;
        }
        return Math.max(way1(head.left),way1(head.right));
    }

    private static int getSearchBinaryTreeSize(TreeNode head) {
        if (head == null) {
            return 0;
        }
        List<TreeNode> ans = new ArrayList<>();
        in(head,ans);
        for (int i = 1; i < ans.size(); i++) {
            if (ans.get(i).value <= ans.get(i - 1).value) {
                return 0;
            }
        }
        return ans.size();
    }

    private static void in(TreeNode head, List<TreeNode> ans) {
        if (head == null) {
            return;
        }
        in(head.left,ans);
        ans.add(head);
        in(head.right,ans);
    }

    public static int way2(TreeNode head) {
        if (head == null) {
            return 0;
        }
        return process2(head).maxSubSearchBinaryTreeSize;
    }

    public static Info process2(TreeNode head) {
        if (head == null) {
            return null;
        }
        Info leftInfo = process2(head.left);
        Info rightInfo = process2(head.right);

        int min = head.value;
        int max = head.value;
        int allSize = 1;

        if (leftInfo != null) {
            min = Math.min(min,leftInfo.min);
            max = Math.max(max,leftInfo.max);
            allSize += leftInfo.allSize;
        }

        if (rightInfo != null) {
            min = Math.min(min,rightInfo.min);
            max = Math.max(max,rightInfo.max);
            allSize += rightInfo.allSize;
        }

        int p1 = -1;
        if (leftInfo != null) {
            p1 = leftInfo.maxSubSearchBinaryTreeSize;
        }

        int p2 = -1;
        if (rightInfo != null) {
            p2 = rightInfo.maxSubSearchBinaryTreeSize;
        }

        int p3 = -1;
        boolean leftIsSearchTree = leftInfo == null || (leftInfo.maxSubSearchBinaryTreeSize == leftInfo.allSize);
        boolean rightIsSearchTree = rightInfo == null || (rightInfo.maxSubSearchBinaryTreeSize == rightInfo.allSize);
        if (leftIsSearchTree && rightIsSearchTree) {
            boolean isLeftMaxSmall = leftInfo == null || (leftInfo.max < head.value);
            boolean isRightMinBigger = rightInfo == null || (rightInfo.min > head.value);
            if (isLeftMaxSmall && isRightMinBigger) {
                int leftSize = leftInfo == null ? 0 : leftInfo.allSize;
                int rightSize = rightInfo == null ? 0 : rightInfo.allSize;
                p3 = leftSize + rightSize + 1;
            }
        }
        return new Info(allSize,Math.max(p1,Math.max(p2,p3)),min,max);
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
            int process1 = way1(head);
            int process2 = way2(head);
            if (process1 != process2) {
                System.out.println("Oops");
                break;
            }
        }
        System.out.println("finish");
    }
}
