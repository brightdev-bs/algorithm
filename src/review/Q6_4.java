package review;

import java.util.*;

/**
 * 펠린드롬 수가 될 수 있는 경우의 수는 다음과 같다.
 * 1. 모두 짝수로 이루어진 경우
 * 2. 홀수로 된 알파벳이 하나인 경우
 */
public class Q6_4 {

    Deque<Character> deque;
    List<String> res;
    Map<Character, Integer> map;
    int len;

    public String[] solution(String s){
        deque = new LinkedList<>();
        res = new ArrayList<>();
        len = s.length();
        map = new HashMap<>();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // map의 값이 모두 짝수인지 혹은 한 개만 홀수인지 확인
        int odd = 0;
        char mid = '#';
        for(char key : map.keySet()){
            if(map.get(key) % 2 == 1){
                mid = key;
                odd++;
            }
        }
        if(odd > 1) return new String[]{};

        if(mid != '#') {
            deque.add(mid);
            map.put(mid, map.get(mid) - 1);
        }

        DFS();
        String[] answer = new String[res.size()];
        for (int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public void DFS() {
        if(deque.size() == len) {
            String s = "";
            for (Character character : deque) {
                s += character;
            }
            res.add(s);
        } else {
            for (Character c : map.keySet()) {
                if(map.get(c) != 0) {
                    deque.addFirst(c);
                    deque.addLast(c);
                    map.put(c, map.get(c) - 2);
                    DFS();
                    deque.pollFirst();
                    deque.pollLast();
                    map.put(c, map.get(c) + 2);
                }
            }
        }
    }

    public static void main(String[] args){
        Q6_4 T = new Q6_4();
        System.out.println(Arrays.toString(T.solution("aaaabb")));
        System.out.println(Arrays.toString(T.solution("abbcc")));
        System.out.println(Arrays.toString(T.solution("abbccee")));
        System.out.println(Arrays.toString(T.solution("abbcceee")));
        System.out.println(Arrays.toString(T.solution("ffeffaae")));
    }
}


