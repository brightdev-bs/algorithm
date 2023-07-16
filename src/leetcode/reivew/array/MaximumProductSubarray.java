package leetcode.reivew.array;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int tmp = 1;
        for(int n : nums) {
            tmp *= n;
            max = Math.max(tmp, max);
            if(tmp == 0) tmp = 1;
        }

        tmp = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            tmp *= nums[i];
            max = Math.max(tmp, max);
            if(tmp == 0) tmp = 1;
        }
        return max;
    }
}
