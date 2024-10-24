package com.obito.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author admin
 * 给你一个正整数数组 nums
 * 每一次操作中，你可以从 nums 中选择 任意 一个数并将它减小到 恰好 一半
 * 注意，在后续操作中你可以对减半过的数继续执行操作）
 * 请你返回将 nums 数组和 至少 减少一半的 最少 操作数
 */
public class MinimumOperationsToHalveArraySum_2208
{
    public static int halveArray01(int[] nums)
    {
        int ans = 0;
        // 总数和
        double sum = 0;
        // 准备一个系统大根堆
        PriorityQueue<Double> queue = new PriorityQueue<>(Comparator.reverseOrder());
        // 原数组数据放入到堆中
        for (int num : nums)
        {
            queue.add((double)num);
            sum += num;
        }
        // 和减少一半
        sum /= 2;
        for (double decrease = 0,cur;decrease < sum;ans++,decrease += cur)
        {
            cur = queue.poll() / 2;
            queue.add(cur);
        }
        
        return ans;
    }
    
    private static int size;
    
    private static long[] heap = new long[100001];
    
    public static int halveArray02(int[] nums)
    {
        int ans = 0;
        size = nums.length;
        long sum = 0;
        for (int i = size - 1; i >= 0; i--)
        {
            heap[i] = (long) nums[i] << 20;
            sum += heap[i];
            heapify(i);
        }
        sum /= 2;
        for (long minus = 0;minus < sum;ans++)
        {
            heap[0] /= 2;
            minus += heap[0];
            heapify(0);
        }
        
        
        return ans;
    }
    
    public static void heapify(int index)
    {
        int left = index * 2 + 1;
        while (left < size)
        {
            int best = left + 1 < size && heap[left + 1] > heap[left] ? left + 1 : left;
            best = heap[index] > heap[best] ? index : best;
            if (best == index)
            {
                break;
            }
            swap(index,best);
            index = best;
            left = index * 2 + 1;
        }
    }
    
    public static void swap(int a,int b)
    {
        long temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }
}
