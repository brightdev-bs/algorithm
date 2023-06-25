package leetcode.array.reivew.dy;

import java.util.Arrays;

// easy
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] ch = new int[amount + 1];
        Arrays.fill(ch, Integer.MAX_VALUE);
        ch[0] = 0;
        for(int coin : coins) {
            for(int i = coin; i <= amount; i++) {
                if(ch[i - coin] != Integer.MAX_VALUE) {
                    ch[i] = Math.min(ch[i], ch[i - coin] + 1);
                }
            }
        }
        return ch[amount] == Integer.MAX_VALUE ? -1 : ch[amount];
    }
}
