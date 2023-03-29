package hashing.inflearn;

import java.util.HashMap;

public class Q2_4 {
    public int solution(int[] nums, int m){
        int answer = 0;

        int sum = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        for(int i = 0 ; i < nums.length; i++) {
            sum += nums[i];
            if(sumMap.containsKey(sum - m)) answer += sumMap.get(sum - m);
            sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);

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
