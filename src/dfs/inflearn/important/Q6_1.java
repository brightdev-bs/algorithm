package dfs.inflearn.important;

import java.util.ArrayList;
import java.util.List;

public class Q6_1 {

    static int ch[];
    static int maxValue = Integer.MAX_VALUE;

    public int solution(int n){

        int o = n;
        List<Integer> list = new ArrayList<>();
        while(n > 0) {
            list.add(n % 10);
            n /= 10;
        }

        ch = new int[list.size()];

        DFS(list, 0, "", o);
        int answer = this.maxValue;
        maxValue = Integer.MAX_VALUE;
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public int DFS(List<Integer> list, int n, String s, int original) {
        int answer = -1;
        if(n == list.size()) {
            int currentNum = Integer.parseInt(s);
            if(currentNum > original) maxValue = Math.min(maxValue, currentNum);
        } else {
            for(int i = 0; i < list.size(); i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    DFS(list, n + 1, s + list.get(i), original);
                    ch[i] = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q6_1 T = new Q6_1();
        System.out.println(T.solution(123));
        System.out.println(T.solution(321));
        System.out.println(T.solution(20573));
        System.out.println(T.solution(27711));
        System.out.println(T.solution(54312));
    }
}
