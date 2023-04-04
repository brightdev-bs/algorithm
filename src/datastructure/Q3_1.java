package datastructure;

import java.util.Set;
import java.util.TreeSet;

public class Q3_1 {

    public int solution(int[] nums){
        int answer = 0;
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
        }

        for (Integer x : set) {
            if(set.contains(x - 1)) continue;
            int cnt = 0;
            while(set.contains(x)) {
                cnt++;
                x++;
            }
            answer = Math.max(cnt, answer);
        }


        return answer;
    }

    public static void main(String[] args){
        Q3_1 T = new Q3_1();
        System.out.println(T.solution(new int[]{8, 1, 9, 3, 10, 2, 4, 0, 2, 3}));
        System.out.println(T.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 0, 0, 0, 0}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3, 3, 3, 3}));
        System.out.println(T.solution(new int[]{-3, -1, -2, 0, 3, 3, 5, 6, 2, 2, 1, 1}));
        System.out.println(T.solution(new int[]{-5, -3, -1, -4, 3, 3, 5, 6, 2, 2, 1, 1, 7}));
    }
}