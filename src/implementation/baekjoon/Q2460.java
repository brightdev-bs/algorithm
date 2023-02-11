package implementation.baekjoon;

import java.util.Scanner;

public class Q2460 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] arr = new int[10][2];
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for(int i = 0; i < 10; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            cur -= a;
            cur += b;
            max = Math.max(max, cur);
        }


        System.out.println(max);
    }
}
