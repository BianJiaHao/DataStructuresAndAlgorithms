package com.obito.systemclass.class02;

/**
 * @author obito
 */
public class FindTwoOddNumber {

    public static void findTwoOddNumber(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int eor = 0;
        for (int n : arr) {
            eor = eor ^ n;
        }
        int rightOne = eor & (~eor + 1);
        int newEor = 0;
        for (int n : arr) {
            if ((n & rightOne) != 0) {
                newEor = newEor ^ n;
            }
        }
        System.out.println("第一个数为： " + newEor);
        System.out.println("第二个数为： " + (newEor ^ eor));

    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,4,4,5,5,5,7,7,8,8,11,11,11,11};
        findTwoOddNumber(arr);
    }

}
