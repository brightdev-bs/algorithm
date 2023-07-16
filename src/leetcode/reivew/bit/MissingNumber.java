package leetcode.reivew.bit;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int tmp = 0;
        for(int i = 0; i <= nums.length; i++) {
            tmp ^= i;
        }

        for(int n : nums) {
            tmp ^= n;
        }

        return tmp;
    }
}
