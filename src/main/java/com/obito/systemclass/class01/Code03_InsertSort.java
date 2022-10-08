package com.obito.systemclass.class01;

/**
 * @author obito
 */
public class Code03_InsertSort {

    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >=0 && arr[j] > arr[j + 1] ; j--) {
                swap(arr,j,j + 1);
            }
        }
    }

    public static void swap(int[] arr,int a,int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,12,2,8,1,76,32,3,5,78};
        insertSort(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
