package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class Q3_4 {

    public int solution(int[] laser, String[] enter){
        int answer = 0;

        int n = enter.length;
        int[][] list = new int[n][2];

        for(int i = 0; i < n; i++) {
            String time = enter[i].split(" ")[0];
            list[i][0] = getTime(Integer.parseInt(time.split(":")[0]), Integer.parseInt(time.split(":")[1]));
            String type = enter[i].split(" ")[1];
            list[i][1] = Integer.parseInt(type);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(list[0][1]);
        int fT = list[0][0];
        int pos = 1;
        for(int t = fT; t <= 1200; t++) {
            if(pos < n && t == list[pos][0]) {
                if(!queue.isEmpty() && t > fT) fT = t;
                queue.offer(list[pos][1]);
                pos++;
            }

            if(t == fT && !queue.isEmpty()) {
                int idx = queue.poll();
                fT += laser[idx];
            }
            answer = Math.max(answer, queue.size());
        }

        return answer;
    }

    public int getTime(int hour, int min) {
        return hour * 60 + min;
    }

    public static void main(String[] args){
        Q3_4 T = new Q3_4();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
