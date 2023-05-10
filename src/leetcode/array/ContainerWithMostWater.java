package leetcode.array;

public class ContainerWithMostWater {
    class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int answer = 0;
            for(int l = 0, r = n - 1; l < r; ) {

                int area = (r - l) * Math.min(height[l], height[r]);
                answer = Math.max(area, answer);

                if(height[l] > height[r]) r--;
                else l++;
            }

            return answer;
        }
    }
}
