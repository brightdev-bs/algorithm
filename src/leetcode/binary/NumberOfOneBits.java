package leetcode.binary;

public class NumberOfOneBits {
    public class Solution {
        // you need to treat n as an unsigned value
        public int hammingWeight(int n) {
            int count = 0;
            while(n != 0) {
                int lastBit = n & 1;
                count += lastBit;
                n = n >>> 1;
            }
            return count;
        }
    }
}
