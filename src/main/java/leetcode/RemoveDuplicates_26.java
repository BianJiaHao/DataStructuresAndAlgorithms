package leetcode;

/**
 * @author admin
 */
public class RemoveDuplicates_26 {
    
    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length < 2) {
            return 1;
        }
        int fastIndex = 1;
        int slowIndex = 1;
        while (fastIndex < nums.length) {
            if (nums[fastIndex] != nums[fastIndex - 1]) {
                nums[slowIndex] = nums[fastIndex];
                slowIndex++;
            }
            fastIndex++;
        }
        return slowIndex;
    }

}
