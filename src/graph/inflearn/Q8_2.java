package graph.inflearn;

import java.util.*;

public class Q8_2 {

    public int solution(int[][] routes, int s, int e){
        int answer = 0;

        int[] ch = new int[1001];

        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int j = 0; j < routes[i].length; j++) {
                int current = routes[i][j];
                map.putIfAbsent(current, new HashSet<>());
                map.get(current).add(i);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Integer current = queue.poll();
                if(ch[current] == 0) {
                    for (Integer line : map.get(current)) {
                        for(int j = 0; j < routes[line].length; j++) {
                            if(routes[line][j] == e) return L;
                            queue.add(routes[line][j]);
                        }
                        ch[current] = 1;
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args){
        Q8_2 T = new Q8_2();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
