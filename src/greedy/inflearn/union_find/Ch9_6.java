package greedy.inflearn.union_find;

import java.util.Scanner;

public class Ch9_6 {

    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        ch = new int[n + 1];
        for(int i = 0; i <= n; i++) ch[i] = i;

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }

        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);
        int fb = find(b);
        if(fa == fb) System.out.println("YES");
        else System.out.println("NO");
    }

    public static int find(int n) {
        if(ch[n] == n) return n;
        else return ch[n] = find(ch[n]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) ch[fa] = fb;
    }
}
