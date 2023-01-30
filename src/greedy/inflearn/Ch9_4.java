package greedy.inflearn;

import java.util.*;

public class Ch9_4 {

    static class Schedule implements Comparable<Schedule> {
        int m, d;

        public Schedule(int m, int d) {
            this.m = m;
            this.d = d;
        }

        @Override
        public int compareTo(Schedule o) {
            return o.d - this.d;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int mDay = Integer.MIN_VALUE;
        ArrayList<Schedule> arr = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int m = sc.nextInt();
            int d = sc.nextInt();
            arr.add(new Schedule(m, d));
            mDay = Math.max(mDay, d);
        }

        Collections.sort(arr);

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for(int i = mDay; i >= 1; i--) {
            for(; j < n; j++) {
                if(arr.get(j).d < i) break;
                pq.offer(arr.get(j).m);
            }
            if(!pq.isEmpty()) answer += pq.poll();
        }

        System.out.println(answer);

    }
}

