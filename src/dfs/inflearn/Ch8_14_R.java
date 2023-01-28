package dfs.inflearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ch8_14_R {

    static int n, m, answer = Integer.MAX_VALUE;
    static int[] combi;
    static List<Point> hs, pz;

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        combi = new int[m];
        hs = new ArrayList<>();
        pz = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int input = sc.nextInt();
                if(input == 1) hs.add(new Point(i, j));
                else if(input == 2) pz.add(new Point(i, j));
            }
        }

        DFS(0,0);
        System.out.println(answer);

    }

    // 조합의 경우의 수를 구한다. 하지만 이 때 (2 1 3) (1 2 3)은 같으므로 중복 계산하지 않도록 해야 한다.
    public static void DFS(int L, int s) {
        if(L == m) {
            int sum = 0;
            for (Point h : hs) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(h.x - pz.get(i).x) + Math.abs(h.y - pz.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(sum, answer);
        } else {
            // 조합 경우의 수 구하기
            for(int i = s; i < pz.size(); i++) {
                combi[L] = i;
                DFS(L + 1, i + 1);
            }
        }
    }
}
