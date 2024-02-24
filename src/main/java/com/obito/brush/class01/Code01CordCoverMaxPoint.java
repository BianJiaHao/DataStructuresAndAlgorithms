package com.obito.brush.class01;

import com.obito.utils.ArrayUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * @author admin
 * 给定一个有序数组arr，代表坐落在X轴上的点，给定一个正数K，代表绳子的长度，返回绳子最多压中几个点？
 * 即使绳子边缘处盖住点也算盖住
 */
@Slf4j
public class Code01CordCoverMaxPoint {
    
    /**
     * 方法一：贪心算法，绳子边缘一定位于点上才能让最后的结果最大化，假设绳子的末端在某一个点上，那么绳子能覆盖的最大范围也能确认
     * 只要找到这个范围内最靠近绳子前端的点就能求出最多能压中几个点，用二分法的方法
     * 时间复杂度为 O(N * logN)
     * @param arr 数组
     * @param l 绳子长度
     * @return 最多压中几个点
     */
    public static int way1 (int[] arr, int l) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int nearIndex = getNearIndex(arr,i,arr[i] - l);
            res = Math.max(res,i - nearIndex + 1);
        }
        return res;
    }
    
    /**
     * 方法二：使用滑动窗口的方法
     * 时间复杂度：O(N)
     * @param arr 数组
     * @param l 绳子长度
     * @return 最多压中几个点
     */
    public static int way2 (int[] arr, int l) {
        int res = 0;
        int left = 0,right = 0;
        int length = arr.length;
        while (left < length) {
            while (right < length && arr[right] - arr[left] <= l) {
                right++;
            }
            res = Math.max(res,right - (left++));
        }
        
        return res;
    }
    
    /**
     * 方法三：暴力循环方法
     * 时间复杂度：O(N²)
     * @param arr 数组
     * @param l 绳子长度
     * @return 最多压中几个点
     */
    public static int way3 (int[] arr,int l) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int pre = i - 1;
            while (pre >= 0 && arr[i] - arr[pre] <= l) {
                pre--;
            }
            res = Math.max(res,i - pre);
        }
        return res;
    }
    
    private static int getNearIndex(int[] arr, int r, int num) {
        int left = 0;
        int index = r;
        while (left <= r) {
            int mid = left + ((r - left) >> 1);
            if (arr[mid] >= num) {
                index = mid;
                r = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
    
    public static void main(String[] args) {
        int len = 100;
        int max = 10000;
        int count = 1000;
        for (int i = 0; i < count; i++) {
            int[] arr = ArrayUtil.generateRandomArray(len, max);
            int l = (int)(Math.random() * max);
            int result1 = way1(arr, l);
            int result2 = way2(arr, l);
            int result3 = way3(arr, l);
            if (result1 != result2 || result2 != result3) {
                System.out.println(result1);
                System.out.println(result2);
                System.out.println(result3);
                throw new RuntimeException("测试失败");
            }
        }
        log.info("测试成功");
    }
}
