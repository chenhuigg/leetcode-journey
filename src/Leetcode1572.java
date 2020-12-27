public class Leetcode1572 {

    class Solution {
        public int diagonalSum(int[][] mat) {
            int m = mat.length;
            int count = 0;

            for (int i = 0; i < m; i++) { // 左上到右下
                count += mat[i][i];
            }

            for (int i = 0; i < m; i++) { // 左下到右上
                count += mat[i][m - i - 1];
            }

            if ((m & 1) == 1) { // 如果是奇数，
                count -= mat[m / 2][m / 2];
            }

            return count;
        }
    }

}
