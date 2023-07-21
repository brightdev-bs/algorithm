package leetcode.reivew.matrix;

import java.util.LinkedList;
import java.util.Queue;

public class SetMatrixZeroes {
    class Solution {
        private final int DIRECTION = 4;
        private final int[] dr = {-1, 0, 0, 1};
        private final int[] dc = {0, -1, 1, 0};

        public void setZeroes(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;

            Queue<int[]> queue = new LinkedList<>();
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(matrix[i][j] == 0) {
                        queue.add(new int[]{i, j});
                    }
                }
            }

            while(!queue.isEmpty()) {
                int[] pos = queue.poll();
                for(int i = 0; i < DIRECTION; i++) {
                    int j = 0;
                    int nr = pos[0] + dr[i];
                    int nc = pos[1] + dc[i];
                    while(nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        matrix[nr][nc] = 0;
                        nr += dr[i];
                        nc += dc[i];
                    }
                }
            }
        }
    }
}
