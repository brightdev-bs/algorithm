package leetcode.array;

public class MaximumProductSubarray {

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[][] mem = new int[n][2]; // 0 : max, 1 : min

        int min = nums[0];
        int max = nums[0];
        int answer = max;

        for(int i = 1; i < n; i++) {
            int tempMax = Math.max(max * nums[i], Math.max(min * nums[i], nums[i]));
            min = Math.min(max * nums[i], Math.min(min * nums[i], nums[i]));
            max = tempMax;
            answer = Math.max(answer, max);
        }

        return answer;
    }
}
