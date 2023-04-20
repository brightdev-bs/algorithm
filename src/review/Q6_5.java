package review;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Q6_5 {

    LinkedList<String> tmp;
    ArrayList<String> res;

    public String[] solution(String s){
        tmp = new LinkedList<>();
        res = new ArrayList<>();

        DFS(0, s);

        String[] answer = new String[res.size()];
        for(int i = 0; i < res.size(); i++) {
            answer[i] = res.get(i);
        }

        return answer;
    }

    public void DFS(int start, String str) {
        if(tmp.size() > 4) return;
        if(tmp.size() == 4 && start == str.length()) {
            String ts = "";
            for (String s : tmp) ts += s + ".";
            res.add(ts.substring(0, ts.length() - 1));
        } else {
            for(int i = start; i < str.length(); i++) {
                if(str.charAt(start) == '0' && i > start) return;
                String num = str.substring(start, i + 1);
                if(Integer.parseInt(num) > 255) return;
                tmp.addLast(num);
                DFS(i + 1, str);
                tmp.pollLast();
            }
        }
    }


    public static void main(String[] args){
        Q6_5 T = new Q6_5();
        System.out.println(Arrays.toString(T.solution("2025505")));
        System.out.println(Arrays.toString(T.solution("0000")));
        System.out.println(Arrays.toString(T.solution("255003")));
        System.out.println(Arrays.toString(T.solution("155032012")));
        System.out.println(Arrays.toString(T.solution("02325123")));
        System.out.println(Arrays.toString(T.solution("121431211")));
    }
}
