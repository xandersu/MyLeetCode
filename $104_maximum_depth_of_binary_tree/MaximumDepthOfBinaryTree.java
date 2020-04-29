package $104_maximum_depth_of_binary_tree;

/**
 * @author: suxun
 * @date: 2020/4/29 10:42
 * @description: 104. 二叉树的最大深度
 */
public class MaximumDepthOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
