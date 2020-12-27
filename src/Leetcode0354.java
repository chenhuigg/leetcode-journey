import java.util.Arrays;

public class Leetcode0354 {

    public static void main(String[] args) {
        int[][] envelopes = new int[3][2];
        envelopes[0][0] = 5;
        envelopes[0][1] = 4;

        envelopes[1][0] = 8;
        envelopes[1][1] = 2;

        envelopes[2][0] = 2;
        envelopes[2][1] = 3;

        Solution solution = new Leetcode0354().new Solution();
        int i = solution.maxEnvelopes(envelopes);
        System.err.println(i);
    }

    class Solution {
        public int maxEnvelopes(int[][] envelopes) {
            if (envelopes == null || envelopes.length == 0) {
                return 0;
            }

            // 按照宽度排序
            Arrays.sort(envelopes, (w1, w2) -> w1[0] - w2[0] == 0 ? w1[1] - w2[1] : w1[0] - w2[0]);

            // 最长递增子序列
            int m = envelopes.length;
            int dp[] = new int[m];
            dp[0] = 1;
            int maxLength = 1;
            for (int i = 1; i < m ;i++) {
                dp[i] = 1;
                for (int j = 0 ; j < i ; j++) {
                    if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }

            return maxLength;
        }
    }
}
