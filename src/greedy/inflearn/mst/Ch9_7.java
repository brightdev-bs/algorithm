package greedy.inflearn.mst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch9_7 {

    static int[] unf;
    public static int find(int v) {
        if(v == unf[v]) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }

    public static class Edge implements Comparable<Edge> {
        int v1, v2, c;

        public Edge(int v1, int v2, int c) {
            this.v1 = v1;
            this.v2 = v2;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        unf = new int[n + 1];

        ArrayList<Edge> arr = new ArrayList<>();
        for(int i = 1; i <= n; i++) unf[i] = i;

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr.add(new Edge(a, b, c));
        }

        int answer = 0;
        Collections.sort(arr);
        for (Edge ob : arr) {
            int fv1 = find(ob.v1);
            int fv2 = find(ob.v2);
            if(fv1 != fv2) {
                answer += ob.c;
                union(ob.v1, ob.v2);
            }
        }

        System.out.println(answer);
    }
}
