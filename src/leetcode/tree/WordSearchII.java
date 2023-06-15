package leetcode.tree;

public class WordSearchII {
    class Solution {
        class Node {
            Node[] nodes = new Node[26];
            String word;
        }

        public List<String> findWords(char[][] board, String[] words) {
            List<String> res = new ArrayList<>();
            Node root = buildTree(words);
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    DFS(board, i, j, root, res);
                }
            }
            return res;
        }

        public Node buildTree(String[] words) {
            Node root = new Node();
            for(String s : words) {
                Node p = root;
                for (char c : s.toCharArray()) {
                    int i = c - 'a';
                    if (p.nodes[i] == null) p.nodes[i] = new Node();
                    p = p.nodes[i];
                }
                p.word = s;
            }
            return root;
        }

        public void DFS(char[][] board, int i, int j, Node p, List<String> res) {
            char c = board[i][j];
            if (c == '#' || p.nodes[c - 'a'] == null) return;
            p = p.nodes[c - 'a'];
            if(p.word != null) {
                res.add(p.word);
                p.word = null;
            }

            board[i][j] = '#';
            if(i > 0) DFS(board, i -1, j, p, res);
            if(j > 0) DFS(board, i, j - 1, p, res);
            if(i < board.length - 1) DFS(board, i + 1, j, p, res);
            if(j < board[0].length - 1) DFS(board, i, j + 1, p, res);
            board[i][j] = c;

        }
    }
}
