package com.obito.systemclass.class11;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author obito
 * 求一棵树的最大宽度
 */
public class Code04_TreeMaxWidth {

    class Node {
        private int value;
        private Node left;
        private Node right;

        public Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static int getTreeMaxWidth(Node head) {
        if (head == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        Node curEnd = head;
        Node lastEnd = null;
        int ans = 0;
        int cur = 0;
        queue.add(head);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            cur++;
            if (node.left != null) {
                queue.add(node.left);
                lastEnd = node.left;
            }
            if (node.right != null) {
                queue.add(node.right);
                lastEnd = node.right;
            }
            if (node == curEnd) {
                ans = Math.max(ans,cur);
                cur = 0;
                curEnd = lastEnd;
            }
        }

        return ans;

    }
}
