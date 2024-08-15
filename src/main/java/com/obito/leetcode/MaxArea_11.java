package com.obito.leetcode;

/**
 * @author admin
 */
public class MaxArea_11
{
    public int maxArea(int[] height)
    {
        // 左指针
        int leftIndex = 0;
        // 右指针
        int rightIndex = height.length - 1;
        // 最终结果
        int ans = 0;
        while (leftIndex < rightIndex)
        {
            int area = Math.min(height[leftIndex],height[rightIndex]) * (rightIndex - leftIndex);
            ans = Math.max(area,ans);
            if (height[leftIndex] < height[rightIndex])
            {
                leftIndex++;
            }
            else
            {
                rightIndex--;
            }
        }
        
        return ans;
    }
}
