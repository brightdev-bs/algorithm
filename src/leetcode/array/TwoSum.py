from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        map = {};
        n = len(nums)

        for i in range(n):
            complement = target - nums[i];
            if complement in map:
                return [map[complement], i]
            map[nums[i]] = i;

        return [];