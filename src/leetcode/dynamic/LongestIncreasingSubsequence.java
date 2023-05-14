package leetcode.dynamic;

public class LongestIncreasingSubsequence {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            int[] dy = new int[n];
            dy[0] = 1;
            for(int i = 0; i < n; i++) {
                for(int j = i - 1; j >= 0; j--) {
                    if(nums[i] > nums[j]) {
                        dy[i] = Math.max(dy[i], dy[j] + 1);
                    } else {
                        dy[i] = Math.max(1, dy[i]);
                    }
                }
            }

            int answer = Integer.MIN_VALUE;
            for(int x : dy) {
                answer = Math.max(answer, x);
            }

            return answer;
        }
    }
}
