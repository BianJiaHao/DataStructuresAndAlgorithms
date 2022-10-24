package com.obito.systemclass.class06;

/**
 * @author obito
 */
public class Code03_HeapSort {

    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
//        for (int i = 0; i < arr.length; i++) {
//            heapInsert(arr,i);
//        }
        for (int i = arr.length - 1; i >= 0; i--) {
            heapFly(arr,i,arr.length);
        }
        int heapSize = arr.length;
        swap(arr,0,--heapSize);
        while (heapSize > 0) {
            heapFly(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }

    public static void heapFly(int[] arr,int index,int heapSize) {
        int left = index * 2 + 1;
        while (left < heapSize) {
            int maxIndex = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;
            maxIndex = arr[index] > arr[maxIndex] ? index : maxIndex;
            if (maxIndex == index) {
                break;
            }
            swap(arr,index,maxIndex);
            index = maxIndex;
            left = index * 2 + 1;
        }
    }

    public static void heapInsert(int[] arr,int index) {
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr,index,(index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{8,12,63,67,13,1,6};
        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
