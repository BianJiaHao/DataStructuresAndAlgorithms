package com.obito.systemclass.class05;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author obito
 */
public class Code02_QuickSort {

    private static void wayOnlyHaveLessArea(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr,0,arr.length - 1);
    }

    public static void process1(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        int m = quickSort1(arr,l,r);
        process1(arr,l,m - 1);
        process1(arr,m + 1,r);
    }

    public static int quickSort1(int[] arr,int l,int r) {
        int less = l - 1;
        int index = l;
        while (index < r) {
            if (arr[index] < arr[r]) {
                swap(arr,++less,index);
            }
            index++;
        }
        swap(arr,++less,r);
        return less;
    }

    public static void wayOfHaveBigArea(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr,0,arr.length - 1);
    }

    public static void process2(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        int[] equalArea = quickSort2(arr,l,r);
        process2(arr,l,equalArea[0] - 1);
        process2(arr,equalArea[1] + 1,r);
    }

    public static int[] quickSort2(int[] arr,int l,int r) {
        int less = l - 1;
        int bigger = r;
        int index = l;
        while (index < bigger) {
            if (arr[index] < arr[r]) {
                swap(arr,++less,index++);
            }else if (arr[index] > arr[r]) {
                swap(arr,--bigger,index);
            }else {
                index++;
            }
        }
        swap(arr,r,bigger);
        return new int[]{less + 1,bigger};
    }

    public static void wayOfRandom(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr,0,arr.length - 1);
    }

    public static void process3(int[] arr,int l,int r) {
        if (l >= r) {
            return;
        }
        swap(arr,l + (int)((r - l + 1) * Math.random()),r);
        int[] equalArea = quickSort2(arr, l, r);
        process3(arr,l,equalArea[0] - 1);
        process3(arr,equalArea[1] + 1,r);
    }

    public static void swap(int[] arr,int i,int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void test(int[] arr) {
        Arrays.sort(arr);
    }

    public static class Op {
        private int left;
        private int right;

        public Op(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    /**
     * 非递归-栈实现
     * @param arr 排序数组
     */
    public static void noReUseStack(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        swap(arr,(int)(n * Math.random()),n - 1);
        int[] equalArea = quickSort2(arr, 0, n - 1);
        int left = equalArea[0];
        int right = equalArea[1];
        Stack<Op> ops = new Stack<>();
        ops.push(new Op(0,left - 1));
        ops.push(new Op(right + 1,n - 1));
        while (!ops.isEmpty()) {
            Op process = ops.pop();
            if (process.left < process.right) {
                swap(arr,process.left + (int)((process.right - process.left + 1) * Math.random()),process.right);
                int[] equal = quickSort2(arr, process.left, process.right);
                ops.push(new Op(process.left,equal[0] - 1));
                ops.push(new Op(equal[1] + 1,process.right));
            }
        }
    }

    /**
     * 非递归-队列实现
     * @param arr 排序数组
     */
    public static void noReUseQueue(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int n = arr.length;
        swap(arr,(int)(n * Math.random()),n - 1);
        int[] equalArea = quickSort2(arr, 0, n - 1);
        int left = equalArea[0];
        int right = equalArea[1];
        Queue<Op> ops = new LinkedList<>();
        ops.offer(new Op(0,left - 1));
        ops.offer(new Op(right + 1,n - 1));
        while (!ops.isEmpty()) {
            Op process = ops.poll();
            if (process.left < process.right) {
                swap(arr,process.left + (int)((process.right - process.left + 1) * Math.random()),process.right);
                int[] equal = quickSort2(arr, process.left, process.right);
                ops.offer(new Op(process.left,equal[0] - 1));
                ops.offer(new Op(equal[1] + 1,process.right));
            }
        }
    }

    public static int[] generateRandomArray(int maxSize,int maxValue) {
        int[] arr = new int[(int)((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)((maxValue + 1) * Math.random()) - (int)(maxValue * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr) {
        int[] ans = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public static boolean arrIsEqual(int[] arr1,int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int maxValue = 1_0000;
        int maxSize = 1000;
        int times = 10_0000;
        System.out.println("Test start");
        for (int i = 0; i < times; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            int[] arr3 = copyArray(arr1);
            int[] arr4 = copyArray(arr1);
            int[] arr5 = copyArray(arr1);
            int[] arr6 = copyArray(arr1);
            wayOfHaveBigArea(arr1);
            wayOnlyHaveLessArea(arr2);
            wayOfRandom(arr3);
            test(arr4);
            noReUseStack(arr5);
            noReUseQueue(arr6);
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] != arr2[j] || arr1[j] != arr3[j] || arr1[j] != arr4[j] || arr1[j] != arr5[j] || arr1[j] != arr6[j]) {
                    System.out.println("Error");
                    break;
                }
            }
        }
        System.out.println("Nice");
    }
}
