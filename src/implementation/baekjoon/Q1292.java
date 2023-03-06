package implementation.baekjoon;

import java.util.Scanner;

public class Q1292 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] ch = new int[1001];
        getNumbers(ch);

        int sum = 0;
        for(int i = a; i <= b; i++) {
            sum += ch[i];
        }

        System.out.println(sum);
    }

    private static void getNumbers(int[] ch) {
        int idx = 1;
        for(int i = 1; i <= 400; i++) {
            for(int j = 1; j <= i; j++) {
                ch[idx++] = i;
                if(idx == 1001) return;
            }
        }
    }
}
