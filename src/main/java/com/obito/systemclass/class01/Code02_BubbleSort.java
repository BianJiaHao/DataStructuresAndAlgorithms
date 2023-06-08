package com.obito.systemclass.class01;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import static com.obito.systemclass.utils.ArrayUtils.*;

/**
 * @author obito
 */
@Slf4j
public class Code02_BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = arr.length - 1; i >= 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j + 1] < arr[j]) {
                    swap(arr,j + 1,j);
                }
            }
        }
    }

    public static void swap(int[] arr,int a,int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    
    public static void main(String[] args) {
        int testTimes = 1_0000;
        int maxSize = 1000;
        int maxValue = 1000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < testTimes; i++) {
            int[] array1 = generateRandomArray(maxSize, maxValue);
            int[] array2 = copyArray(array1);
            
            Arrays.sort(array1);
            bubbleSort(array2);
            
            boolean result = isEqual(array1, array2);
            
            if (!result) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        
        log.info("执行成功,总共执行{}次,总耗时{}ms",testTimes,end - start);
    }

}
