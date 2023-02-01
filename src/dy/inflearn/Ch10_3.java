package dy.inflearn;

import java.util.Scanner;

public class Ch10_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = Integer.MIN_VALUE;
        int[] dy = new int[n];
        dy[0] = 1;
        for(int i = 1; i < n; i++) {
            int max = 0;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && max < dy[j]) max = dy[j];
                // dy[i] = Math.max(dy[j] + 1, dy[i]) -> 이거 x
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }

        System.out.println(answer);
    }
}
