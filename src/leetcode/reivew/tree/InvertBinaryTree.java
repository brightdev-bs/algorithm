package leetcode.reivew.tree;

public class InvertBinaryTree {

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
        public TreeNode invertTree(TreeNode root) {
            if(root == null) return null;
            invert(root);
            return root;
        }

        public void invert(TreeNode node) {
            if(node == null) return;
            invert(node.left);
            invert(node.right);

            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
        }
    }
}
