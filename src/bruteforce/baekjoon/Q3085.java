package bruteforce.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q3085 {

    static char[][] arr;
    static int n;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new char[n][n];
        for(int i = 0; i < n; i++) {
            String input = sc.next();
            for(int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
            }
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                swapRow(i, j);
                countRow(i);
                countColumn(j);
                countColumn(j + 1);
                // 원복
                swapRow(i, j);


                swapColumn(i, j);
                countRow(j + 1);
                countRow(j);
                countColumn(i);
                // 원복
                swapColumn(i, j);

            }
        }

        System.out.println(answer);
    }

    public static void swapRow(int i, int j) {
        char tmp = arr[i][j];
        arr[i][j] = arr[i][j + 1];
        arr[i][j + 1] = tmp;
    }

    public static void swapColumn(int i, int j) {
        char tmp = arr[j][i];
        arr[j][i] = arr[j + 1][i];
        arr[j + 1][i] = tmp;
    }

    public static void countRow(int r) {
        int count = 1;
        for(int i = 0; i < n - 1; i++) {
            if(arr[r][i] == arr[r][i + 1]) {
                count++;
            } else {
                count = 1;
            }
            answer = Math.max(answer, count);
        }
    }

    public static void countColumn(int c) {
        int count = 1;
        for(int i = 0; i < n - 1; i++) {
            if(arr[i][c] == arr[i + 1][c]) {
                count++;
            } else {
                count = 1;
            }
            answer = Math.max(answer, count);
        }
    }
}
