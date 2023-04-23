package review;

import java.util.*;

public class Q8_2 {

    public int solution(int[][] routes, int s, int e){
        int answer = 0;

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int i = 0; i < routes.length; i++) {
            for(int x : routes[i]) {
                map.putIfAbsent(x, new HashSet<>());
                map.get(x).add(i);
            }
        }

        int[] ch = new int[1000001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s); // 시작점, 환승 횟수
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int tmp = queue.poll();
                for (Integer line : map.get(tmp)) {
                    if(ch[line] == 0) {
                        ch[line] = 1;
                        for (int nowStop : routes[line]) {
                            if(e == nowStop) return L;
                            queue.add(nowStop);
                        }
                    }
                }
            }
            L++;
        }

        return answer;
    }

    public static void main(String[] args){
        Q8_2 T = new Q8_2();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12},{5, 19},{7, 19},{9, 12, 13},{9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5},{9, 7, 10},{7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }

}
