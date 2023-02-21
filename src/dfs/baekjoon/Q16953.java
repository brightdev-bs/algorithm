package dfs.baekjoon;

import java.util.Scanner;

public class Q16953 {

    static long a, b;
    static long answer = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();

        DFS(a, 1);
        if(answer == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(answer);
    }

    public static void DFS(long num, int count) {
        if(count >= answer) return;

        if(num > b) return;

        if(num == b) {
            answer = Math.min(answer, count);
        }

        else {
            DFS(num * 2, count + 1);
            DFS((num * 10) + 1, count + 1);
        }

    }
}
