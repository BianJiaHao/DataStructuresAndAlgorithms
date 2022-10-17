package com.obito.systemclass.class05;

/**
 * @author obito
 */
public class Code02_QuickSort {

    private static void wayOnlyHaveLessArea(int[] arr) {
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

    public static void wayOfHaveBigArea(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr,0,arr.length - 1);
    }

    public static void process2(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        int[] equalArea = quickSort2(arr,l,r);
        process2(arr,l,equalArea[0] - 1);
        process2(arr,equalArea[1] + 1,r);
    }

    public static int[] quickSort2(int[] arr,int l,int r) {
        int less = l - 1;
        int bigger = r;
        int index = l;
        while (index < bigger) {
            if (arr[index] < arr[r]) {
                swap(arr,++less,index++);
            }else if (arr[index] > arr[r]) {
                swap(arr,--bigger,index);
            }else {
                index++;
            }
        }
        swap(arr,r,bigger);
        return new int[]{less + 1,bigger};
    }

    public static void wayOfRandom(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr,0,arr.length - 1);
    }

    public static void process3(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        swap(arr,l + (int)((r - l + 1) * Math.random()),r);
        int[] equalArea = quickSort2(arr, l, r);
        process3(arr,l,equalArea[0] - 1);
        process3(arr,equalArea[1] + 1,r);
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }



    public static void main(String[] args) {
        int[] arr = new int[]{9,8,5,5,50,68,4};
        wayOfRandom(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
