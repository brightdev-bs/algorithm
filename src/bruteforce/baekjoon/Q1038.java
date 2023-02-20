package bruteforce.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 다시 풀기
public class Q1038 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if(n < 10) {
            System.out.println(n);
            return;
        }

        // 9876543210이 구할 수 있는 최대 값으로 그 이상 계산 할 필요 없음.
        if(n > 1022) {
            System.out.println(-1);
        }

        int size = 0;
        Queue<Long> queue = new LinkedList<>();
        for(int i = 1; i < 10; i++) {
            queue.add((long)i);
            size++;
        }

        while(!queue.isEmpty()) {
            long current = queue.poll();
            long until = current % 10;
            for(int i = 0; i < until; i++) {
                queue.add(current * 10 + i);
                size++;
                if(size == n) {
                    System.out.println(current * 10 + i);
                    break;
                }
            }
        }
    }
}
