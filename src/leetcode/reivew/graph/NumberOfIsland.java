package leetcode.reivew.graph;

// Easy
public class NumberOfIsland {

    class Solution {

        final int[] dr = {-1, 0, 0, 1};
        final int[] dc = {0, -1, 1, 0};

        public int numIslands(char[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(grid[i][j] == '1') {
                        grid[i][j] = '0';
                        count++;
                        DFS(grid, i, j);
                    }
                }
            }

            return count;
        }

        public void DFS(char[][] grid, int r, int c) {

            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    DFS(grid, nr, nc);
                }
            }
        }
    }
}
