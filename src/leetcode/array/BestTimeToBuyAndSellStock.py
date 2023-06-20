from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        maximum = 0;
        minimum = prices[0];

        for price in prices:
            minimum = min(minimum, price)
            maximum = max(maximum, price - minimum)

        return maximum;

