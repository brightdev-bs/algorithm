package implementation.inflearn;

public class Q1_3 {

    private static final int SIZE = 10;

    public int solution(int[][] board){
        int answer = 0;

        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        int d1 = 0, d2 = 0;


        int x1 = -1, y1 = -1, x2= -1, y2 = -1;
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                if(board[i][j] == 2) {
                    x1 = i;
                    y1 = j;
                } else if(board[i][j] == 3) {
                    x2 = i;
                    y2 = j;
                }
            }
        }

        while(answer <= 10000) {
            answer++;

            int dx1 = x1 + dx[d1];
            int dy1 = y1 + dy[d1];
            boolean isRotated1 = false;

            int dx2 = x2 + dx[d2];
            int dy2 = y2 + dy[d2];
            boolean isRotated2 = false;

            if(dx1 < 0 || dx1 >= SIZE || dy1 < 0 || dy1 >= SIZE || board[dx1][dy1] == 1) {
                isRotated1 = true;
                d1 = (d1 + 1) % 4;
            }

            if(dx2 < 0 || dx2 >= SIZE || dy2 < 0 || dy2 >= SIZE || board[dx2][dy2] == 1) {
                isRotated2 = true;
                d2 = (d2 + 1) % 4;
            }

            if(!isRotated1) {
                x1 = dx1;
                y1 = dy1;
            }

            if(!isRotated2) {
                x2 = dx2;
                y2 = dy2;
            }

            if(x1 == x2 && y1 == y2) break;
        }

        if(answer >= 10000) return 0;

        return answer;
    }

    public static void main(String[] args){
        Q1_3 T = new Q1_3();
        int[][] arr1 = {{0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 2, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 3, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 0}};
        System.out.println(T.solution(arr1));
        int[][] arr2 = {{1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 1, 1, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0, 2, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 0, 0, 0, 0, 3}};
        System.out.println(T.solution(arr2));
    }
}
