import java.util.Arrays;

public class Leetcode0300 {

    public static void main(String[] args) {
        int[] nums = new int[] {10,9,2,5,3,7,101,18};
        int i = new Leetcode0300().new Solution().lengthOfLIS(nums);
        System.err.println(i);
    }

    class Solution {
        public int lengthOfLIS(int[] nums) {
            int m = nums.length;
            int[] dp = new int[m];
            dp[0] = 1;
            int maxLength = 1;
            for (int i = 1; i < m; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }

            return maxLength;
        }
    }
}
