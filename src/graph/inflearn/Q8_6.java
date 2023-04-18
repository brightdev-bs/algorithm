package graph.inflearn;

import java.util.*;

public class Q8_6 {
    public String[] solution(String[] subjects, String[] course){

        HashMap<String, Integer> map = new HashMap<>();
        int n = subjects.length;
        for (int i = 0; i < n; i++) {
            map.put(subjects[i], i);
        }

        int[] ch = new int[n];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (String s : course) {
            String a = s.split(" ")[0];
            String b = s.split(" ")[1];
            list.get(map.get(b)).add(map.get(a));
            ch[map.get(a)]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(ch[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            Integer cur = queue.poll();
            res.add(cur);
            for (Integer integer : list.get(cur)) {
                ch[integer]--;
                if(ch[integer] == 0) queue.offer(integer);
            }
        }

        String[] answer = new String[n];
        System.out.println(res);
        for(int i = 0; i < n; i++){
            answer[i] = subjects[res.get(i)];
        }

        return answer;
    }

    public static void main(String[] args){
        Q8_6 T = new Q8_6();
        System.out.println(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"}));
//        System.out.println(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})[0]);
//        System.out.println(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"}));
    }

}
