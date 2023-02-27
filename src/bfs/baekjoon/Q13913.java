package bfs.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13913 {

    static int n, k;
    static int answer = Integer.MAX_VALUE;

    static int[] ch = new int[1000001];

    static class Trace {
        int n, v;
        String trace;

        public Trace(int n, int v, String trace) {
            this.n = n;
            this.v = v;
            this.trace = trace;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        if(n == k) {
            System.out.println(n - k);
            System.out.println(n);
        } else if(n > k) {
            System.out.println(n - k);
            for(int i = n; i >= k; i--) {
                System.out.print(i + " ");
            }
        } else {
            bfs();
        }

    }

    static void bfs() {
        Queue<Trace> queue = new LinkedList<>();
        queue.add(new Trace(n, 0, String.valueOf(n)));
        ch[n] = 1;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Trace trace = queue.poll();

                if(trace.n == k) {
                    System.out.println(trace.v);
                    System.out.println(trace.trace);
                    return;
                }

                if(trace.v >= answer) continue;

                for(int j = 0; j < 3; j++) {
                    int next;
                    if(j == 0) next = trace.n * 2;
                    else if(j == 1) next = trace.n - 1;
                    else next = trace.n + 1;

                    if(next >= 0 && next <= 100000 && ch[next] == 0) {
                        ch[next] = 1;
                        queue.add(new Trace(next, trace.v + 1, trace.trace + " " + next));
                    }
                }
            }
        }
    }
}
