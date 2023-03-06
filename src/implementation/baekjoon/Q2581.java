package implementation.baekjoon;

import java.util.Scanner;

public class Q2581 {

    static int[] ch = new int[10001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        for(int i = 2; i <= 10000; i++) {
            if(ch[i] == 0) {
                ch[i] = 1;
                for(int j = i + i; j <= 10000; j += i) {
                    ch[j] = -1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int sum = 0;
        for(int i = m; i <= n; i++) {
            if(ch[i] == 1) {
                sum += i;
                min = Math.min(min, i);
            }
        }

        if(sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
