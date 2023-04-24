package review;

import java.util.*;

public class Q8_6 {

    public String[] solution(String[] subjects, String[] course){
        int n = subjects.length;

        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(subjects[i], i);
        }

        int[] indegree = new int[n];
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (String s : course) {
            Integer second = map.get(s.split(" ")[0]);
            Integer first = map.get(s.split(" ")[1]);
            list.get(first).add(second);
            indegree[map.get(s.split(" ")[0])]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 0) queue.add(i);
        }

        ArrayList<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            Integer cur = queue.poll();
            res.add(cur);
            for (Integer next : list.get(cur)) {
                indegree[next]--;
                if(indegree[next] == 0) queue.add(next);
            }
        }

        String[] answer = new String[n];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = subjects[res.get(i)];
        }

        return answer;
    }

    public static void main(String[] args){
        Q8_6 T = new Q8_6();
        System.out.println(Arrays.deepToString(T.solution(new String[]{"english", "math", "physics", "art", "music"}, new String[]{"art math", "physics art", "art music", "physics math", "english physics"})));
        System.out.println(Arrays.deepToString(T.solution(new String[]{"art", "economics", "history", "chemistry"}, new String[]{"chemistry history", "economics history", "art economics"})));
        System.out.println(Arrays.deepToString(T.solution(new String[]{"math", "science", "music", "biology"}, new String[]{"science music", "math music", "math science", "biology math"})));
    }
}
