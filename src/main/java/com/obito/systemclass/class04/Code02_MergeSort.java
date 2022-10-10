package com.obito.systemclass.class04;

public class Code02_MergeSort {

    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        mergeByRange(arr,0,arr.length - 1);
    }

    public static void mergeByRange(int[] arr,int l,int r) {
        if (l == r) {
            return;
        }
        int middle = l + ((r - l) >> 1);
        mergeByRange(arr,l,middle);
        mergeByRange(arr,middle + 1,r);
        merge(arr,middle,l,r);
    }

    public static void merge(int[] arr,int middle,int l,int r) {
        int[] help = new int[r - l + 1];
        int index = 0;
        int p1 = l;
        int p2 = middle + 1;
        while (p1 <= middle && p2 <= r) {
            help[index++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= middle) {
            help[index++] = arr[p1++];
        }
        while (p2 <= r) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[l + i] = help[i];
        }
    }

    public static void mergeSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        int mergeSize = 1;
        while (mergeSize < n) {
            int l = 0;
            while (l < n) {
                if (mergeSize > n - l) {
                    break;
                }
                int m = l + mergeSize - 1;
                int r = m + Math.min(mergeSize,n - m - 1);
                merge(arr,m,l,r);
                l = r + 1;
            }
            if (mergeSize > n / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,12,5,6,8,2,15};
        mergeSort2(arr);
        for (int num : arr) {
            System.out.println(num);
        }
    }
}
