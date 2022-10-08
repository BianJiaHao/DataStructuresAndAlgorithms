package com.obito.systemclass.class02;

/**
 * @author obito
 */
public class Code02_FindOneOddNumber {

    public static int findOneOddNumber(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int ans = 0;
        for (int n : arr) {
            ans = ans ^ n;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,2,1,4,4,4,5,5,9,9};
        System.out.println(findOneOddNumber(arr));
    }
}
