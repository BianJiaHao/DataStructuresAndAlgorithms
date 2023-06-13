package leetcode;

/**
 * @author admin
 */
public class UnequalTriplets_2475 {
    
    public static int unequalTriplets(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] != nums[j] && nums[j] != nums[k] && nums[i] != nums[k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] arr = new int[]{4,4,2,4,3};
        System.out.println(unequalTriplets(arr));
    }
}
