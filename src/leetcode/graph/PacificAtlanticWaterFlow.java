package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] pacific = new int[m][n];
        int[][] atlantic = new int[m][n];

        for(int i = 0; i < m; i++) {
            DFS(i, 0, pacific, heights);
            DFS(i, n - 1, atlantic, heights);
        }

        for(int j = 0; j < n; j++) {
            DFS(0, j, pacific, heights);
            DFS(m - 1, j, atlantic, heights);
        }

        List<List<Integer>> answer = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    answer.add(List.of(i, j));
                }

            }
        }

        return answer;
    }

    public void DFS(int r, int c, int[][] mem, int[][] heights) {

        mem[r][c] = 1;

        for(int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length
                    && heights[r][c] <= heights[nr][nc] && mem[nr][nc] == 0) {
                DFS(nr, nc, mem, heights);
            }
        }
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow m = new PacificAtlanticWaterFlow();
//        System.out.println(m.pacificAtlantic(new int[][]{{1, 1}, {1, 1}, {1, 1}}));
        System.out.println(m.pacificAtlantic(new int[][]{{10, 10, 10}, {10, 1, 10}, {10, 10, 10}}));
    }
}
