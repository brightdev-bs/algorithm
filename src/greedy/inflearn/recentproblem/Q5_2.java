package greedy.inflearn.recentproblem;

import java.util.Arrays;

public class Q5_2 {

    final int LIMIT = 5;

    public int solution(int[] nums){
        int answer = 0;

        Arrays.sort(nums);

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            if(nums[left] + nums[right] <= LIMIT) {
                left++;
                right--;
            } else {
                right--;
            }
            answer++;
        }


        return answer;
    }

    public static void main(String[] args){
        Q5_2 T = new Q5_2();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
