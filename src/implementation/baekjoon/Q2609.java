package implementation.baekjoon;

import java.util.Scanner;

public class Q2609 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int copyNum1 = num1;
        int copyNum2 = num2;
        while(num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }

        // 최대 공약수
        System.out.println(num1);

        // 최소 공배수
        System.out.println((copyNum1 / num1) * (copyNum2 / num1) * num1);

    }
}
