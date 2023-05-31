package leetcode.string;

public class LongestPalindromicSubstring {

    int maxLen = 0;
    int lo = 0;
    public String longestPalindrome(String s) {
        int len = s.length();

        if(len < 2) return s;

        // i를 가운데라고 생각하고 진행한다.
        for(int i = 0; i < len; i++) {
            check(s, i, i);
            check(s, i, i+1);

        }

        return s.substring(lo, lo + maxLen);
    }

    private void check(String s, int L, int R) {
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        if(maxLen < R - L - 1) {
            maxLen = R - L - 1;
            lo = L + 1;
        }
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring m = new LongestPalindromicSubstring();
        System.out.println(m.longestPalindrome("babad"));
        System.out.println(m.longestPalindrome("cbbd"));
    }
}
