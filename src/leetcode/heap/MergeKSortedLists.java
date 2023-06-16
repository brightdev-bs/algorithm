package leetcode.heap;

public class MergeKSortedLists {
    class Solution {
        
      public class ListNode {
           int val;
           ListNode next;
           ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
        }
        
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists == null || lists.length == 0) return null;
            return mergeKListHelper(lists, 0, lists.length - 1);
        }

        private ListNode mergeKListHelper(ListNode[] lists, int start, int end) {
            if(start == end) return lists[start];
            int mid = start + (end - start) / 2;
            ListNode left = mergeKListHelper(lists, start, mid);
            ListNode right = mergeKListHelper(lists, mid + 1, end);
            return merge(left, right);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode();
            ListNode cur = dummy;

            while(l1 != null && l2 != null) {
                if(l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }

                cur = cur.next;
            }

            cur.next = (l1 != null) ? l1 : l2;
            return dummy.next;
        }
    }
}
