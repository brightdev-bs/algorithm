package implementation.baekjoon;

import java.util.Scanner;

public class Q1978 {

    static int[] ch = new int[1001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 2; i <= 1000; i++) {
            if(ch[i] == 0) {
                ch[i] = 1;
                for(int j = i + i; j <= 1000; j = j + i) {
                    ch[j] = 2;
                }
            }
        }

        int answer = 0;
        for (int i : arr) {
            if(ch[i] == 1) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
