package leetcode.array;

import java.util.*;

public class ThreeSum {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        Set<List<Integer>> set = new HashSet<>();
        int sum = 0;
        for(int i = 0; i < n - 2; i++) {
            int s = i + 1;
            int e = n - 1;
            while(s < e) {
                sum = nums[i] + nums[s] + nums[e];
                if(sum == 0) {
                    set.add(List.of(nums[i],nums[s++],nums[e--]));
                }
                else if(sum > 0) e--;
                else s++;
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        System.out.println(sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        sum.threeSum(new int[]{0, 1, 1});
        sum.threeSum(new int[]{0, 0, 0});
    }
}
