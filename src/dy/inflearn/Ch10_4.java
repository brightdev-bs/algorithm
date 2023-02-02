package dy.inflearn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ch10_4 {

    static class Brick implements Comparable<Brick> {
        int bottom, height, weight;

        public Brick(int bottom, int height, int weight) {
            this.bottom = bottom;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.bottom - this.bottom;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        ArrayList<Brick> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            int b = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Brick(b, h, w));
        }

        Collections.sort(list);
        int[] dy = new int[n];
        dy[0] = list.get(0).height;
        for(int i = 1; i < n; i++) {
            Brick bottom = list.get(i);
            int maxHeight = 0;
            for(int j = 0; j < i; j++) {
                Brick up = list.get(j);
                if(bottom.weight < up.weight) {
                    maxHeight = Math.max(maxHeight, dy[j]);
                }
            }
            dy[i] = maxHeight + bottom.height;
        }

        int answer = Integer.MIN_VALUE;
        for (int i : dy) {
            answer = Math.max(i, answer);
        }

        System.out.println(answer);
    }
}

//b  h w
//25 3 4     1번을 제일 맨 위에 놓았을 때 ==> 3
//16 2 5     2번을 제일 맨 위에 놓았을 때 ==> 2
//9  2 3     3번이 제일 맨 위에 놓았을 때 ==> 3 + 2 = 5
//4  4 6     2번이 제일 맨 위에 놓았을 때 ==> 4
//1  5 2     1번이 제일 맨 위에 놓았을 때 ==> 3 + 2 + 5 = 10
