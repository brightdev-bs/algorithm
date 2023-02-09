package stack.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Q2504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        char[] arr = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int mul = 1;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == '(') {
                stack.push(arr[i]);
                mul *= 2;
            }
            else if(arr[i] == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    sum = 0;
                    break;
                } else if(arr[i - 1] == '(') {
                    sum += mul;
                }
                stack.pop();
                mul /= 2;
            } else if(arr[i] == '[') {
                stack.push(arr[i]);
                mul *= 3;
            } else if(arr[i] == ']') {

                if(stack.isEmpty() || stack.peek() != '[') {
                    sum = 0;
                    break;
                } else if(arr[i - 1] == '[') {
                    sum += mul;
                }
                stack.pop();
                mul /= 3;
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(sum);

    }
}
