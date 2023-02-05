package dfs.baekjoon;

import java.util.Scanner;

public class Q14888 {

    static int[] operators, combi, arr;
    static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        operators = new int[4];
        combi = new int[n - 1];
        for(int i = 0; i < 4; i++) {
            operators[i] = sc.nextInt();
        }

        getCombi(0);
        System.out.println(max);
        System.out.println(min);

    }

    public static void getCombi(int L) {
        if(L == n - 1) {
            int sum = arr[0];
            for(int i = 0; i < n - 1; i++) {
                switch(combi[i]){
                    case 0:
                        sum += arr[i + 1];
                        break;
                    case 1:
                        sum -= arr[i + 1];
                        break;
                    case 2:
                        sum *= arr[i + 1];
                        break;
                    case 3:
                        sum /= arr[i + 1];
                        break;
                }
            }

            max = Math.max(sum, max);
            min = Math.min(sum, min);

        } else {
            for(int i = 0; i < 4; i++) {
                if(operators[i] > 0) {
                    operators[i]--;
                    combi[L] = i;
                    getCombi(L + 1);
                    operators[i]++;
                }
            }
        }
    }
}
