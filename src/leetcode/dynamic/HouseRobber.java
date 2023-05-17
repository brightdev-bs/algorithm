package leetcode.dynamic;

public class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for(int i = 2; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i - 1; j++) {
                max = Math.max(max,  dp[j]);
            }

            dp[i] = max + nums[i];
        }

        int answer = 0;
        for(int x : dp) {
            answer = Math.max(answer, x);
        }

        return answer;
    }

    public int rob2(int[] nums) {
        int prev1 = 0;
        int prev2 = 0;

        for(int num : nums) {
            final int max = Math.max(prev1, prev2 + num);
            prev2 = prev1;
            prev1 = max;
        }

        return prev1;
    }
}
