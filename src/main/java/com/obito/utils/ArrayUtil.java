package com.obito.utils;

import java.util.Arrays;

/**
 * @author admin
 */
public class ArrayUtil {
    
    public static int[] generateRandomArray (int len,int max) {
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * max);
        }
        Arrays.sort(arr);
        return arr;
    }
}
