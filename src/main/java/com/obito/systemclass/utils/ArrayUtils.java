package com.obito.systemclass.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author obito
 */
@Slf4j
public class ArrayUtils {
    
    public static int[] generateRandomArray(int maxSize,int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(((maxValue + 1) * Math.random()) - (maxValue * Math.random()));
        }
        log.info("生成随机数组成功,数组大小为:{}",arr.length);
        return arr;
    }
    
    public static int[] generateNoRepRandomArray(int maxSize,int maxValue) {
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            int random = (int)(((maxValue + 1) * Math.random()) - (maxValue * Math.random()));
            while (set.contains(random) || random == 0) {
                random = (int)(((maxValue + 1) * Math.random()) - (maxValue * Math.random()));
            }
            set.add(random);
            arr[i] = random;
        }
        log.info("生成随机数组成功,数组大小为:{}",arr.length);
        return arr;
    }
    
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] copy = new int[arr.length];
        System.arraycopy(arr, 0, copy, 0, arr.length);
        log.info("拷贝数组成功");
        return copy;
    }
    
    public static boolean isEqual(int[] arr1,int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        boolean equal = true;
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                equal = false;
                break;
            }
        }
        return equal;
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
}
