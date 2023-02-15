package implementation.baekjoon;

import java.util.Scanner;

public class Q10870 {

    static int[] ch = new int[21];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ch[1] = 1;

        for(int i = 2; i <= n; i++) {
            ch[i] = ch[i - 1] + ch[i - 2];
        }

        System.out.println(ch[n]);
    }
}
