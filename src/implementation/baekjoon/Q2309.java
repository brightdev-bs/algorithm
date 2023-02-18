package implementation.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {
    static boolean[] ch = new boolean[9];

    static int sum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[9];
        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        ch(arr);

        for(int i = 0; i < 9; i++) {
            if(!ch[i]) {
                System.out.println(arr[i]);
            }
        }

    }

    public static void ch(int[] arr) {
        for(int i = 0; i < 9; i++) {
            for(int j = i + 1; j < 9; j++) {
                int a = arr[i];
                int b = arr[j];
                if(sum - a - b == 100) {
                    ch[i] = true;
                    ch[j] = true;
                    return;
                }
            }
        }
    }
}
