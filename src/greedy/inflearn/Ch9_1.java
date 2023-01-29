package greedy.inflearn;

import java.util.Arrays;
import java.util.Scanner;

public class Ch9_1 {

    static int n;
    static Person[] arr;

    static class Person implements Comparable<Person> {
        int height, weight;

        public Person(int height, int weight) {
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Person o) {
            if(this.height == o.height) return o.weight - this.weight;
            else return o.height - this.height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        arr = new Person[n];
        for(int i = 0; i < n; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            arr[i] = new Person(h, w);
        }

        Arrays.sort(arr);
        int answer = 1; // 제일 키 큰 애는 무조건 선발 됨.
        for(int i = 1; i < n; i++) {
            Person target = arr[i];
            boolean fail = false;
            for(int j = 0; j < i; j++) {
                if(target.weight < arr[j].weight) fail = true;
            }
            if(!fail) answer++;
        }

        System.out.println(answer);

    }
}

//일단 키 순서로 정렬
//183 65  -->  1번은 자동 통과
//181 60  -->  2번은 1번보다 키와 몸무게 모두 작으므로 탈락
//180 70  -->  3번은 통과
//172 67
//170 72
