package com.obito.systemclass.class02;

/**
 * @author obito
 */
public class Code01_FindFirstRightOne {

    public static int findFirstRightOne(int n) {
        if (n == 0) {
            return 0;
        }
        return n & (~n + 1);
    }

    public static void main(String[] args) {
        System.out.println(findFirstRightOne(6));
    }

}
