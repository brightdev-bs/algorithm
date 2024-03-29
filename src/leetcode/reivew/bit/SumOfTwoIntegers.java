package leetcode.reivew.bit;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while(b != 0) {
            int c = (a & b) << 1;
            a = a ^ b;
            b = c;
        }

        return a ^ b;
    }
}
