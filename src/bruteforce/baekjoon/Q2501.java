package bruteforce.baekjoon;

import java.util.Scanner;

public class Q2501 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = 0;
        int count = 0;
        boolean flag = false;
        for(int i = 1; i <= n; i++) {
            if(n % i == 0) count++;
            if(count == k) {
                answer = i;
                flag = true;
            }
            if(flag) break;
        }

        System.out.println(answer);
    }
}
