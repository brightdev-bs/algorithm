package dfs.inflearn.important;

import java.util.Stack;

public class Q6_2 {

    static int[][] relation;
    static int[] ch;
    static int answer;

    Stack<Integer> stack;

    public int solution(int[][] fight){
        answer = 0;

        relation = new int[8][8];
        stack = new Stack<>();
        ch = new int[8];

        for (int[] ints : fight) {
            int a = ints[0];
            int b = ints[1];
            relation[a][b] = 1;
            relation[b][a] = 1;
        }

        DFS(0);

        return answer;
    }

    public void DFS(int n) {
        if(n == 7) {
            answer++;
        } else {
            for(int i = 1; i <= 7; i++) {
                if(!stack.isEmpty() && relation[stack.peek()][i] == 1) continue;
                if(ch[i] == 0) {
                    ch[i] = 1;
                    stack.push(i);
                    DFS(n + 1);
                    ch[i] = 0;
                    stack.pop();
                }
            }
        }
    }

    public static void main(String[] args){
        Q6_2 T = new Q6_2();
        System.out.println(T.solution(new int[][]{{1, 3}, {5, 7}, {4, 2}}));
        System.out.println(T.solution(new int[][]{{3, 2}, {3, 5}, {5, 2}, {7, 3}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {1, 5}, {1, 7}, {1, 3}}));
        System.out.println(T.solution(new int[][]{{1, 7}}));
        System.out.println(T.solution(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {6, 7}}));
    }
}
