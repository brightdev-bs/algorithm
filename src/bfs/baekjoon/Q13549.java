package bfs.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q13549 {

    static int n, k;
    static int answer = Integer.MAX_VALUE;

    static int[] ch = new int[1000001];

    static class Node implements Comparable<Node> {
        int now, value;

        public Node(int now, int value) {
            this.now = now;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        bfs();

        System.out.println(answer);
    }

    public static void bfs() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 0));
        ch[n] = 1;
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            int now = poll.now;
            int value = poll.value;

            if(now == k) {
                answer = Math.min(answer, value);
            }

            int next = -1;
            int nextValue = -1;
            for(int i = 0; i < 3; i++) {
                if(i == 0) {
                    next = now + 1;
                    nextValue = value + 1;
                }
                if(i == 1) {
                    next = now - 1;
                    nextValue = value + 1;
                }
                if(i == 2) {
                    next = now * 2;
                    nextValue = value;
                }

                if(next <= 100000 && next >= 0 && ch[next] == 0) {
                    ch[now] = 1;
                    queue.add(new Node(next, nextValue));
                }
            }
        }
    }

}
