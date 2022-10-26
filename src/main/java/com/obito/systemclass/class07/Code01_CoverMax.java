package com.obito.systemclass.class07;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author obito
 */
public class Code01_CoverMax {

    public static int way01(int[][] lines) {
        if (lines == null || lines.length == 0) {
            return 0;
        }
        if (lines.length == 1) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int[] line : lines) {
            min = Math.min(min, line[0]);
            max = Math.max(max, line[1]);
        }
        int ans = 0;
        for (double i = min + 0.5; i < max; i++) {
            int cur = 0;
            for (int[] line : lines) {
                if (line[0] < i && line[1] > i) {
                    cur++;
                }
            }
            ans = Math.max(ans,cur);
        }
        return ans;
    }

    public static int way02(int[][] lines) {
        if (lines == null || lines.length == 0) {
            return 0;
        }
        if (lines.length == 1) {
            return 1;
        }
        Arrays.sort(lines,new MyComparator());
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int ans = 0;
        for (int[] line : lines) {
            while (!heap.isEmpty() && heap.peek() <= line[0]) {
                heap.poll();
            }
            heap.add(line[1]);
            ans = Math.max(ans,heap.size());
        }
        return ans;
    }

    public static class MyComparator implements Comparator<int[]>{
        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }
    }

    public static int[][] generateArray(int maxSize,int min,int max) {
        int size = (int)((maxSize + 1) * Math.random());
        int[][] arr = new int[size][2];
        for (int i = 0; i < size; i++) {
            int a = (int)((max - min + 1) * Math.random());
            int b = (int)((max - min + 1) * Math.random());
            if (a == b) {
                b = a + 1;
            }
            arr[i][0] = Math.min(a,b);
            arr[i][1] = Math.max(a,b);
        }
        return arr;
    }

    public static void main(String[] args) {
        int maxSize = 1000;
        int min = 0;
        int max = 200;
        int times = 10000;
        System.out.println("Test begin");
        for (int i = 0; i < times; i++) {
            int[][] arr = generateArray(maxSize, min, max);
            int value1 = way01(arr);
            int value2 = way02(arr);
            if (value1 != value2) {
                System.out.println("error");
                break;
            }
        }
        System.out.println("Nice");
    }


}
