package leetcode.reivew.linkedlist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKSortedLists {

        
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> nodes = new ArrayList<>();
        for(ListNode node : lists) {
            while(node != null) {
                nodes.add(node);
                node = node.next;
            }
        }

        Collections.sort(nodes, (a, b) -> a.val - b.val);
        ListNode root = new ListNode();
        ListNode prev = root;
        for(ListNode n : nodes) {
            root.next = n;
            root = n;
        }

        return prev.next;
    }


    public ListNode mergeKLists2(ListNode[] lists) {
        List<ListNode> list = new ArrayList<>();
        for(ListNode arr : lists) {
            while(arr != null) {
                list.add(arr);
                arr = arr.next;
            }
        }

        list.sort((a, b) -> a.val - b.val);
        ListNode head = new ListNode();
        ListNode start = head;
        for(ListNode n : list) {
            head.next = n;
            head = head.next;
        }

        return start.next;
    }
}
