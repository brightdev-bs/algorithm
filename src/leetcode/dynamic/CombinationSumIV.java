package leetcode.dynamic;

public class CombinationSumIV {
    class Solution {

        public int combinationSum4(int[] nums, int target) {
            int[] ch = new int[target + 1];

            ch[0] = 1;
            for(int i = 1; i <= target; i++) {
                for(int num : nums) {
                    if(i >= num) ch[i] += ch[i - num];

                }
            }

            return ch[target];
        }
    }
}
