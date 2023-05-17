package leetcode.dynamic;

public class DecodeWays {
    class DFS {

        public int numDecodings(String s) {
            int n = s.length();
            int[] mem = new int[n];
            return s.length() == 0 ? 0 : numDecodings(0, s, mem);
        }

        public int numDecodings(int p, String s, int[] mem) {
            int n = s.length();
            if(p == n) return 1;
            if(s.charAt(p) == '0') return 0;
            if(mem[p] != 0) return mem[p];
            int res = numDecodings(p + 1, s, mem);
            if(p + 1 < n && (s.charAt(p) == '1' || s.charAt(p) == '2' && s.charAt(p + 1) < '7'))
                res += numDecodings(p + 2, s, mem);
            return mem[p] = res;
        }
    }

    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 1;
        for(int i = n - 1; i >= 0; i--) {
            if(s.charAt(i) != '0') {
                dp[i] = dp[i + 1];
                if(i < n - 1 && (s.charAt(i) == '1' || s.charAt(i) == '2' && s.charAt(i + 1) < '7'))
                    dp[i] += dp[i + 2];
            }
        }
        return dp[0];
    }
}
