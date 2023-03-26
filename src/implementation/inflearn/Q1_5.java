package implementation.inflearn;

import java.util.ArrayList;
import java.util.List;

public class Q1_5 {

    public int solution(int[] nums){
        int answer = 0;

        int length = nums.length;

        // peek 좌표 idx 값
        List<Integer> peeks = new ArrayList<>();
        for(int i = 1; i < length - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                peeks.add(i);
            }
        }

        for (Integer index : peeks) {

            // 왼쪽으로
            int lt = index;
            int rt = index;
            while(lt -1 >= 0 && nums[lt - 1] < nums[lt]) {
                lt--;
            }

            while(rt + 1 < length && nums[rt] > nums[rt + 1]) {
                rt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }


        return answer;
    }

    public static void main(String[] args){
        Q1_5 T = new Q1_5();
        System.out.println(T.solution(new int[]{1, 3, 2, 5, 7, 4, 2, 5, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}
