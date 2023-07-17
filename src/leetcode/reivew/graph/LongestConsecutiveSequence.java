package leetcode.reivew.graph;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums) {
            set.add(n);
        }


        int answer = 0;
        for(int n : set) {
            int length = 1;
            if(!set.contains(n - 1)) {
                while(set.contains(n + length)) {
                    length++;
                }

                answer = Math.max(answer, length);
            }
        }

        return answer;
    }
}
