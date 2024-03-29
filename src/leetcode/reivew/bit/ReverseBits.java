package leetcode.reivew.bit;

public class ReverseBits {
    public int reverseBits(int n) {
        int res = 0;

        for(int i = 0; i < 32; i++) {

            int last = n & 1;
            res = res << 1;
            res |= last;
            n = n >> 1;
        }

        return res;
    }
}
