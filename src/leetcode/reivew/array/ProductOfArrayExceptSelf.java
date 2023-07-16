package leetcode.reivew.array;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        for(int i = 0, tmp = 1; i < n; i++) {
            answer[i] = tmp;
            tmp *= nums[i];
        }

        for(int i = n - 1, tmp = 1; i >= 0; i--) {
            answer[i] *= tmp;
            tmp *= nums[i];
        }
        return answer;
    }
}
