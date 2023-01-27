package dfs.inflearn;

import java.util.Scanner;

// 필수 문제 => 모든 유형 총 집합 되어 있음.
// 1. 조합 경의으 수 구하기
// 2. 수열의 조합 구하기
// 3. 규칙 파악
public class Ch8_8 {

    static int n, m;
    static int[] base, com, ch;
    static boolean flag = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        base = new int[n];
        com = new int[n];
        ch = new int[n + 1];

        // 조합의 수 구하기
        for(int i = 0; i < n; i++) {
            base[i] = combi(n-1, i);
        }

        answer(0);
    }

    public static int combi(int n, int r) {
        if(n == r || r == 0) return 1;
        else return combi(n-1, r-1) + combi(n-1, r);
    }

    public static void answer(int L) {
        if(flag) return;
        if(L == n) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                sum += base[i] * com[i];
            }
            if(sum == m) {
                for (int i : com) {
                    System.out.print(i + " ");
                }
                flag = true;
            }
        } else {
            for(int i = 1; i <= n; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    com[L] = i;
                    answer(L + 1);
                    ch[i] = 0;
                }
            }
        }
    }
}
