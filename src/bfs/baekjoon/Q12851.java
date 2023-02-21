package bfs.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q12851 {

    static int answer = Integer.MAX_VALUE, count = 0;
    static int[] move = new int[100001];
    static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        if(n == k) {
            System.out.println(n-k);
            System.out.println(1);
            return;
        }

        bfs();

        System.out.println(answer);
        System.out.println(count);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        move[n] = 1;
        while (!queue.isEmpty()) {
            Integer now = queue.poll();

            if(answer < move[now]) return;

            for(int i = 0; i < 3; i++) {
                int next;

                if(i == 0) next = now + 1;
                else if(i == 1) next = now - 1;
                else next = now * 2;

                if(next < 0 || next > 100000) continue;

                if(next == k) {
                    answer = move[now];
                    count++;
                }

                if (move[next] == 0 || move[next] == move[now] + 1) {
                    queue.add(next);
                    move[next] = move[now] + 1;
                }
            }
        }
    }

}




