package dfs.inflearn.important;

import java.util.*;

public class Q6_4 {

    Map<Character, Integer> hM;
    LinkedList<Character>list;
    List<String> res;
    int n;

    public String[] solution(String s){
        n = s.length();
        hM = new HashMap<>();
        for (char c : s.toCharArray()) {
            hM.put(c, hM.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        list = new LinkedList<>();
        for (Map.Entry<Character, Integer> e : hM.entrySet()) {
            if(e.getValue() % 2 == 1) {
                list.add(e.getKey());
                hM.put(e.getKey(), 0);
                count++;
            }
        }

        if(count > 1) return new String[]{};

        res = new ArrayList<>();
        DFS();
        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public void DFS() {
        if(list.size() == n) {
            String tmp = "";
            for (Character character : list) {
                tmp += character;
            }
            res.add(tmp);
        } else {
            for (Character c : hM.keySet()) {
                if(hM.get(c) == 0) continue;
                list.addFirst(c);
                list.addLast(c);
                hM.put(c, hM.get(c) - 2);
                DFS();
                list.pollFirst();
                list.pollLast();
                hM.put(c, hM.get(c) + 2);
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
