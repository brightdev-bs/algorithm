package leetcode.graph;

public class NumberOfIslands {
    class Solution {

        int[] dr = {-1, 0, 0, 1}, dc = {0, 1, -1, 0};

        public int numIslands(char[][] grid) {
            int m = grid.length;
            int n = grid[0].length;

            int answer = 0;
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(grid[i][j] == '1') {
                        grid[i][j] = '0';
                        answer++;
                        DFS(i, j, grid);
                    }
                }
            }
            return answer;
        }

        public void DFS(int r, int c, char[][] grid) {
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length && grid[nr][nc] == '1') {
                    grid[nr][nc] = '0';
                    DFS(nr, nc, grid);
                }
            }
        }
    }
}
