package com.obito.systemclass.class01;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import static com.obito.systemclass.utils.ArrayUtils.*;

/**
 * @author obito
 */
@Slf4j
public class Code01_ChooseSort {

    public static void chooseSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            // do nothing's
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                minIndex = arr[j] < arr[minIndex] ? j : minIndex;
            }
            swap(arr,i,minIndex);
        }

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
            chooseSort(array2);
            
            boolean result = isEqual(array1, array2);
            
            if (!result) {
                break;
            }
        }
        long end = System.currentTimeMillis();
        
        log.info("执行成功,总共执行{}次,总耗时{}ms",testTimes,end - start);
    }
}
