package leetcode.reivew.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow2 {
    final int[] dr = { -1, 0, 0, 1}, dc = {0, -1, 1, 0};
    final int DIRECTION = 4;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        System.out.println(m + " : " + n);
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            DFS(heights, pacific, i, 0);
            DFS(heights, atlantic, i, n - 1);
        }

        for(int i = 0; i < n; i++) {
            DFS(heights, pacific, 0, i);
            DFS(heights, atlantic, m - 1, i);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) answer.add(List.of(i, j));
            }
        }

        return answer;
    }

    public void DFS(int[][] heights, boolean[][] mem, int r, int c) {

        mem[r][c] = true;

        for(int i = 0; i < DIRECTION; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !mem[nr][nc]) {
                if(heights[r][c] <= heights[nr][nc])
                    DFS(heights, mem, nr, nc);
            }
        }
    }
}
