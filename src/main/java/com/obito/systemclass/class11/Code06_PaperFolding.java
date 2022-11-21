package com.obito.systemclass.class11;

/**
 * @author obito
 * 折纸问题
 */
public class Code06_PaperFolding {

    public static void paperFolding(int n) {
        process(1,n,true);
    }

    private static void process(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        process(i + 1,n,true);
        System.out.println(down ? "凹" : "凸");
        process(i + 1,n,false);
    }

    public static void main(String[] args) {
        int N = 2;
        paperFolding(N);
    }
}
