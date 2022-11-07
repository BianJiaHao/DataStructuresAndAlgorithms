package com.obito.systemclass.class08;

/**
 * @author obito
 */
public class Code03_CountSort {

    public static void countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(j, max);
        }
        int[] help = new int[max + 1];
        for (int j : arr) {
            help[j]++;
        }
        int index = 0;
        for (int i = 0; i < help.length; i++) {
            while (help[i]-- > 0) {
                arr[index++] = help[i];
            }
        }
    }
}
