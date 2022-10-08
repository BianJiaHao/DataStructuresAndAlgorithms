package com.obito.systemclass.class04;

public class Code01_GetMax {

    public static int getMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new RuntimeException("arr为空");
        }
        if (arr.length == 1) {
            return arr[0];
        }
        return getMaxByRange(arr,0,arr.length - 1);
    }

    public static int getMaxByRange(int[] arr,int l,int r) {
        if (l == r) {
            return arr[l];
        }
        int middle = l + ((r - l) >> 1);
        int left = getMaxByRange(arr,l,middle);
        int right = getMaxByRange(arr,middle + 1,r);
        return Math.max(left,right);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5,12,5,6,8,2,15};
        System.out.println(getMax(arr));
    }
}
