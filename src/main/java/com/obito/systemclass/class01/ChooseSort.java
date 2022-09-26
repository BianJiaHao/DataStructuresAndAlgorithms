package com.obito.systemclass.class01;

/**
 * @author obito
 */
public class ChooseSort {

    public static void chooseSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            // do nothings
            return;
        }
        int minIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }

    }

    public static void swap(int[] arr,int a,int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void swap2(int[] arr,int a,int b) {
        arr[a] = arr[a] ^ arr[b];
        arr[b] = arr[a] ^ arr[b];
        arr[a] = arr[a] ^ arr[b];
    }

    public static void main(String[] args) {
        int[] arr = new int[]{4,12,2,8,1,76,32,3,5,78};
        chooseSort(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
