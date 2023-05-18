package leetcode.dynamic;

public class JumpGame {
    class Solution {
        public boolean canJump(int[] nums) {
            int n = nums.length;

            int boundary = 0;
            for(int i = 0; i <= boundary; i++) {
                boundary = Math.max(boundary, i + nums[i]);
                if(boundary >= n - 1) return true;
            }
            return false;
        }
    }
}
