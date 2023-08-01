package leetcode.reivew.string;

public class PalindromicSubstrings {

    int res;

    public int countSubstrings(String s) {
        for(int i = 0; i < s.length(); i++) {
            check(s, i, i);
            check(s, i, i + 1);
        }

        return res;
    }

    public void check(String s, int L, int R) {
        while(L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            res++;
            L--;
            R++;
        }
    }
}
