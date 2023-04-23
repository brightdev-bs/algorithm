package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q8_1 {

    public int solution(int n, int[][] flights, int s, int e, int k){
        int answer = 0;

        int[] ch = new int[n];
        Arrays.fill(ch, Integer.MAX_VALUE);
        ArrayList<ArrayList<int[]>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            list.get(flight[0]).add(new int[]{flight[1], flight[2]}); // 시작점, 가중치
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{s, 0});
        ch[s] = 0;
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int[] tmp = queue.poll();
                int now = tmp[0];
                int nowCost = tmp[1];
                for (int[] node : list.get(now)) {
                    int next = node[0];
                    int cost = node[1];
                    if(nowCost + cost < ch[next]) {
                        ch[next] = nowCost + cost;
                        queue.add(new int[]{node[0], node[1] + nowCost});
                    }
                }
            }
            L++;
            if(L > k) break;
        }

        if(ch[e] == Integer.MAX_VALUE) return -1;
        else return ch[e];
    }

    public static void main(String[] args){
        Q8_1 T = new Q8_1();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
    }
}
