package leetcode.heap;

import java.util.*;

// Bucket sort
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            res.add(new ArrayList<>());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int key : nums) {
            int count = map.getOrDefault(key, 0);
            map.put(key, count + 1);
            res.get(count + 1).add(key);
        }

        HashSet<Integer> tmp = new HashSet<>();
        for(int i = nums.length; i >= 0; i--) {
            for (Integer n : res.get(i)) {
                tmp.add(n);
                if(tmp.size() == k) {
                    int idx = 0;
                    int[] answer = new int[tmp.size()];
                    for (Integer integer : tmp) {
                        answer[idx++] = integer;
                    }
                    return answer;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TopKFrequentElements m = new TopKFrequentElements();
//        m.topKFrequent(new int[]{1,2}, 2);
        int[] answer = m.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        for (int i : answer) {
            System.out.print(i + " ");
        }
//
//
//        int[] ints = m.topKFrequent(new int[]{1}, 1);
//        for (int i : ints) {
//            System.out.println(i);
//        }
    }
}
