package review;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Q5_6 {

    public int solution(int n, int[][] trans, int[][] bookings){
        int answer=0;

        Arrays.sort(bookings, (a, b) -> a[0] - b[0]);

        int[] sum = new int[n + 1];
        for (int[] t : trans) {
            sum[t[0]] += t[2];
            sum[t[1]] -= t[2];
        }

        for(int i = 1; i <= n; i++) {
            sum[i] += sum[i - 1];
        }

        int cur = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {

            while(!queue.isEmpty() && queue.peek() == i) {
                answer++;
                queue.pollFirst();
            }

            while(cur < bookings.length && bookings[cur][0] <= i) {
                queue.add(bookings[cur][1]);
                cur++;
            }

            Collections.sort(queue, (a, b) -> a - b);
            while(queue.size() > sum[i]) {
                queue.pollLast();
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q5_6 T = new Q5_6();
        System.out.println(T.solution(5, new int[][]{{1, 4, 2}, {2, 5, 1}}, new int[][]{{1, 2}, {1, 5}, {2, 3}, {2, 4}, {2, 5}, {2, 5}, {3, 5}, {3, 4}}));
        System.out.println(T.solution(5, new int[][]{{2, 3, 1}, {1, 5, 1}}, new int[][]{{2, 5}, {1, 5}, {1, 3}, {2, 4}, {2, 5}, {2, 3}}));
        System.out.println(T.solution(8, new int[][]{{1, 8, 3}, {3, 8, 1}}, new int[][]{{1, 3}, {5, 8}, {2, 7}, {3, 8}, {2, 7}, {2, 8}, {3, 8}, {6, 8}, {7, 8}, {5, 8}, {2, 5}, {2, 7}, {3, 7}, {3, 8}}));
        System.out.println(T.solution(9, new int[][]{{1, 8, 3}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {5, 8}, {2, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {7, 8}, {5, 8}, {3, 5}, {3, 7}, {4, 7}, {5, 8}}));
        System.out.println(T.solution(9, new int[][]{{2, 7, 2}, {3, 9, 2}, {1, 5, 3}}, new int[][]{{1, 9}, {4, 8}, {2, 9}, {5, 9}, {3, 8}, {2, 9}, {1, 9}, {8, 9}, {3, 9}, {1, 8}, {6, 8}, {3, 6}, {7, 8}, {5, 8}, {3, 5}, {2, 7}, {1, 7}, {2, 8}}));
    }
}
