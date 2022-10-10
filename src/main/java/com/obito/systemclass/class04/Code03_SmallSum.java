package com.obito.systemclass.class04;

import java.util.Arrays;

/**
 * @author obito
 */
public class Code03_SmallSum {

    public static int getSmallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr,0,arr.length - 1);
    }

    public static int process(int[] arr,int l,int r) {
        if (l == r) {
            return 0;
        }
        int m = l + ((r - l) >> 1);
        return process(arr,l,m) + process(arr,m + 1,r) + merge(arr,l,m,r);
    }

    public static int merge(int[] arr,int l,int m,int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = m + 1;
        int res = 0;
        while (p1 <= m && p2 <= r) {
            res += arr[p1] < arr[p2] ? (r - p2 + 1) * arr[p1] : 0;
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }

        while (p1 <= m) {
            help[index++] = arr[p1++];
        }

        while (p2 <= r) {
            help[index++] = arr[p2++];
        }

        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }

        return res;
    }

    public static int test(int[] arr) {
        int ans = 0;
        if (arr == null || arr.length < 2) {
            return 0;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    ans += arr[j];
                }
            }
        }
        return ans;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        return Arrays.copyOf(arr, arr.length);
    }

    public static void main(String[] args) {
        int times = 10_0000;
        int maxSize = 10;
        int maxValue = 1000;
        System.out.println("test begin");
        for (int i = 0; i < times; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int value1 = getSmallSum(arr1);
            int value2 = test(arr2);
            if (value1 != value2) {
                System.out.println("error");
                break;
            }
        }
        System.out.println("test end");

    }
}
