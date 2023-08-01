package leetcode.reivew.string;

public class ValidPalindrome {
    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();
            StringBuilder sb = new StringBuilder();
            for(char c : s.toCharArray()) {
                if(Character.isAlphabetic(c) || Character.isDigit(c)) {
                    sb.append(c);
                }
            }

            String res = sb.toString();
            int left = 0, right = res.length() - 1;
            while(left <= right) {
                if(res.charAt(left) == res.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }

            return true;
        }
    }
}
