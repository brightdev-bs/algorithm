package leetcode.binary;

public class SumOfTwoIntegers {

    public int getSum(int a, int b) {
        while(b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) {
        SumOfTwoIntegers m = new SumOfTwoIntegers();
        System.out.println(m.getSum(2, 3));
        System.out.println(m.getSum(1, 3));
    }
}
