package codility;

import java.util.LinkedList;
import java.util.Queue;

public class Q3 {

    class Tree {
        public int x;
        public Tree l;
        public Tree r;
    }

    public int solution(Tree T) {
        // Implement your solution here
        int answer = 0;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(T);
        int L = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            boolean levelFlag = true;
            for(int i = 0; i < len; i++) {
                boolean childFlag = true;
                Tree t = queue.poll();
                if(t.r != null && t.l != null && levelFlag == childFlag) {
                    queue.add(t.l);
                    queue.add(t.r);
                }

                if(t.r == null && t.l == null) levelFlag = false;

                if(levelFlag != childFlag) {
                    answer = Math.max(L, answer);
                    L = 0;
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {

    }
}
