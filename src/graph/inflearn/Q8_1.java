package graph.inflearn;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Q8_1 {

    static class Path implements Comparable<Path>{
        int end, cost, t;

        public Path(int end, int cost, int t) {
            this.end = end;
            this.cost = cost;
            this.t = t;
        }

        @Override
        public int compareTo(Path p) {
            return this.cost - p.cost;
        }
    }

    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;

        ArrayList<ArrayList<Path>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int start = flight[0];
            int end = flight[1];
            int cost = flight[2];
            list.get(start).add(new Path(end, cost, 0));
        }

        PriorityQueue<Path> pq = new PriorityQueue<>();
        for (Path path : list.get(s)) {
            pq.add(path);
        }

        while(!pq.isEmpty()) {
            Path cur = pq.poll();
            if(cur.t <= k && cur.end == e) {
                answer = cur.cost;
                break;
            }
            for (Path path : list.get(cur.end)) {
                pq.add(new Path(path.end, path.cost + cur.cost, cur.t + 1));
            }
        }

        return answer == 0 ? -1 : answer;
    }

    public static void main(String[] args){
        Q8_1 T = new Q8_1();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
    }
}
