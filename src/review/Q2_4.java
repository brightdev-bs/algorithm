package review;

import java.util.HashMap;

public class Q2_4 {

    public int solution(int[] nums, int m){
        int answer = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if(map.containsKey(sum - m)) answer += map.get(sum - m);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args){
        Q2_4 T = new Q2_4();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
