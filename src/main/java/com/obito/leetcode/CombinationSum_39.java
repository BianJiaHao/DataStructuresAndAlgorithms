package com.obito.leetcode;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum_39
{
    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        // 最终的答案
        List<List<Integer>> ans = new ArrayList<>();
        // 当前的组合
        List<Integer> combination = new ArrayList<>();
        // 进行递归
        dfs(candidates,target,ans,combination,0);


        return ans;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combination, int index)
    {
        // 如果已经选完了，backup
        if (index == candidates.length)
        {
            return;
        }
        // 如果已经满足条件，backup
        if (target == 0)
        {
            ans.add(new ArrayList<>(combination));
            return;
        }
        // 不选择当前数
        dfs(candidates,target,ans,combination,index + 1);
        // 选择当前数
        if (target - candidates[index] >= 0)
        {
            combination.add(candidates[index]);
            dfs(candidates,target - candidates[index],ans,combination,index);
            combination.remove(combination.size() - 1);
        }
    }
}
