package twopointer;

import java.util.Scanner;

public class Q1806 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int length = 0;
        int answer = Integer.MAX_VALUE;
        int lt = 0, rt = 0;
        while(lt <= rt && rt < n) {
            if(sum < s) {
                sum += arr[rt++];
                length++;
                if(sum >= s) {
                    answer = Math.min(answer, length);
                    while(sum >= s) {
                        sum -= arr[lt++];
                        length--;
                        if(sum >= s) {
                            answer = Math.min(answer, length);
                        }
                    }
                }
            }
        }

        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);
    }
}

//5 1 3 5 10 7 4 9 2 8
//lt
//        rt
//sum = 24
//
//5 1 3 5 10 7 4 9 2 8
//    lt
//        rt
//sum = 15