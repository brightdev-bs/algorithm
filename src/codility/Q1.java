package codility;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution {
    public int solution(String S, int[] C) {
        int answer = 0;

        HashMap<Character, PriorityQueue<Integer>> map = new HashMap<>();
        int n = S.length();
        for (int i = 0; i < n; i++) {
            char c = S.charAt(i);
            map.putIfAbsent(c, new PriorityQueue<>());
            map.get(c).add(C[i]);
        }

        for(int i = 0; i < n - 1; i++) {
            if(S.charAt(i) == S.charAt(i + 1)) {
                Integer v = map.get(S.charAt(i)).poll();
                answer += v;
            }
        }
        return 0;
    }
}