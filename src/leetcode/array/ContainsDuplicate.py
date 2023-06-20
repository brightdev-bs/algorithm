from typing import List


class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        map = {};
        for num in nums:
            if(num in map): return False;
            map.set(num, 1);
        return True;
