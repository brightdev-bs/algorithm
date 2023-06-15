package leetcode.tree;

public class LowestCommonAncestorOfaBinarySearchTree {
    class Solution {

        public class TreeNode {
            int val;
            Solution.TreeNode left;
            Solution.TreeNode right;
            TreeNode() {}
            TreeNode(int val) { this.val = val; }
            TreeNode(int val, Solution.TreeNode left, Solution.TreeNode right) {
                this.val = val;
                this.left = left;
                this.right = right;
            }
        }
        
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null) return null;
            if(root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
            if(root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
            else return root;
        }
    }
}
