package com.obito.systemclass.class01;

/**
 * @author obtio
 */
public class CheckNumberByRange {

    public static int checkNumberByRange(int[] arr,int t) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        int ans = -1;
        while (l <= r) {
            int middle = l + ((r - l) >> 1);
            if (arr[middle] >= t) {
                r = middle - 1;
                ans = middle;
            }else if (arr[middle] < t) {
                l = middle + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,4,6,7,9,11,34,45,67,78};
        System.out.println(checkNumberByRange(arr,10));
    }
}
