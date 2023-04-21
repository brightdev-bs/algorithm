package review;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_3 {

    int[][] ch;

    public int solution(int s, int e){
        int answer = 0;

        ch = new int[2][200001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        ch[0][s] = 1;
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            L++;
            for(int i = 0; i < len; i++) {
                int x = queue.poll();
                for (int nx : new int[]{x - 1, x + 1, x * 2}) {
                    if(nx >= 0 && nx <= 200000 && ch[L % 2][nx] == 0) {
                        ch[L % 2][nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            e = e + L;
            if(e > 200000) return -1;
            if(ch[L % 2][e] == 1) return L;
        }
        return answer;
    }

    public static void main(String[] args){
        Q7_3 T = new Q7_3();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
