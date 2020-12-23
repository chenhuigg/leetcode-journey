public class Leetcode0221 {

    public static void main(String[] args) {

    }

    class Solution {
        public int maximalSquare(char[][] matrix) {
            int height = matrix.length; // 高度
            int width = matrix[0].length; // 宽度
            int max = 0; // 保存最大值

            int[][] dp = new int[height + 1][width + 1];

            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (matrix[i][j] == '1') {
                        dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j], dp[i][j + 1]), dp[i + 1][j]) + 1;
                        max = Math.max(max, dp[i + 1][j + 1]);
                    }
                }
            }

            return max * max;
        }
    }
}
