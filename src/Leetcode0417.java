import java.util.ArrayList;
import java.util.List;

public class Leetcode0417 {

    class Solution {
        public List<List<Integer>> pacificAtlantic(int[][] matrix) {
            List<List<Integer>> result = new ArrayList<>();
            int m = matrix.length;
            if (m == 0) return result;
            int n = matrix[0].length;

            // 定义 table1、table2 存储是否流入太平洋
            boolean[][] table1 = new boolean[m][n];
            boolean[][] table2 = new boolean[m][n];

            // 能否触达上、下
            for (int i = 0; i < n; i++) {
                dfs(matrix, 0, i, matrix[0][i], table1);
                dfs(matrix, m - 1, i, matrix[m - 1][i], table2);
            }

            // 能否触达左右
            for (int i = 0; i < m; i++) {
                dfs(matrix, i, 0, matrix[i][0], table1);
                dfs(matrix, i, n - 1, matrix[i][n - 1], table2);
            }

            // 取出都能触达的点
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (table1[i][j] && table2[i][j]) {
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        result.add(list);
                    }
                }
            }

            return result;
        }

        public void dfs(int[][] matrix, int x, int y, int pre, boolean[][] table) {
            if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length ||
                    matrix[x][y] < pre || // 当前值小于上一个值
                    table[x][y] // 当前值已经被标记
            ) return;

            table[x][y] = true;

            // 上下左右
            dfs(matrix, x - 1, y, matrix[x][y], table);
            dfs(matrix, x + 1, y, matrix[x][y], table);
            dfs(matrix, x, y - 1, matrix[x][y], table);
            dfs(matrix, x, y + 1, matrix[x][y], table);
        }
    }
}
