# 최단거리 (BFS)
### 구현
BFS와 달리 방문했다는 표시를 체크하고 해제하기 어렵기 때문에 dis배열을 이용할 수 있다. <br>

~~~java
Queue<Point> queue = new LinkedList<>();
board[1][1] = 1;
queue.add(new Point(1, 1));
while(!queue.isEmpty()) {
    int len = queue.size();
    for(int i = 0; i < len; i++) {
        Point p = queue.poll();
        if(p.x == 7 && p.y == 7) answer++;
        else {
            for(int j = 0; j < 4; j++) {
                int nx = p.x + dx[j];
                int ny = p.y + dy[j];
                if(nx >= 1 && nx <= 7 && ny >= 1 && ny <= 7 && board[nx][ny] == 0) {
                    board[nx][ny] = 1;
                    queue.add(new Point(nx, ny));
                    dis[nx][ny] = dis[p.x][p.y] + 1;
                }
            }
        }
    }
}
~~~

### 관련 문제 
[인프런 8-11](/bfs/inflearn/Ch8_11.java) <br>
[인프런 8-12](/bfs/inflearn/Ch8_12.java) <br>