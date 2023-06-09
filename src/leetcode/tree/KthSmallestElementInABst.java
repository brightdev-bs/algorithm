package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInABst {
    
    class Solution {

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, TreeNode left, TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }

        int min = Integer.MIN_VALUE;
        List<Integer> list = new ArrayList<>();

        public int kthSmallest(TreeNode root, int k) {
            traversal(root);
            return list.get(k - 1);
        }

        public void traversal(TreeNode root) {
            if(root == null) return;

            traversal(root.left);

            if(min >= root.val) return;

            min = root.val;
            list.add(min);

            traversal(root.right);
        }
    }
}
