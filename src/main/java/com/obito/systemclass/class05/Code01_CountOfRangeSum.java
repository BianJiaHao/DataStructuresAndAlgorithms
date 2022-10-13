package com.obito.systemclass.class05;

import java.util.Arrays;

/**
 * @author obito
 */
public class Code01_CountOfRangeSum {

    public static int getCountOfRangeSum(int[] arr,int lower,int up) {
        if (arr == null || lower > up || arr.length < 1) {
            return 0;
        }
        int[] sum = new int[arr.length];
        sum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }
        return process(sum,0,sum.length - 1,lower,up);
    }

    // nums = [-2,5,-1,3,4], lower = -2, upper = 2 [-2.2,3.5.9] [2,3]
    public static int process(int[] sum,int l,int r,int lower,int up) {
        if (l == r) {
            return sum[l] >= lower && sum[l] <= up ? 1 : 0;
        }
        int m = l + ((r - l) >> 1);
        return process(sum,l,m,lower,up) + process(sum,m + 1,r,lower,up) + merge(sum,l,m,r,lower,up);
    }

    public static int merge(int[] sum,int l,int m,int r,int lower,int upper) {
        int ans = 0;
        int windowL = l;
        int windowR = l;
        for (int i = m + 1; i <= r; i++) {
            int min = sum[i] - upper;
            int max = sum[i] - lower;
            while (windowR <= m && sum[windowR] <= max) {
                windowR++;
            }
            while (windowL <= m && sum[windowL] < min) {
                windowL++;
            }
            ans += windowR - windowL;
        }
        int[] help = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = m + 1;
        while (p1 <= m && p2 <= r) {
            help[index++] = sum[p1] < sum[p2] ? sum[p1++] : sum[p2++];
        }
        while (p1 <= m) {
            help[index++] = sum[p1++];
        }
        while (p2 <= r) {
            help[index++] = sum[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            sum[l + i] = help[i];
        }
        return ans;
    }

    public static int test(int[] arr,int lower,int upper) {
        if (arr == null || lower > upper || arr.length < 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum >= lower && sum <= upper) {
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
        int maxSize = 1000;
        int maxValue = 1000;
        int times = 10000;
        System.out.println("Test begin");
        for (int i = 0; i < times; i++) {
            int lower;
            int upper;
            do {
                lower = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
                upper = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
            }while (lower > upper);
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int value1 = getCountOfRangeSum(arr1, lower, upper);
            int value2 = test(arr2, lower, upper);
            if (value1 != value2) {
                System.out.println("error");
                break;
            }
        }
        System.out.println("Nice");
    }


}
