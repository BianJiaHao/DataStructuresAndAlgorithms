package com.obito.leetcode;

/**
 * @author admin
 */
public class RemoveElement_27 {
    
    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int size = 0;
        int index = 0;
        int lastIndex = nums.length - 1;
        while (index < nums.length && index <= lastIndex) {
            if (nums[index] == val) {
                swap(nums,lastIndex--,index);
            }else {
                size++;
                index++;
            }
        }
        
        return size;
    }
    
    public static void swap(int[] arr,int a,int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
