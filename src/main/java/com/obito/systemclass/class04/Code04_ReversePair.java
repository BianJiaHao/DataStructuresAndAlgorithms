package com.obito.systemclass.class04;

import java.util.Arrays;

/**
 * @author obito
 */
public class Code04_ReversePair {

    public static int getReversePair(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return process(arr,0,arr.length - 1);
    }

    public static int process(int[] arr,int l,int r) {
        if (l == r) {
            return 0;
        }
        int middle = l + ((r - l) >> 1);
        return process(arr,l,middle) + process(arr,middle + 1,r) + merge(arr,l,middle,r);
    }

    public static int merge(int[] arr,int l,int m,int r) {
        int[] help = new int[r - l + 1];
        int ans = 0;
        int index = help.length - 1;
        int p1 = m;
        int p2 = r;
        while (p1 >= l && p2 >= m + 1) {
            ans += arr[p1] > arr[p2] ? (p2 - m) : 0;
            help[index--] = arr[p1] > arr[p2] ? arr[p1--] : arr[p2--];
        }
        while (p1 >= l) {
            help[index--] = arr[p1--];
        }
        while (p2 >= m + 1) {
            help[index--] = arr[p2--];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
        return ans;
    }

    public static int test(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public static int[] generateRandomArray(int maxSize,int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        return Arrays.copyOf(arr,arr.length);
    }

    public static void main(String[] args) {
        int maxSize = 1_0000;
        int maxValue = 1_0000;
        int times = 100;
        System.out.println("Test begin!");
        for (int i = 0; i < times; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int value1 = getReversePair(arr1);
            int value2 = test(arr2);
            if (value1 != value2) {
                System.out.println("error");
                break;
            }
        }
        System.out.println("Test end!");

    }
}
