package stack.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Q2504_R {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int value = 1;
        int sum = 0;
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                stack.push(arr[i]);
                value *= 2;
            } else if(arr[i] == '[') {
                stack.push(arr[i]);
                value *= 3;
            } else if(arr[i] == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                } else if(arr[i - 1] == '(') {
                    sum += value;
                }
                stack.pop();
                value /= 2;
            } else if(arr[i] == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                } else if(arr[i - 1] == '[') {
                    sum += value;
                }

                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(sum);

    }
}
