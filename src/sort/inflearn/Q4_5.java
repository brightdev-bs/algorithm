package sort.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q4_5 {

    public int solution(int[][] board){
        int answer=0;

        List<Integer> row = new ArrayList<>();
        List<Integer> col = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == 1) {
                    row.add(i);
                    col.add(j);
                }
            }
        }

        Collections.sort(col);

        int targetIdx = row.size() / 2;
        int dr = row.get(targetIdx);
        int dc = col.get(targetIdx);
        for(int i = 0; i < row.size(); i++) {
            answer += Math.abs(dr - row.get(i));
            answer += Math.abs(dc - col.get(i));
        }

        return answer;
    }

    public static void main(String[] args){
        Q4_5 T = new Q4_5();
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}}));
        System.out.println(T.solution(new int[][]{{1, 0, 0, 0, 1, 1}, {0, 1, 0, 0, 1, 0}, {0, 1, 0, 0, 0, 0}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 0, 0, 1}, {1, 0, 0, 0, 1, 1}}));
    }
}
