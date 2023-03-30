package hashing.inflearn;

import java.util.*;

public class Q2_5 {

    public String solution(String[] votes, int k){
        String answer = " ";
        Map<String, HashSet<String>> voteHash = new HashMap<>();
        Map<String, Integer> candidates = new HashMap<>();

        for (String vote : votes) {
            String s1 = vote.split(" ")[0];
            String s2 = vote.split(" ")[1];
            voteHash.putIfAbsent(s1, new HashSet<String>());
            voteHash.get(s1).add(s2);
            candidates.put(s2, candidates.getOrDefault(s2, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        Map<String, Integer> present = new HashMap<>();
        for (String s1 : voteHash.keySet()) {
            int cnt = 0;
            for (String s2 : voteHash.get(s1)) {
                if(candidates.get(s2) >= k) cnt++;
            }
            present.put(s1, cnt);
            max = Math.max(cnt, max);
        }

        ArrayList<String> tmp = new ArrayList<>();
        for (String s : present.keySet()) {
            if(present.get(s) == max) tmp.add(s);
        }
        tmp.sort(String::compareTo);
        answer = tmp.get(0);

        return answer;
    }

    public static void main(String[] args){
        Q2_5 T = new Q2_5();
        System.out.println(T.solution(new String[]{"john tom", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"john tom", "park luis", "john luis", "luis tom", "park tom", "luis john", "luis park", "park john", "john park", "tom john", "tom park", "tom luis"}, 2));
        System.out.println(T.solution(new String[]{"cody tom", "john tom", "cody luis", "daniel luis", "john luis", "luis tom", "daniel tom", "luis john"}, 2));
        System.out.println(T.solution(new String[]{"bob tom", "bob park", "park bob", "luis park", "daniel luis", "luis bob", "park luis", "tom bob", "tom luis", "john park", "park john"}, 3));
    }
}
