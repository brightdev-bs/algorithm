package leetcode.reivew.dy;

// easy
public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] dy = new int[n + 1];
        if(n == 1) return 1;
        if(n == 2) return 2;

        dy[1] = 1;
        dy[2] = 2;

        for(int i = 3; i <= n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        return dy[n];
    }
}
