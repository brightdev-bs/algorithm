package greedy.inflearn.recentproblem;

import java.util.Arrays;

public class Q5_1 {

    public int solution(int[] nums, int m){
        int answer = 0;

        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            if(nums[left] + nums[right] <= m) {
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
        Q5_1 T = new Q5_1();
        System.out.println(T.solution(new int[]{90, 50, 70, 100, 60}, 140));
        System.out.println(T.solution(new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90}, 100));
        System.out.println(T.solution(new int[]{68, 72, 30, 105, 55, 115, 36, 67, 119, 111, 95, 24, 25, 80, 55, 85, 75, 83, 21, 81}, 120));
    }
}
