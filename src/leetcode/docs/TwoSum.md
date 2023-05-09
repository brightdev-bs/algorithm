# TwoSum
## Problem
https://leetcode.com/problems/two-sum/

## Solve
### Brute force
Time Complexity : O(n^2)
Space Complexity : O(1)
~~~java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) return new int[]{i, j};
            }
        }
        return null;
    }
}
~~~

### Optimized
Time Complexity : O(n)
Space Complexity : O(n)
~~~java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numToIndex.containsKey(target - nums[i])) {
                return new int[]{numToIndex.get(target - nums[i]), i};
            }
            numToIndex.put(nums[i], i);
        }
        return new int[]{};
    }
}
~~~



