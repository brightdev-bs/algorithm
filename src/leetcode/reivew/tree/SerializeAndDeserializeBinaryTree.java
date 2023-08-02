package leetcode.reivew.tree;

public class SerializeAndDeserializeBinaryTree {

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

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            DFS(sb, root);
            String res = sb.toString();
            return res.substring(0, res.length() - 1);
        }

        private void DFS(StringBuilder sb, TreeNode node) {
            if(node == null) sb.append("N,");
            else {
                sb.append(node.val + ",");
                DFS(sb, node.left);
                DFS(sb, node.right);
            }
        }

        int count = 0;

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] chars = data.split(",");
            return dfs2(chars);
        }

        public TreeNode dfs2(String[] arr) {

            if(arr[count].equals("N")) {
                count++;
                return null;
            }

            TreeNode node = new TreeNode(Integer.parseInt(arr[count]));
            count++;
            node.left = dfs2(arr);
            node.right = dfs2(arr);
            return node;
        }
    }
}
