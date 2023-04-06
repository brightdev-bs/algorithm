package sort.inflearn;

import java.util.Arrays;
// 조금 더 다듬을 수 있음.
public class Q4_4 {

    public int solution(int[] score, int k){
        int answer = Integer.MAX_VALUE;
        int n = score.length;

        Arrays.sort(score);

        int[] temp = new int[k];
        for(int i = 0; i < k; i++) {
            temp[i] = score[i];
        }

        for(int i = k; i < n; i++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int sum = 0;
            for (int j = 0; j < k; j++) {
                max = Math.max(temp[j], max);
                min = Math.min(temp[j], min);
                sum += temp[j];
            }

            if(max - min <= 10) answer = Math.min(answer, sum);
            temp[i % k] = score[i];
        }

        return answer / k;
    }

    public static void main(String[] args){
        Q4_4 T = new Q4_4();
        System.out.println(T.solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3));
        System.out.println(T.solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4));
        System.out.println(T.solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5));
        System.out.println(T.solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5));
    }
}
