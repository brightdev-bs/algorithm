package sort.inflearn;

import java.util.*;

public class Q4_2 {

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length / 2];

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if(map.containsKey(num * 2)) {
                list.add(num);
                if(map.get(num * 2) == 1) map.remove(num * 2);
                else map.put(num * 2, map.get(num * 2) - 1);
            }
        }

        Collections.sort(list);
        for(int i = 0; i < nums.length / 2; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Q4_2 T = new Q4_2();
        System.out.println(Arrays.toString(T.solution(new int[]{1, 10, 2, 3, 5, 6})));
        System.out.println(Arrays.toString(T.solution(new int[]{1, 1, 6, 2, 2, 7, 3, 14})));
        System.out.println(Arrays.toString(T.solution(new int[]{14, 4, 2, 6, 3, 10, 10, 5, 5, 7, 7, 14})));
    }
}
