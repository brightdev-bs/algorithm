package leetcode.reivew.string;

public class LongestRepeatingCharacterReplacement {
    class Solution {
        public int characterReplacement(String s, int k) {
            int[] mem = new int[26];
            int maxCount = 0, maxLen = 0;
            for(int left = 0, right = 0; right < s.length(); right++) {
                mem[s.charAt(right) - 'A']++;
                maxCount = Math.max(maxCount, mem[s.charAt(right) - 'A']);
                while(right - left + 1 - maxCount > k) {
                    mem[s.charAt(left) - 'A']--;
                    left++;
                }

                maxLen = Math.max(maxLen, right - left + 1);
            }

            return maxLen;
        }
    }
}
