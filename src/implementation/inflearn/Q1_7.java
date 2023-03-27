package implementation.inflearn;

import java.util.Arrays;

public class Q1_7 {

    static int[][] arr;

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1 }, dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    public int solution(int[] keypad, String password){
        int answer = 0;

        arr = new int[3][3];
        int index = 0;
        while(index < 9) {
            arr[index / 3][index % 3] = keypad[index];
            index++;
        }

        int[][] ch = new int[10][10];
        for(int i = 0; i < 10; i++) {
            Arrays.fill(ch[i], 2);
        }

        for(int i = 0; i < 10; i++) ch[i][i] = 0;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                int from = arr[i][j];
                for(int k = 0; k < 8; k++) {
                    if(i + dr[k] >= 0 && i + dr[k] < 3 && j + dc[k] >= 0 && j + dc[k] < 3) {
                        int to = arr[i + dr[k]][j + dc[k]];
                        ch[from][to] = 1;
                    }
                }

            }
        }

        for(int i = 1; i < password.length(); i++) {
            int from = (int) password.charAt(i - 1) - '0';
            int to = (int) password.charAt(i) - '0';
            answer += ch[from][to];
        }

        return answer;
    }

    public static void main(String[] args){
        Q1_7 T = new Q1_7();
        System.out.println(T.solution(new int[]{2, 5, 3, 7, 1, 6, 4, 9, 8}, "7596218"));
        System.out.println(T.solution(new int[]{1, 5, 7, 3, 2, 8, 9, 4, 6}, "63855526592"));
        System.out.println(T.solution(new int[]{2, 9, 3, 7, 8, 6, 4, 5, 1}, "323254677"));
        System.out.println(T.solution(new int[]{1, 6, 7, 3, 8, 9, 4, 5, 2}, "3337772122"));
    }
}
