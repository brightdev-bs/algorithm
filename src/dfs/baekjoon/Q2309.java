package dfs.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Q2309 {

    static int[] ch = new int[9];
    static int[] arr = new int[9];
    static int[] answer = new int[7];
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);
        DFS(0);
    }

    public static void DFS(int L) {
        if(flag) return;
        if(L == 7) {
            int sum = 0;
            for(int i = 0; i < 9; i++) {
                if(ch[i] == 1) {
                    sum += arr[i];
                }
            }

            if(sum == 100) {
                flag = true;
                for (int i1 : answer) {
                    System.out.println(i1);
                }
            }
        } else {
            for(int i = 0; i < 9; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    answer[L] = arr[i];
                    DFS(L + 1);
                    ch[i] = 0;
                }

            }
        }
    }
}
