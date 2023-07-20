package leetcode.reivew.linkedlist;

public class DetectCycleInALinkedList {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            if(current.val == Integer.MIN_VALUE) {
                return true;
            } else {
                current.val = Integer.MIN_VALUE;
                prev = current;
                current = current.next;
            }
        }
        return false;
    }
}
