package dfs.inflearn;

import java.util.Scanner;

public class Ch8_3 {

    static int n, m, answer = Integer.MIN_VALUE;
    static Question[] arr;

    public static class Question {
        int score, time;

        public Question(int score, int time) {
            this.score = score;
            this.time = time;
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 문제 개수
        m = sc.nextInt(); // 제한 시간

        arr = new Question[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            arr[i] = new Question(s, t);
        }

        DFS(0, 0, 0);
        System.out.println(answer);
    }

    public static void DFS(int L, int sum, int time) {
        if(time > m) return;
        if(L == n) {
            answer = Math.max(answer, sum);
        } else {
            DFS(L + 1, sum + arr[L].score, time + arr[L].time);
            DFS(L + 1, sum, time);
        }
    }
}
