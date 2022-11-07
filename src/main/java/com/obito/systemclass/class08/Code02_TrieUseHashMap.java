package com.obito.systemclass.class08;

import java.util.HashMap;

/**
 * @author obito
 */
public class Code02_TrieUseHashMap {

    class Trie {

        class Node {
            private int pass;
            private int end;
            private HashMap<Integer,Node> next;

            public Node() {
                pass = 0;
                end = 0;
                next = new HashMap<>();
            }
        }

        Node root;

        public Trie(Node root) {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            root.pass++;
            Node cur = root;
            int index = 0;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                index = aChar;
                if (!cur.next.containsKey(index)) {
                    cur.next.put(index,new Node());
                }
                cur = cur.next.get(index);
                cur.pass++;
            }
            cur.end++;
        }

        public void delete(String word) {
            if (countEqualTo(word) == 0) {
                return;
            }
            root.pass--;
            Node cur = root;
            int index = 0;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                index = aChar;
                if (--cur.next.get(index).pass == 0) {
                    cur.next.put(index,null);
                    return;
                }
                cur = cur.next.get(index);
            }
            cur.end--;
        }

        public int countEqualTo(String word) {
            if (word == null) {
                return 0;
            }
            Node cur = root;
            int index = 0;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                index = aChar;
                if (cur.next.get(index) == null) {
                    return 0;
                }
                cur = cur.next.get(index);
            }
            return cur.end;
        }

        public int countWordStart(String word) {
            if (word == null) {
                return 0;
            }
            Node cur = root;
            int index = 0;
            char[] chars = word.toCharArray();
            for (char aChar : chars) {
                index = aChar;
                if (cur.next.get(index) == null) {
                    return 0;
                }
                cur = cur.next.get(index);
            }
            return cur.pass;
        }
    }
}
