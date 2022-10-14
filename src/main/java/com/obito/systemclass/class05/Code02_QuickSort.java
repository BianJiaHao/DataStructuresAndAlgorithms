package com.obito.systemclass.class05;

/**
 * @author obito
 */
public class Code02_QuickSort {

    private static void way1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr,0,arr.length - 1);
    }

    public static void process1(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        int m = quickSort1(arr,l,r);
        process1(arr,l,m - 1);
        process1(arr,m + 1,r);
    }

    public static int quickSort1(int[] arr,int l,int r) {
        int less = l - 1;
        int index = l;
        while (index < r) {
            if (arr[index] < arr[r]) {
                swap(arr,++less,index);
            }
            index++;
        }
        swap(arr,++less,r);
        return less;
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,4,6,4,1};
        way1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
