package leetcode.reivew.array;

public class BestTimeToBuyAndSellStock {

    class Solution {
        public int maxProfit(int[] prices) {
            int min = Integer.MAX_VALUE;
            int max = 0;
            for (int i = 0; i < prices.length; i++) {
                min = Math.min(prices[i], min);
                max = Math.max(max, prices[i] - min);
            }

            return max;
        }
    }
}
