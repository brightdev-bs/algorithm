package leetcode.dynamic;

public class UniquePaths {
    class Solution {
        public int uniquePaths(int m, int n) {
            int[][] grid = new int[m][n];
            int[][] dp = new int[m][n];
            dp[0][0] = 1;

            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(j - 1 >= 0 && j < n)
                        dp[i][j] += dp[i][j - 1];

                    if(i - 1 >= 0 && i < m)
                        dp[i][j] += dp[i - 1][j];
                }
            }

            return dp[m - 1][n - 1];
        }
    }
}
