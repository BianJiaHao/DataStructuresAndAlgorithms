package com.obito.utils;

import java.util.Arrays;

/**
 * @author admin
 */
public class ArrayUtil {

    /**
     * 生成一个随机的有序数组
     * @param len 数组的长度
     * @param max 数组中元素的最大值
     * @return 随机的数组
     */
    public static int[] generateRandomArray (int len,int max) {
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * max);
        }
        Arrays.sort(arr);
        return arr;
    }
}
