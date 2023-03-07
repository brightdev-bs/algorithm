package greedy.baekjoon.mst;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1197 {

    static class Edge implements Comparable<Edge> {
        int e, value;

        public Edge(int e1, int value) {
            this.e = e1;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return this.value - o.value;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();
        int e = sc.nextInt();

        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for(int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        boolean[] ch = new boolean[v + 1];

        for(int i = 0; i < e; i++) {
            int e1 = sc.nextInt();
            int e2 = sc.nextInt();
            int value = sc.nextInt();
            list.get(e1).add(new Edge(e2, value));
            list.get(e2).add(new Edge(e1, value));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        int answer = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int now = edge.e;
            int nowCost = edge.value;

            if (ch[now]) continue;

            ch[now] = true;
            answer += nowCost;

            for (Edge next : list.get(now)) {
                if (!ch[next.e]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(answer);
    }
}
