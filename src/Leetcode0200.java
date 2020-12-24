public class Leetcode0200 {

    class Solution {
        int offsetx[] = {1, 0, -1, 0};
        int offsety[] = {0, 1, 0, -1};
        public int numIslands(char[][] grid) {
            int num = 0; // 岛屿数量

            int m = grid.length;
            int n = grid[0].length;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        num++;
                        dfs(grid, i, j);
                    }
                }
            }

            return num;
        }

        public void dfs(char[][] grid, int x, int y) {
            // 将当前状态改为 0
            grid[x][y] = '0';

            // 遍历上下左右
            for (int i = 0; i < 4; i++) {
                int nx = x + offsetx[i];
                int ny = y + offsety[i];
                if (nx < 0 || ny < 0 || nx >= grid.length || ny >= grid[0].length)
                    continue;
                if (grid[nx][ny] == '1') {
                    dfs(grid, nx, ny);
                }
            }

        }
    }

}
