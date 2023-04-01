package hashing.inflearn;

import java.util.*;

public class Q2_7 {

    public String[] solution(String[] reports, int time){

        Map<String, List<Integer>> baseMap = new HashMap<>();
        for (String report : reports) {
            String name = report.split(" ")[0];
            int hour = Integer.parseInt(report.split(" ")[1].split(":")[0]);
            int min = Integer.parseInt(report.split(" ")[1].split(":")[1]);
            baseMap.putIfAbsent(name, new ArrayList<>());
            List<Integer> integers = baseMap.get(name);
            integers.add(hour*60 + min);
        }

        List<String> res = new ArrayList<>();
        for (String name : baseMap.keySet()) {
            List<Integer> arr = baseMap.get(name);
            int sum = 0;
            for(int i = 0; i < arr.size(); i += 2) {
                int t1 = arr.get(i);
                int t2 = arr.get(i + 1);
                sum += t2 - t1;
            }

            if(sum > time) {
                res.add(name);
            }
        }

        Collections.sort(res);

        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public static void main(String[] args){
        Q2_7 T = new Q2_7();
        System.out.println(Arrays.toString(T.solution(new String[]{"john 09:30 in", "daniel 10:05 in", "john 10:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 12:35 out", "daniel 15:05 out"}, 60)));
        System.out.println(Arrays.toString(T.solution(new String[]{"bill 09:30 in", "daniel 10:00 in", "bill 11:15 out", "luis 11:57 in", "john 12:03 in", "john 12:20 out", "luis 14:35 out", "daniel 14:55 out"}, 120)));
        System.out.println(Arrays.toString(T.solution(new String[]{"cody 09:14 in", "bill 09:25 in", "luis 09:40 in", "bill 10:30 out", "cody 10:35 out", "luis 10:35 out", "bill 11:15 in", "bill 11:22 out", "luis 15:30 in", "luis 15:33 out"}, 70)));
        System.out.println(Arrays.toString(T.solution(new String[]{"chato 09:15 in", "emilly 10:00 in", "chato 10:15 out", "luis 10:57 in", "daniel 12:00 in", "emilly 12:20 out", "luis 11:20 out", "daniel 15:05 out"}, 60)));
    }
}
