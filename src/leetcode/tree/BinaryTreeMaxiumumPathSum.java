package leetcode.tree;

public class BinaryTreeMaxiumumPathSum {


    int max = Integer.MIN_VALUE;

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

    public int maxPathSum(TreeNode root) {
        recursive(root);
        return max;
    }

    public int recursive(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(recursive(node.left), 0);
        int right = Math.max(recursive(node.right), 0);

        max = Math.max(max, node.val + left + right);

        return node.val + Math.max(left, right);
    }
}
