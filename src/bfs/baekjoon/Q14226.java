package bfs.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q14226 {

    static boolean[][] ch = new boolean[20001][20001];

    static class Node {
        int num, count, prior;

        public Node(int num, int count, int prior) {
            this.num = num;
            this.count = count;
            this.prior = prior;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int s = sc.nextInt();

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 0, 0));
        ch[1][0] = true;
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.num == s) {
                System.out.println(node.count);
                return;
            } else {
                int next = -1, nextCount = - 1, prior = -1;
                for(int i = 0; i < 3; i++) {
                    if(i == 1 && node.prior != 0) {
                        next = node.num + node.prior;
                        nextCount = node.count + 1;
                        prior = node.prior;
                    } else if(i == 0) {
                        next = node.num * 2;
                        nextCount = node.count + 2;
                        prior = node.num;
                    } else {
                        next = node.num - 1;
                        nextCount = node.count + 1;
                        prior = node.prior;
                    }

                    if(next >= 0 && !ch[next][prior]) {
                        ch[next][prior] = true;
                        queue.add(new Node(next, nextCount, prior));
                    }
                }
            }
        }
    }
}
