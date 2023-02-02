package dy.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Ch10_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] coins = new int[n];
        for(int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        int[] dy = new int[m + 1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for(int i = 0; i < n; i++) {
            for(int j = coins[i]; j <= m; j++) {
                dy[j] = Math.min(dy[j - coins[i]] + 1, dy[j]);
            }
        }

        System.out.println(dy[m]);
    }
}
