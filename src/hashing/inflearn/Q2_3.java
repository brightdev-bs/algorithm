package hashing.inflearn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q2_3 {

    public int solution(String s){
        int answer = 0;

        Map<Character, Integer> stringMap = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            stringMap.put(c, stringMap.getOrDefault(c, 0) + 1);
        }

        for (Integer value : stringMap.values()) {
            if(!set.contains(value)) {
                set.add(value);
            } else {
                while(value > 0 && set.contains(value)) {
                    value--;
                    answer++;
                }
                set.add(value);
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q2_3 T = new Q2_3();
        System.out.println(T.solution("aaabbbcc"));
        System.out.println(T.solution("aaabbc"));
        System.out.println(T.solution("aebbbbc"));
        System.out.println(T.solution("aaabbbcccde"));
        System.out.println(T.solution("aaabbbcccdddeeeeeff"));
    }
}
