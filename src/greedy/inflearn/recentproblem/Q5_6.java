package greedy.inflearn.recentproblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q5_6 {

    public int solution(int n, int[][] trans, int[][] bookings){
        int answer=0;

        int[] sum = new int[n + 1];
        for (int[] tran : trans) {
            int s = tran[0];
            int e = tran[1];
            int p = tran[2];
            sum[s] += p;
            sum[e] -= p;
        }

        for(int i = 1; i <= n; i++) {
            sum[i] += sum[i-1];
        }

        Arrays.sort(bookings, (a, b) -> a[0] - b[0]);

        int j = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {


            while(!list.isEmpty() && list.get(0) == i) {
                if(list.get(0) == i) {
                    answer++;
                    list.remove(0);
                }
            }

            while(j < bookings.length && bookings[j][0] == i) {
                list.add(bookings[j][1]);
                j++;
            }

            Collections.sort(list);

            while(list.size() > sum[i]) {
                list.remove(list.size() - 1);
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
