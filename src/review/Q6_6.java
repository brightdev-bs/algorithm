package review;

import java.util.ArrayList;
import java.util.LinkedList;

public class Q6_6 {

    LinkedList<Character> tmp;
    ArrayList<String> list;
    int[] dy;

    public int solution(String s){
        tmp = new LinkedList<>();
        list = new ArrayList<>();
        dy = new int[s.length() + 1];

        int answer = DFS(0, s);

        return answer;
    }

    public int DFS(int start, String str) {
        if(dy[start] > 0) return dy[start];
        if(start < str.length() && str.charAt(start) == '0') return 0;
        if(start == str.length() || start == str.length() - 1) return 1;
        else {
            int res = DFS(start + 1, str);
            int tmp = Integer.parseInt(str.substring(start, start + 2));
            if(tmp <= 26) res += DFS(start + 2, str);
            return dy[start] = res;
        }
    }

    public static void main(String[] args){
        Q6_6 T = new Q6_6();
        System.out.println(T.solution("25114"));
        System.out.println(T.solution("23251232"));
        System.out.println(T.solution("21020132"));
        System.out.println(T.solution("21350"));
        System.out.println(T.solution("120225"));
        System.out.println(T.solution("232012521"));
    }
}
