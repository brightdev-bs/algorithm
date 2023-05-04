package codility;

import java.util.HashMap;
import java.util.Map;

public class Q2 {

    public int solution(String S) {
        // Implement your solution here
        int answer = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        while(true) {
            map.put('B', 1);
            map.put('A', 3);
            map.put('N', 2);
            StringBuilder tmp = new StringBuilder();
            for (char c : S.toCharArray()) {
                if(map.getOrDefault(c, 0) > 0) {
                    map.put(c, map.get(c) - 1);
                } else {
                    tmp.append(c);
                }
            }

            boolean flag = false;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if(entry.getValue() != 0) flag = true;
            }

            if(flag) return answer;
            else if(tmp.length() == 0) return answer;
            else {
                answer++;
                S = tmp.toString();
            }
        }
    }

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        q2.solution("NAABXXAN");
    }
}
