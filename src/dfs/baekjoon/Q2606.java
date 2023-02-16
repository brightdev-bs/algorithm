package dfs.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q2606 {

    static ArrayList<ArrayList<Integer>> list;
    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        ch = new int[n + 1];
        list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < k; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        DFS(1);
        ch[1] = 1;
        int count = -1;
        for (int i : ch) {
            if(i == 1) {
                count++;
            }
        }

        System.out.println(count);
    }

    public static void DFS(int s) {
        for (Integer integer : list.get(s)) {
            if(ch[integer] == 0) {
                ch[integer] = 1;
                DFS(integer);
            }
        }
    }
}
