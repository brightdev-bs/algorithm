package implementation.inflearn;

import java.util.Arrays;

public class Q1_2 {

    static final int RIGHT = 0;
    static final int BOTTOM = 1;
    static final int LEFT = 2;
    static final int TOP = 3;

    public int[] solution(int[][] board, int k){
        int[] answer = new int[2];

        // 방향을 나타내는 변수를 만든다.
        // 0: 오른쪽, 1: 아래, 2: 왼쪽, 3:위쪽
        int direction = 0;

        int r = 0;
        int c = 0;

        // board 가로, 세로 길이
        int rowLen = board.length;
        int colLen = board[0].length;

        while(k > 0) {
            // 움직인다.
            // 1. 빈 공간이면
            if(direction == RIGHT && c + 1 < colLen && board[r][c + 1] == 0) {
                c = c + 1;
            } else if(direction == BOTTOM && r + 1 < rowLen && board[r + 1][c] == 0) {
                r = r + 1;
            } else if(direction == LEFT && c - 1>= 0 && board[r][c - 1] == 0) {
                c = c - 1;
            } else if(direction == TOP && r - 1 >= 0 && board[r - 1][c] == 0) {
                r = r - 1;
            } // 2. 장애물을 만나면 -> 90도 회전한다.
            else {
                direction = (direction + 1) % 4;
            }

            k--;
        }

        answer[0] = r;
        answer[1] = c;
        return answer;
    }

    public static void main(String[] args){
        Q1_2 T = new Q1_2();
        int[][] arr1 = {{0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr1, 10)));
        int[][] arr2 = {{0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr2, 20)));
        int[][] arr3 = {{0, 0, 1, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}};
        System.out.println(Arrays.toString(T.solution(arr3, 25)));

    }
}
