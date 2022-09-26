package com.obito.systemclass.class01;

/**
 * @author obito
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr,j + 1,j);
                }
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
        bubbleSort(arr);
        for (int j : arr) {
            System.out.println(j);
        }
    }

}
