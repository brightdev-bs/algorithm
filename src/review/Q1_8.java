package review;

import java.util.Arrays;

public class Q1_8 {

    public int[] solution(int[] enter, int[] exit){

        int n = enter.length;
        for(int i = 0; i < n; i++) {
            enter[i] = enter[i] - 1;
            exit[i] = exit[i] - 1;
        }

        int[] enterIdx = new int[n];
        for(int i = 0; i < n; i++) {
            enterIdx[enter[i]] = i;
        }

        int[] in = new int[n];
        int[] out = new int[n];
        int t = 0;
        for(int i = 0, j = 0; i < n; i++) {
            while(j < n && j <= enterIdx[exit[i]]) {
                in[enter[j++]] = t++;
            }
            out[exit[i]] = t++;

        }

        int[] answer = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(!(in[i] > out[j] || in[j] > out[i])) {
                    answer[i]++;
                    answer[j]++;
                }
            }
        }

//        System.out.println(Arrays.toString(in));
//        System.out.println(Arrays.toString(out));

        return answer;
    }

    public int getIndex(int index, int[] enter) {
        for(int i = 0; i < enter.length; i++) {
            if(enter[i] == index) return i;
        }
        return -1;
    }

    public static void main(String[] args){
        Q1_8 T = new Q1_8();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 2, 5, 3, 4}, new int[]{2, 3, 1, 4, 5})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 3, 2, 4, 5, 7, 6, 8}, new int[]{2, 3, 5, 6, 1, 4, 8, 7})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 7, 2, 3, 5, 6}, new int[]{5, 2, 6, 1, 7, 3, 4})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 4, 2, 3}, new int[]{2, 1, 4, 3})));
    }
}
