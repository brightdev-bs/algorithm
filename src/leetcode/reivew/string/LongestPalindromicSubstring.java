package leetcode.reivew.string;

public class LongestPalindromicSubstring {

    int maxLen = Integer.MIN_VALUE;
    String answer = "";
    public String longestPalindrome(String s) {

        for(int i = 0; i < s.length(); i++) {
            // 홀수인 경우
            check(s, i, i);

            // 짝수인 경우
            check(s, i, i+1);
        }

        return answer;
    }

    public void check(String s, int L, int R) {

        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }

        if(maxLen < R - L + 1) {
            maxLen = R - L + 1;
            answer = s.substring(L + 1, R);
        }

    }
}
