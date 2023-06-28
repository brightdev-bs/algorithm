package leetcode.array.reivew.dy;

// path
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i >= 0 && i < m && j >= 0 && j < n) {
                    if(i >= 1) grid[i][j] += grid[i - 1][j];
                    if(j >= 1) grid[i][j] += grid[i][j - 1];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
