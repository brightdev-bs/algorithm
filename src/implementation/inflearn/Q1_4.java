package implementation.inflearn;

import java.util.Arrays;

public class Q1_4 {

    static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

    public int[] solution(int c, int r, int k){
        int[] answer = new int[2];

        int[][] board = new int[r][c];
        int cr = r - 1;
        int cc = 0;

        board[cr][cc] = 1;
        int direction = 0;
        int count = 1;

        if(c * r < k) return new int[]{0, 0};

        while(count < c * r || count != k) {

            int nr = cr + dr[direction];
            int nc = cc + dc[direction];
            boolean flag = false;

            if(nr < 0 || nr >= r || nc < 0 || nc >= c || board[nr][nc] != 0) {
                direction = (direction + 1) % 4;
                flag = true;
            }

            if(!flag) {
                cr = nr;
                cc = nc;
                board[nr][nc] = 1;
                count = count + 1;
            }

            if(count == k) {
                answer[0] = cc + 1;
                answer[1] = cr + 1;
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args){
        Q1_4 T = new Q1_4();
        System.out.println(Arrays.toString(T.solution(6, 5, 12)));
        System.out.println(Arrays.toString(T.solution(6, 5, 20)));
        System.out.println(Arrays.toString(T.solution(6, 5, 30)));
        System.out.println(Arrays.toString(T.solution(6, 5, 31)));
    }
}
