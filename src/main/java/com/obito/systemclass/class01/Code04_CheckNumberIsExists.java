package com.obito.systemclass.class01;

import com.obito.systemclass.utils.ArrayUtils;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;

/**
 * @author obito
 */
@Slf4j
public class Code04_CheckNumberIsExists {

    public static int checkNumberIsExists(int[] arr,int t) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int l = 0;
        int r = arr.length - 1;
        while (l <= r) {
            int middle = l + ((r - l) >> 1);
            if (arr[middle] < t) {
                l = middle + 1;
            }else if (arr[middle] > t){
                r = middle - 1;
            }else {
                return middle;
            }
        }
        
        return -1;
    }
    
    public static int checkNumberIsExistsWay2(int[] arr,int t) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == t) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int testTimes = 1_0000;
        int maxSize = 1000;
        int maxValue = 1000;
        for (int i = 0; i < testTimes; i++) {
            int[] arr = ArrayUtils.generateNoRepRandomArray(maxSize, maxValue);
            Arrays.sort(arr);
            
            int random = (int)((maxValue + 1) * Math.random());
            
            int indexOne = checkNumberIsExists(arr, random);
            int indexTwo = checkNumberIsExistsWay2(arr, random);
            
            if (indexTwo != indexOne) {
                log.info("执行失败" + indexOne + "-" + indexTwo);
                break;
            }
            
        }
        
        log.info("执行成功");
        
    }
}
