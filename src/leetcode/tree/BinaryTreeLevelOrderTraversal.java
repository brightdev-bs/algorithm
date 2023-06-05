package leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

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
    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if(root == null) return new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> tmp;
            while(!queue.isEmpty()) {
                int len = queue.size();
                tmp = new ArrayList<>();
                for(int i = 0; i < len; i++) {
                    TreeNode t = queue.poll();
                    tmp.add(t.val);
                    if(t.left != null) queue.add(t.left);
                    if(t.right != null) queue.add(t.right);
                }
                res.add(tmp);
            }

            return res;
        }
    }
}
