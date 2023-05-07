package leetcode.array;

public class MaximumSubarray {

    // answer[i]는 i번째 수까지 이용해서 부분집합을 만들었을 때 가장 큰 부분 집합의 합

    class Solution {
        public int maxSubArray(int[] nums) {
            int[] answer = new int[nums.length];

            answer[0] = nums[0];
            for(int i = 1; i < nums.length; i++) {
                int a = answer[i - 1] + nums[i];
                answer[i] = Math.max(a, nums[i]);
            }

            int res = Integer.MIN_VALUE;
            for(int x : answer) {
                res = Math.max(x, res);
            }

            return res;
        }
    }
}
