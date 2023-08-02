package leetcode.reivew.tree;

import java.util.stream.IntStream;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public static void main(String[] args) {
        int[] inorder = new int[]{-1, 0, 1, 2, 3, 4, 5};
        int index = IntStream.range(0, inorder.length)
                .filter(i -> 1 == inorder[i])
                .findFirst()
                .orElse(-1);

        System.out.println(index);


    }
}
