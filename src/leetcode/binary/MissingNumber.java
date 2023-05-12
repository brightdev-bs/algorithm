package leetcode.binary;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i <= 10000; i++) {
            if(nums.length <= i || nums[i] != i) return i;
        }

        return -1;
    }

    // 등차수열 합 공식 이용
    public int missingNumber2(int[] nums) {
        int n = nums.length;
        int res = (n * (n + 1)) / 2;
        int sum = 0;
        for(int x : nums) {
            sum += x;
        }
        return res - sum;
    }
}
