package leetcode.array;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        while(s <= e) {

            final int m = (s + e) / 2;
            if(nums[m] == target) return m;
            if(nums[s] < nums[m]) {
                if(nums[s] <= target && nums[m] >= target) e = m - 1;
                else s = m + 1;
            } else {
                if(nums[e] >= target && nums[m] <= target) s = m + 1;
                else e = m - 1;
            }
        }
        return -1;
    }

}




