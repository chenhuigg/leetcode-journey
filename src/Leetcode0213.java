public class Leetcode0213 {

    class Solution {
        public int rob(int[] nums) {
            int len = nums.length;
            if (len == 0) return 0;
            if (len == 1) return nums[0];
            return Math.max(dp(nums, 0), dp(nums, 1));
        }

        private int dp(int[] nums, int start) {
            int len = nums.length;
            int dp[] = new int[len];
            dp[1] = nums[start];

            for (int i = 2; i < len; i++) {
                dp[i] = Math.max(dp[i - 2] + nums[i - 1 + start], dp[i - 1]);
            }

            return dp[len - 1];
        }
    }

}
