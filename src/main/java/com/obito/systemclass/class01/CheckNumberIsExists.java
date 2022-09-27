package com.obito.systemclass.class01;

/**
 * @author obito
 */
public class CheckNumberIsExists {

    public static int checkNumberIsExists(int[] arr,int t) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int middle = l + ((r - l) >> 1);
            if (arr[middle] < t) {
                l = middle + 1;
            }else if (arr[middle] > t){
                r = middle - 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,6,7,9,11,34,45,67,78};
        System.out.println(checkNumberIsExists(arr,11));
    }
}
