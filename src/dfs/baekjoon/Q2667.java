package dfs.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Q2667 {

    static int n;
    static int cnt = 0;
    static int[] dj = { -1, 0, 0, 1}, di = {0, -1, 1, 0};
    static int[][] graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < s.length(); j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                cnt = 0;
                if(graph[i][j] == 1) {
                    DFS(i, j);
                    list.add(cnt);
                }
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }

    public static void DFS(int i, int j) {
        cnt++;
        graph[i][j] = 0;
        for(int l = 0; l < di.length; l++) {
            int ni = i + di[l];
            int nj = j + dj[l];
            if(ni >= 0 && ni < n && nj >= 0 && nj < n && graph[ni][nj] == 1) {
                DFS(ni, nj);
            }
        }
    }
}
