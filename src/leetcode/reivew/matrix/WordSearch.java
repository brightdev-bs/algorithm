package leetcode.reivew.matrix;

public class WordSearch {

    final int[] dr = { -1, 0, 0, 1 }, dc = { 0, -1, 1, 0};
    final int DIRECTION = 4;
    boolean flag = false;
    boolean[][] check;
    public boolean exist(char[][] board, String word) {
        int len = word.length();

        int n = board.length;
        int m = board[0].length;
        check = new boolean[n][m];
        int pos = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == word.charAt(pos)) {
                    check[i][j] = true;
                    DFS(board, i, j, pos + 1, word);
                    check[i][j] = false;
                }
            }
        }
        return flag;
    }

    private void DFS(char[][] board, int r, int c, int pos, String word) {
        if(pos == word.length()) {
            flag = true;
        } else {
            for(int i = 0; i < DIRECTION; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                    if(board[nr][nc] == word.charAt(pos) && !check[nr][nc]) {
                        check[nr][nc] = true;
                        DFS(board, nr, nc, pos + 1, word);
                        check[nr][nc] = false;
                    }
                }
            }
        }
    }
}
