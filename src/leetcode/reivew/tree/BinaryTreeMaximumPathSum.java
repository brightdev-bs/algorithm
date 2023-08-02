package leetcode.reivew.tree;

public class BinaryTreeMaximumPathSum {

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
        int max = Integer.MIN_VALUE;
        public int maxPathSum(TreeNode root) {
            DFS(root);
            return max;
        }

        public int DFS(TreeNode node) {
            if(node == null) return 0;
            int leftMax = Math.max(DFS(node.left), 0);
            int rightMax = Math.max(DFS(node.right), 0);

            max = Math.max(max, node.val + leftMax + rightMax);

            return node.val + Math.max(leftMax, rightMax);
        }
    }
}
