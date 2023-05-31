package leetcode.string;

public class PalindromicSubstrings {

    int res = 0;

    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++) {
            count(s, i, i);
            count(s, i, i + 1);
        }
        return res;
    }

    public void count(String s, int L, int R) {
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            res++;
            L--;
            R++;
        }
    }
}
