package greedy.baekjoon.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1916 {

    static class Destination implements Comparable<Destination> {
        int d, v;

        public Destination(int d, int v) {
            this.d = d;
            this.v = v;
        }

        @Override
        public int compareTo(Destination o) {
            return this.v - o.v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시의 개수
        int m = sc.nextInt(); // 버스의 개수

        int[] ch = new int[n + 1];
        Arrays.fill(ch, Integer.MAX_VALUE);
        ArrayList<ArrayList<Destination>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int v = sc.nextInt();
            list.get(a).add(new Destination(b, v));
        }

        int s = sc.nextInt();
        int d = sc.nextInt();

        PriorityQueue<Destination> pq = new PriorityQueue<>();
        pq.add(new Destination(s, 0));
        ch[s] = 0;
        while(!pq.isEmpty()) {
            Destination poll = pq.poll();
            int now = poll.d;
            int nowCost = poll.v;

            if(nowCost > ch[now]) continue;

            for (Destination next : list.get(now)) {
                if(ch[next.d] > next.v + nowCost) {
                    ch[next.d] = next.v + nowCost;
                    pq.add(new Destination(next.d, next.v + nowCost));
                }
            }
        }

        System.out.println(ch[d]);
    }
}
