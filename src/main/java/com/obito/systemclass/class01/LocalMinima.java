package com.obito.systemclass.class01;

/**
 * @author obito
 */
public class LocalMinima {
    // 6,3,4
    public static int localMinima(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        if (arr[0] < arr[1]) {
            return 0;
        }
        if (arr[arr.length - 1] < arr[arr.length - 2]) {
            return arr.length - 1;
        }
        int l = 1;
        int r = arr.length - 2;
        while (l < r) {
            int middle = l + ((r - l) >> 1);
            if (arr[middle] > arr[middle - 1]) {
                r = middle - 1;
            }else if (arr[middle] > arr[middle + 1]) {
                l = middle + 1;
            }else {
                return middle;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,3,2,4,5};
        System.out.println(localMinima(arr));
    }
}
