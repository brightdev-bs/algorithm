package leetcode.array.reivew.dy;

public class HouseNumberII {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        if(n == 1) return nums[0];
        int result = help(nums, 0, n - 2);
        int result2 = help(nums, 1, n - 1);
        return Math.max(result, result2);
    }


    private int help(int[] nums, int l, int r) {
        int prev1 = 0;
        int prev2 = 0;
        for(int i = l; i <= r; i++) {
            final int dp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = dp;
        }

        return prev1;
    }
}
