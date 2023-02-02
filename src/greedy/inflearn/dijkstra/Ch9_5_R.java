package greedy.inflearn.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ch9_5_R {

    static class Edge implements Comparable<Edge> {
        int e, v;

        public Edge(int e, int v) {
            this.e = e;
            this.v = v;
        }

        @Override
        public int compareTo(Edge o) {
            return this.v - o.v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Edge(b, c));
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        dis[1] = 0;
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.e;
            int nowCost = tmp.v;
            if(dis[now] < nowCost) continue;
            for (Edge edge : list.get(now)) {
                if(dis[edge.e] > edge.v + dis[now]) dis[edge.e] = edge.v + dis[now];
                pq.add(edge);
            }
        }

        for (int di : dis) {
            System.out.println(di);
        }

    }
}
