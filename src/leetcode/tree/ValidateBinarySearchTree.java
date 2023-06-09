package leetcode.tree;

public class ValidateBinarySearchTree {

    public static class TreeNode {
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

    // 첫 시도
//    public boolean isValidBST(TreeNode root) {
//        if(root == null) return true;
//        if(root.left != null && root.val <= root.left.val) return false;
//        if(root.right != null && root.val >= root.right.val) return false;
//        return isValidBST(root.left) && isValidBST(root.right);
//    }

    private long minVal = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        if(!isValidBST(root.left)) return false;
        if(minVal >= root.val) return false;

        minVal = root.val;

        if(!isValidBST(root.right)) return false;

        return true;

    }

    public static void main(String[] args) {
        ValidateBinarySearchTree m = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(m.isValidBST(root));
    }
}
