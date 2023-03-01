package dy.baekjoon;

import java.util.Scanner;

public class Q5557 {

    static int N;
    static int[] numbers;
    static long[][] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        numbers = new int[N];
        ch = new long[N + 1][21];
        for(int i = 0; i < N; i++) {
            numbers[i] = sc.nextInt();
        }

        ch[0][numbers[0]] = 1;
        for(int i = 1; i < N - 1; i++) {
            for(int j = 0; j <= 20; j++) {
                if(ch[i - 1][j] != 0) {
                    int idx;
                    for(int k = 0; k < 2; k++) {
                        if(k == 0) idx = j + numbers[i];
                        else idx = j - numbers[i];

                        if(idx >= 0 && idx <= 20) {
                            ch[i][idx] += ch[i - 1][j];
                        }
                    }
                }
            }
        }

        System.out.println(ch[N - 2][numbers[N - 1]]);

    }

}
