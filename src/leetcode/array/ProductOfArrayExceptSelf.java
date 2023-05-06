package leetcode.array;

public class ProductOfArrayExceptSelf {
    class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] answer = new int[nums.length];
            for(int i = 0, tmp = 1; i < nums.length; i++) {
                answer[i] = tmp;
                tmp *= nums[i];
            }

            for(int i = nums.length - 1, tmp = 1; i >= 0; i--) {
                answer[i] *= tmp;
                tmp *= nums[i];
            }
            return answer;
        }
    }
}
