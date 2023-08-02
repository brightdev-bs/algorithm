package leetcode.reivew.tree;

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
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) return res;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                List<Integer> group = new ArrayList<>();
                int len = queue.size();
                for(int i = 0; i < len; i++) {
                    TreeNode node = queue.poll();
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null) queue.add(node.right);
                    group.add(node.val);
                }

                res.add(group);
            }
            return res;
        }
    }
}
