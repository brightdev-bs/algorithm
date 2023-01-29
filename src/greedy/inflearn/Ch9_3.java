package greedy.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch9_3 {

    static class Schedule implements Comparable<Schedule> {
        int time;
        char state;

        public Schedule(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Schedule o) {
            if(this.time == o.time) return this.state - o.state;
            else return this.time - o.time;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Schedule> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Schedule(a, 's'));
            arr.add(new Schedule(d, 'e'));
        }

        int answer = Integer.MIN_VALUE;
        Collections.sort(arr);
        int cnt = 0;
        for (Schedule schedule : arr) {
            if(schedule.state == 's') cnt++;
            else cnt--;
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }
}
