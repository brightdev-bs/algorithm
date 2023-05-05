package review;

import java.util.*;

public class Q2_5 {

    public String solution(String[] votes, int k){
        HashMap<String, HashSet<String>> map = new HashMap<>();
        for (String vote : votes) {
            String from = vote.split(" ")[0];
            String to = vote.split(" ")[1];
            map.putIfAbsent(to, new HashSet<>());
            map.get(to).add(from);
        }

        HashMap<String, Integer> present = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (Map.Entry<String, HashSet<String>> entry : map.entrySet()) {
            if(entry.getValue().size() >= k) {
                for (String s : entry.getValue()) {
                    present.put(s, present.getOrDefault(s, 0) + 1);
                    if(present.get(s) > max) max = present.get(s);
                }
            }
        }

        ArrayList<String> tmp = new ArrayList<>();
        for (String s : present.keySet()) {
            if(present.get(s) == max) {
                tmp.add(s);
            }
        }


        tmp.sort((a, b) -> a.compareTo(b));

        return tmp.get(0);
    }

    public static void main(String[] args){
        Q2_5 T = new Q2_5();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
