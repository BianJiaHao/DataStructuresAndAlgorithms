package com.obito.systemclass.class08;

/**
 * @author obito
 */
public class Code01_TrieUseArray {

    class Trie {

        class Node {
            private int pass;
            private int end;
            private Node[] next;

            public Node() {
                pass = 0;
                end = 0;
                next = new Node[26];
            }
        }

        private Node root;

        public Trie() {
            root = new Node();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chars = word.toCharArray();
            root.pass++;
            Node cur = root;
            int index = 0;
            for (char aChar : chars) {
                index = aChar - 'a';
                if (cur.next[index] == null) {
                    cur.next[index] = new Node();
                }
                cur = cur.next[index];
                cur.pass++;
            }
            cur.end++;
        }

        public int countEqualTo(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            Node cur = root;
            int index = 0;
            for (char aChar : chars) {
                index = aChar = 'a';
                if (root.next[index] == null) {
                    return 0;
                }
                cur = cur.next[index];
            }
            return cur.end;
        }

        public int countWordsStartsWith(String word) {
            if (word == null) {
                return 0;
            }
            char[] chars = word.toCharArray();
            Node cur = root;
            int index = 0;
            for (char aChar : chars) {
                index = aChar = 'a';
                if (cur.next[index] == null) {
                    return 0;
                }
                cur = cur.next[index];
            }
            return cur.pass;
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
                index = aChar - 'a';
                if (--cur.next[index].pass == 0) {
                    cur.next[index] = null;
                    return;
                }
                cur = cur.next[index];
            }
            cur.end--;
        }
    }


}
