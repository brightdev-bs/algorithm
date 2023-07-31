package leetcode.reivew.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int answer = 0;
            for(int left = 0, right = 0; right < s.length(); right++) {
                if(!set.contains(s.charAt(right))) {
                    set.add(s.charAt(right));
                    answer = Math.max(answer, right - left +1);
                    System.out.println(answer);
                } else {
                    while(s.charAt(left) != s.charAt(right)) {
                        set.remove(s.charAt(left++));
                    }
                    left++;
                }
            }

            return answer;
        }
    }
}
