package leetcode.array;

// 다이나믹 프로그래밍 - Kadane's Algorithm을 이용한다.
// 거장 작은 값을 기억하고 있다가 현재 인덱스에서 팔았을 때의 profit을 비교하며 최대 값을 찾으면 된다.
public class BestTimeToBuyAndSellStock {
    class Solution {
        public int maxProfit(int[] prices) {
            int maxi = 0;
            int minimum = prices[0];
            for (int i=0; i< prices.length; i++ ){
                minimum = Math.min(minimum ,prices[i]);
                maxi = Math.max(maxi ,prices[i] - minimum );
            }
            return maxi;
        }
    }
}
