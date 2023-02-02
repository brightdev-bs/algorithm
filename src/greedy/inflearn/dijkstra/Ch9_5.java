package greedy.inflearn.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ch9_5 {

    static ArrayList<ArrayList<Edge>> graph;
    static int[] dis;
    static class Edge implements Comparable<Edge>{
        public int vex;
        public int cost;
        Edge(int vex, int cost) {
            this.vex = vex;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge ob){
            return this.cost-ob.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int c = sc.nextInt();
            graph.get(v1).add(new Edge(v2, c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        dis[1] = 0;
        while(!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost > dis[now]) continue;
            for (Edge edge : graph.get(now)) {
                if(dis[edge.vex] > nowCost + edge.cost) {
                    dis[edge.vex] = nowCost + edge.cost;
                    pq.offer(new Edge(edge.vex, nowCost + edge.cost));
                }
            }
        }
    }
}