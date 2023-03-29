package hashing.inflearn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q2_2 {
    public int[] solution(String s){
        int[] answer = new int[5];
        int max = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0) + 1;
            map.put(c, count);
            max = Math.max(max, count);
        }

        for(int i = 0; i < 5; i++) {
            char c = (char) ('a' + i);
            Integer count = map.getOrDefault(c, 0);
            answer[i] = max - count;
        }


        return answer;
    }

    public static void main(String[] args){
        Q2_2 T = new Q2_2();
        System.out.println(Arrays.toString(T.solution("aaabc")));
        System.out.println(Arrays.toString(T.solution("aabb")));
        System.out.println(Arrays.toString(T.solution("abcde")));
        System.out.println(Arrays.toString(T.solution("abcdeabc")));
        System.out.println(Arrays.toString(T.solution("abbccddee")));
    }

}
