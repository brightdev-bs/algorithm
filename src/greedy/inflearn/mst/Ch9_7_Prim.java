package greedy.inflearn.mst;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Ch9_7_Prim {

    static int[] ch;

    static class Edge implements Comparable<Edge> {
        int v, c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ch = new int[n + 1];
        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.get(a).add(new Edge(b, c));
            list.get(b).add(new Edge(a, c));
        }

        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));
        while(!pq.isEmpty()) {
            Edge ob = pq.poll();
            if(ch[ob.v] == 0) {
                ch[ob.v] = 1;
                answer += ob.c;
                for (Edge edge : list.get(ob.v)) {
                    if(ch[edge.v] == 0) pq.offer(new Edge(edge.v, edge.c));
                }
            }
        }

        System.out.println(answer);
    }
}
