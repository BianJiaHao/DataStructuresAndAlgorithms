package com.obito.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Permute_46
{
    public static List<List<Integer>> permute(int[] nums)
    {
        // 最后的答案
        List<List<Integer>> ans = new ArrayList<>();
        // 当前组合
        List<Integer> output = new ArrayList<>();
        for (int num : nums)
        {
            output.add(num);
        }
        per(nums,ans,output,0);
        return ans;
    }

    private static void per(int[] nums, List<List<Integer>> ans, List<Integer> output, int index)
    {
        if (index == nums.length)
        {
            ans.add(new ArrayList<>(output));
        }
        for (int i = index; i < nums.length; i++)
        {
            Collections.swap(output,index,i);
            per(nums,ans,output,index + 1);
            Collections.swap(output,index,i);
        }

    }

    public static void main(String[] args)
    {
        int[] ints = new int[]{1,2,3};

        permute(ints);
    }
}
