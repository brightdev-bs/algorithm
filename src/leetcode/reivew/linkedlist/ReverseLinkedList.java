package leetcode.reivew.linkedlist;

import java.util.Stack;

public class ReverseLinkedList {
    
    public class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }

    public ListNode reverseList(ListNode head) {
        if(head == null) return null;

        ListNode root = head;
        Stack<ListNode> stack = new Stack<>();
        while(head != null) {
            stack.push(head);
            head = head.next;
        }

        ListNode res = stack.pop();
        ListNode answer = res;
        while(!stack.isEmpty()) {
            ListNode tmp = stack.pop();
            tmp.next = null;
            res.next = tmp;
            res = res.next;
        }

        return answer;
    }

    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
