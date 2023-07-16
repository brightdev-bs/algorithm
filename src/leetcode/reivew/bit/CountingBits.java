package leetcode.reivew.bit;

public class CountingBits {

    public int[] countBits(int n) {
        int[] nums = new int[n + 1];
        int offset = 1;
        for(int i = 1; i <= n; i++) {
            if(offset * 2 == i) offset *= 2;
            nums[i] = nums[i - offset] + 1;
        }
        return nums;
    }
}
