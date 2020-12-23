public class Leetcode0583 {
    class Solution {
        public int minDistance(String word1, String word2) {
            int len1 = word1.length();
            int len2 = word2.length();

            int dp[][] = new int[len1 + 1][len2 + 1];

            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j] + 1;
                    } else {
                        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                    }
                }
            }

            int deleteNum = dp[len1][len2];
            return len1 + len2 - 2 * deleteNum ;
        }
    }
}
