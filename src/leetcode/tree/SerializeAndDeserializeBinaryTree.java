package leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
    public class Codec {

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

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            // Base Case
            if(root == null) return null;

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode cur = queue.poll();

                if(cur == null) {
                    sb.append("null ");
                    continue;
                }
                sb.append(String.valueOf(cur.val) + " ");
                queue.add(cur.left);
                queue.add(cur.right);
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data == null) return null;

            String[] vals = data.split(" ");
            TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            for(int i = 1; i < vals.length; i++) {
                TreeNode parent = q.poll();

                if(!vals[i].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(vals[i]));
                    parent.left = left;
                    q.add(left);
                }

                if(!vals[++i].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(vals[i]));
                    parent.right = right;
                    q.add(right);
                }
            }

            return root;
        }
    }
}
