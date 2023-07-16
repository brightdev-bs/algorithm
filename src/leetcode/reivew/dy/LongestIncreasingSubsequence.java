package leetcode.reivew.dy;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubsequence {

    // dp O(n^2)
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, 1);
        for(int i = 1; i < nums.length; i++) {

            for(int j = 0; j <= i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = Integer.MIN_VALUE;
        for(int n : dp) {
            res = Math.max(n, res);
        }

        return res;
    }

    // Greedy with Binary Search O(n log n)
    public int lengthOfLIS2(int[] nums) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(res.isEmpty() || nums[i] > res.get(res.size() - 1)) {
                res.add(nums[i]);
            } else {
                searchRightPlace(res, nums[i]);
            }
        }

        return res.size();
    }

    private void searchRightPlace(ArrayList<Integer> res, int num) {
        int l = 0;
        int r = res.size() - 1;
        while(l < r) {
            int mid =  (l + r) / 2;
            if (num > res.get(mid)) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        res.set(l, num);
    }
}
