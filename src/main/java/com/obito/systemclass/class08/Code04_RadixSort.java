package com.obito.systemclass.class08;

/**
 * @author obito
 */
public class Code04_RadixSort {

    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int maxBits = getMaxBits(arr);
        final int radix = 10;
        int k = 0;
        int[] help = new int[arr.length];
        for (int i = 1; i <= maxBits; i++) {
            int[] count = new int[radix];
            for (int j = 0; j < arr.length; j++) {
                count[getDigInt(arr[i],i)]++;
            }
            for (int j = 1; j < radix; j++) {
                count[j] = count[j] + count[j - 1];
            }
            for (int j = arr.length - 1; j >= 0 ; j--) {
                k = getDigInt(arr[j],i);
                help[count[k]- 1] = arr[j];
                count[k]--;
            }
            for (int j = 0; j < help.length; j++) {
                arr[j] = help[j];
            }
        }
    }

    private static int getDigInt(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    private static int getMaxBits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
