package bruteforce.baekjoon;

import java.util.Scanner;

public class Q1062 {

    static int[] ch = new int[26];
    static String[] words;

    static int n, k, max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); // 단어의 개수
        k = sc.nextInt(); // 가르칠 수 있는 글자 갯수

        if(k < 5) {
            System.out.println(0);
        } else if(k == 26) {
            System.out.println(n);
        }else {
            ch['a' - 'a'] = 1;
            ch['n' - 'a'] = 1;
            ch['t' - 'a'] = 1;
            ch['i' - 'a'] = 1;
            ch['c' - 'a'] = 1;

            words = new String[n];
            for(int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            backTracking(0, 0);
            System.out.println(max);
        }


    }

    public static void backTracking(int a, int len) {
        if(len == k - 5) {
            int count = 0;
            for(int i = 0; i < n; i++) {
                boolean read = true;
                for(int j = 0; j < words[i].length(); j++) {
                    if(ch[words[i].charAt(j) - 'a'] == 0) {
                        read = false;
                        break;
                    }
                }
                if(read) count++;
            }
            max = Math.max(max, count);
        }

        else {
            for(int i = a; i < 26; i++) {
                if(ch[i] == 0) {
                    ch[i] = 1;
                    backTracking(i, len + 1);
                    ch[i] = 0;
                }
            }
        }

    }
}


