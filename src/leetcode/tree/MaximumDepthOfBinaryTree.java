package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthOfBinaryTree {
    /**
     * That heavily depends on the structure of the search tree and the number and location of solutions (aka searched-for items).
     * If you know a solution is not far from the root of the tree, a breadth first search (BFS) might be better.
     * If the tree is very deep and solutions are rare, depth first search (DFS) might take an extremely long time, but BFS could be faster.
     * If the tree is very wide, a BFS might need too much memory, so it might be completely impractical.
     * If solutions are frequent but located deep in the tree, BFS could be impractical.
     * If the search tree is very deep you will need to restrict the search depth for depth first search (DFS), anyway (for example with iterative deepening).
     * But these are just rules of thumb; you'll probably need to experiment.
     */

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
    // DFS
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // BFS
    public int maxDepth2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return 0;
        queue.add(root);
        int h = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            h++;
            for(int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                if(cur.right != null) queue.add(cur.right);
                if(cur.left != null) queue.add(cur.left);
            }
        }
        return h;
    }
}
