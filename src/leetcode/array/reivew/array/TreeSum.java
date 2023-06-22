package leetcode.array.reivew.array;

import java.util.*;

public class TreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            int n = nums.length;
            Set<List<Integer>> set = new HashSet<>();
            for(int i = 0; i < n - 2; i++) {

                int j = i + 1;
                int k = n - 1;

                while(j < k) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(sum == 0) {
                        set.add(List.of(nums[i], nums[j], nums[k]));

                        while(j < n - 1 && nums[j] == nums[j + 1]) j++;
                        while(k < n - 1 && nums[k] == nums[k + 1]) k--;

                        j++;
                        k--;
                    } else if(sum < 0) {
                        j++;
                    } else {
                        k--;
                    }
                }
            }

            List<List<Integer>> result = new ArrayList<>();
            for(List<Integer> s : set) {
                result.add(s);
            }

            return result;
        }
    }
}
