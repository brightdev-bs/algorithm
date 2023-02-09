package implementation.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3460 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for(int i = 1; i <= n; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            int input = sc.nextInt();

            while(input > 0) {
                list.add(input % 2);
                input /= 2;
            }

            for(int j = 0; j < list.size(); j++) {
                if(list.get(j) == 1) System.out.print(j + " ");
            }
        }

    }
}

