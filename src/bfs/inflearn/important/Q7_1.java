package bfs.inflearn.important;

import java.util.LinkedList;
import java.util.Queue;

public class Q7_1 {

    public int solution(int[] nums){
        int n = nums.length;
        int count = -1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(!queue.isEmpty()) {
            count++;
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                int idx = queue.poll();
                if(idx == n - 1) return count;
                for(int j = 1; j <= nums[idx]; j++) {
                    queue.add(idx + j);
                }
            }
        }

        return -1;
    }

    public static void main(String[] args){
        Q7_1 T = new Q7_1();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
