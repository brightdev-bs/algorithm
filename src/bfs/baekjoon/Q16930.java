package bfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q16930 {

    static int n, m, k;
    static char[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n + 1][m + 1];
        visited = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++) {
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                map[i][j + 1] = str.charAt(j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        BFS(x1, y1, x2, y2);
        if(visited[x2][y2] == 0) System.out.println(-1);
        else System.out.println(visited[x2][y2]);
    }

    public static void BFS(int x1, int y1, int x2, int y2) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x1, y1});
        visited[x1][y1] = 0;
        while(!queue.isEmpty()) {
            int[] point = queue.poll();
            int currentX = point[0];
            int currentY = point[1];

            for(int i = 0; i < 4; i++) {
                int nx = currentX, ny = currentY;
                for(int j = 1; j <= k; j++) {

                    // 0:  왼쪽, 1: 오른쪽, 2: 위쪽, 3: 아래쪽
                    if(i == 0) ny = currentY - j;
                    else if(i == 1) ny = currentY + j;
                    else if(i == 2) nx = currentX - j;
                    else if(i == 3) nx = currentX + j;

                    if(nx >= 1 && nx <= n && ny >= 1 && ny <= m && map[nx][ny] == '.') {
                        if(visited[nx][ny] == 0) {
                            visited[nx][ny] = visited[currentX][currentY] + 1;
                            if(currentY == y2 && currentX == x2) return;
                            queue.add(new int[]{nx, ny});
                        } else if(visited[nx][ny] <= visited[currentX][currentY]) {
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
