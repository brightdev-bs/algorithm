package leetcode.string;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int maxCount = 0, maxLen = 0;
        int start = 0;
        for(int end = 0; end < s.length(); end++) {
            arr[s.charAt(end) - 'A']++;
            maxCount = Math.max(maxCount, arr[s.charAt(end) - 'A']);
            if(end - start + 1 - maxCount > k) {
                arr[s.charAt(start) - 'A']--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start + 1);
        }

        return maxLen;
    }

}
