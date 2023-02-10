package dfs.baekjoon;

import java.util.Scanner;

public class Q1303 {

    static int n, m, wSum = 0, bSum = 0, answer = 0;
    static int[] dx = {-1, 0, 0, 1}, dy = {0, -1, 1, 0};
    static char[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[m][n];
        for(int i = 0; i < m; i++) {
            String s = sc.next();
            for(int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                answer = 0;
                if(arr[i][j] != 'C') {
                    char tmp = arr[i][j];
                    arr[i][j] = 'C';
                    DFS(i, j, tmp);
                    if(tmp == 'W') wSum += answer * answer;
                    else bSum += answer * answer;
                }
            }
        }

        System.out.println(wSum);
        System.out.println(bSum);


    }

    public static void DFS(int i, int j, char c) {
        answer += 1;
        for(int l = 0; l < 4; l++) {
            int nx = i + dx[l];
            int ny = j + dy[l];
            if(nx >= 0 && nx < m && ny >= 0 && ny < n && arr[nx][ny] == c) {
                arr[nx][ny] = 'C';
                DFS(nx, ny, c);
            }
        }
    }
}
