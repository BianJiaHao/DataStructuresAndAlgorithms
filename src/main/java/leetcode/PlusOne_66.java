package leetcode;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author admin
 */
public class PlusOne_66 {
    
    public static int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return null;
        }
        int length = digits.length;
        for (int i = length - 1; i >= 0 ; i--) {
            if (digits[i] != 9) {
                digits[i]++;
                for (int j = i + 1; j < length; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] arr = new int[length + 1];
        arr[0] = 1;
        return arr;
    }
    
}
