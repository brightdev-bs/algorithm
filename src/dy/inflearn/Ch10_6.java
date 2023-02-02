package dy.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Ch10_6 {

    static class Quiz implements Comparable<Quiz>{
        int score, time;

        public Quiz(int score, int time) {
            this.score = score;
            this.time = time;
        }

        @Override
        public int compareTo(Quiz o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Quiz> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            list.add(new Quiz(s, t));
        }

        Collections.sort(list);
        int[] dy = new int[m + 1];
        for (Quiz quiz : list) {
            for(int i = quiz.time; i <= m; i++) {
                dy[i] = Math.max(dy[i - quiz.time] + quiz.score, dy[i]);
            }
        }

        System.out.println(dy[m]);
    }
}

//시간 기준으로 나열
//6   3
//7   4
//10  5
//15  8
//25  12
//
//
//3   4   5   6   7   8   9   10  11  12  13
//-------------------------------------------
//6   6   6   6   6   6   6   6   6   6   6
//6   7   10  10  13  13  13  13  13  13  13
//6   7   10  10  10  16  17  17  17  17  17
//6   7   10  10  10  16  17  17  17  17  17
//


// j분동안 풀 수 있는 최대 점수
