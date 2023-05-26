package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    class Solution {
        public int lengthOfLongestSubstring(String s) {
            Set<Character> set = new HashSet<>();
            int answer = 0;

            for(int r = 0, l = 0; r < s.length(); r++) {
                if(!set.contains(s.charAt(r))) {
                    set.add(s.charAt(r));
                    answer = Math.max(answer, r - l + 1);
                }

                else {
                    while(set.contains(s.charAt(r))) {
                        set.remove(s.charAt(l));
                        l++;
                    }

                    set.add(s.charAt(r));
                }
            }

            return answer;
        }
    }
}
