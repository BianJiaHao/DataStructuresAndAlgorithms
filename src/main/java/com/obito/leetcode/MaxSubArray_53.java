package com.obito.leetcode;

/**
 * @author admin
 */
public class MaxSubArray_53
{
    public static int maxSubArray(int[] nums)
    {
        if (nums.length == 1)
        {
            return nums[0];
        }
        // 左指针
        int leftIndex = 0;
        // 右指针
        int rightIndex = leftIndex + 1;
        // 最终答案
        int ans = nums[0];
        // 当前和
        int current = nums[0];
        while (leftIndex < nums.length && rightIndex < nums.length)
        {
            current += nums[rightIndex];
            ans = Math.max(current,ans);
            rightIndex++;
            if (rightIndex == nums.length)
            {
                leftIndex++;
                rightIndex = leftIndex + 1;
                current = nums[leftIndex];
                ans = Math.max(current,ans);
            }
        }
        
        
        
        return ans;
    }
    
    public static void main(String[] args)
    {
        int nums[] = new int[]{-1,-2};
        
        System.out.println(maxSubArray(nums));
    }
}
