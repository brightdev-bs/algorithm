package implementation.baekjoon;

import java.util.Scanner;

public class Q14719 {

    static int[] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int w = sc.nextInt();
        graph = new int[w];

        for(int i = 0; i < w; i++) {
            graph[i] = sc.nextInt();
        }

        int sum = 0;
        for(int i = 1; i < w - 1; i++) {

            int lm = Integer.MIN_VALUE;
            int rm = Integer.MIN_VALUE;

            for(int j = 0; j <= i; j++) {
                lm = Math.max(lm, graph[j]);
            }

            for(int j = i; j < w; j++) {
                rm = Math.max(rm, graph[j]);
            }

            sum += Math.min(lm, rm) - graph[i];
        }

        System.out.println(sum);
    }
}
