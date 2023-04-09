package greedy.inflearn.recentproblem;

import java.util.*;

public class Q5_5 {

    static class Student {
        int index;
        char group;
        int power;

        public Student(int index, char group, int power) {
            this.index = index;
            this.group = group;
            this.power = power;
        }
    }

    public int[] solution(String[] students){
        int n = students.length;
        int[] answer = new int[n];

        List<Student> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            list.add(new Student(i, students[i].split(" ")[0].charAt(0), Integer.parseInt(students[i].split(" ")[1])));
        }

        list.sort((a, b) -> a.power - b.power);

        Map<Character, Integer> tP = new HashMap<>();
        int j = 0, total = 0;
        for(int i = 1; i < n; i++) {
            for( ; j < n; j++) {
                if(list.get(j).power < list.get(i).power) {
                    total += list.get(j).power;
                    char x = list.get(j).group;
                    tP.put(x, tP.getOrDefault(x, 0) + list.get(j).power);
                }
                else break;
            }

            answer[list.get(i).index] = total - tP.getOrDefault(list.get(i).group, 0);
        }


        return answer;
    }

    public static void main(String[] args){
        Q5_5 T = new Q5_5();
        System.out.println(Arrays.toString(T.solution(new String[]{"a 20", "b 12", "a 10", "c 11", "e 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 17", "b 12", "a 10", "c 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"b 20", "c 15", "a 200", "b 11", "b 24", "a 25", "b 12"})));
        System.out.println(Arrays.toString(T.solution(new String[]{"a 30", "a 25", "a 25", "b 20", "b 25", "a 25", "b 30"})));
    }
}
