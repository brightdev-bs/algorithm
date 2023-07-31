package leetcode.reivew.string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubString {

    class Solution {
        public String minWindow(String s, String t) {
            if(s == null || t == null) return "";
            Map<Character, Integer> needMap = new HashMap<>();
            Map<Character, Integer> haveMap = new HashMap<>();

            for(char c : t.toCharArray()) {
                needMap.put(c, needMap.getOrDefault(c, 0) + 1);
            }

            int minLen = Integer.MAX_VALUE;
            int count = needMap.size();
            String answer = "";
            for(int start = 0, end = 0; end < s.length(); end++) {
                char ch = s.charAt(end);
                haveMap.put(ch, haveMap.getOrDefault(ch, 0) + 1);

                if(needMap.containsKey(ch) && haveMap.get(ch).equals(needMap.get(ch))) count--;

                while(count == 0) {
                    if(minLen > end - start + 1) {
                        minLen = end - start + 1;
                        answer = s.substring(start, end + 1);
                    }
                    char toRemove = s.charAt(start);
                    haveMap.put(toRemove, haveMap.get(toRemove) - 1);
                    start++;
                    if(needMap.containsKey(toRemove) && haveMap.get(toRemove) < needMap.get(toRemove)) count++;
                }

            }

            return answer;
        }
    }
}
