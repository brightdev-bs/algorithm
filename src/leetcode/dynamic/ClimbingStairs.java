package leetcode.dynamic;

public class ClimbingStairs {

    class Solution {
        public int climbStairs(int n) {
            int[] ch = new int[46];
            ch[1] = 1;
            ch[2] = 2;
            for(int i = 3; i <= n; i++) {
                ch[i] = ch[i-1] + ch[i - 2];
            }

            return ch[n];
        }
    }
}
