package greedy.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Ch9_2 {

    static class Meeting implements Comparable<Meeting> {
        int s, e;

        public Meeting(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Meeting o) {
            if(this.e == o.e) return this.s - o.s;
            else return this.e - o.e;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Meeting[] meetings = new Meeting[n];
        for(int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            meetings[i] = new Meeting(s, e);
        }

        Arrays.sort(meetings);
        int ps = 0;
        int answer = 0;
        for(int i = 0; i < n; i++) {
            Meeting tmp = meetings[i];
            if(tmp.s >= ps) {
                answer++;
                ps = tmp.e;
            }
        }
        System.out.println(answer);
    }
}
