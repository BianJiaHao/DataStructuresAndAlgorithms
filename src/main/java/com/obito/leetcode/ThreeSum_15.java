package com.obito.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author admin
 */
public class ThreeSum_15
{
    public List<List<Integer>> threeSum(int[] nums)
    {
        // 从小到大进行排序
        Arrays.sort(nums);
        // 数组长度
        int n = nums.length;
        // 最终结果
        List<List<Integer>> ans = new ArrayList<>();
        for (int first = 0; first < n; first++)
        {
            // 跳过相同的
            if (first > 0 && nums[first] == nums[first - 1])
            {
                continue;
            }
            
            // c的指针
            int third = n - 1;
            
            // 后面两个数相加结果
            int target = -nums[first];
            
            for (int second = first + 1; second < n; second++)
            {
                // 跳过相同的
                if (second > first + 1 && nums[second] == nums[second - 1])
                {
                    continue;
                }
                while (second < third && nums[second] + nums[third] > target)
                {
                    third--;
                }
                if (second == third)
                {
                    break;
                }
                if (nums[second] + nums[third] == target)
                {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
                
            }
        }
        
        
        
        
        
        
        return ans;
    }
}
