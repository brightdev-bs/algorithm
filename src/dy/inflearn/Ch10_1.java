package dy.inflearn;

import java.util.Scanner;

public class Ch10_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] dy = new int[n + 1];
        dy[1] = 1;
        dy[2] = 2;
        for(int i = 3; i <= n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }

        System.out.println(dy[n]);

    }
}

//3일 때를 가정해보자
//1일 때는 1          ==> 1
//
//2일 때는 1, 2       ==> 2
//
//3일 때는 1 -> 3 1
//       2 -> 3 2   ==> 1 + 2 = 3
//
//4일 때는 2 -> 4 2
//       3 -> 4 3   ==> 2 + 3 = 5
//
//5일 때는 3 -> 5
//       4 -> 5     ==> 3 + 5 = 8
//
//6일 때는 4 -> 6
//       5 -> 6     ==> 5 + 8 = 13
//
//7일 때는 5 -> 7
//       6 -> 7     ==> 8 + 13 = 21

