package sort.inflearn;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Q4_1 {

    static class Binary {
        int num;
        int count;

        public Binary(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }

    public int[] solution(int[] nums){
        int[] answer = new int[nums.length];

        PriorityQueue<Binary> pq = new PriorityQueue<>((a, b) -> a.count == b.count ? a.num - b.num : a.count - b.count);
        for (int num : nums) {
            String s = toBinary(num);
            int count = countOne(s);
            pq.add(new Binary(num, count));
        }

        for(int i = 0; i < nums.length; i++) {
            Binary b = pq.poll();
            answer[i] = b.num;
        }


        return answer;
    }

    public String toBinary(int num) {
        String res = "";
        while(num > 0) {
            res = num % 2 + res;
            num /= 2;
        }

        return res;
    }

    public int countOne(String num) {
        int cnt = 0;
        for (char c : num.toCharArray()) {
            if(c == '1') cnt++;
        }

        return cnt;
    }

    public static void main(String[] args){
        Q4_1 T = new Q4_1();
        System.out.println(Arrays.toString(T.solution(new int[]{5, 6, 7, 8, 9})));
        System.out.println(Arrays.toString(T.solution(new int[]{5, 4, 3, 2, 1})));
        System.out.println(Arrays.toString(T.solution(new int[]{12, 5, 7, 23, 45, 21, 17})));
    }
}
