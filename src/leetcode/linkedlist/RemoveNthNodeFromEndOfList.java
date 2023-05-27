package leetcode.linkedlist;

public class RemoveNthNodeFromEndOfList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode p = head;
        while(p != null) {
            p = p.next;
            len++;
        }

        if(len <= 1) return null;
        if(len - n == 0) return head.next;

        p = head;
        int idx = 1;
        while(p != null) {
            if(len - n == idx) {
                p.next = p.next.next;
                break;
            } else p = p.next;
            idx++;
        }

        return head;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode left = head;
        ListNode right = head;

        for(int i = 1; i <= n; i++) {
            right = right.next;
        }

        if(right == null) return head.next;

        while(right.next != null) {
            right = right.next;
            left = left.next;
        }

        left.next = left.next.next;
        return head;
    }
}
