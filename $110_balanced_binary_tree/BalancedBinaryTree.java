package $110_balanced_binary_tree;

/**
 * @author: suxun
 * @date: 2020/4/29 13:20
 * @description: 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 */
public class BalancedBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHigh6(root.left);
        int rightHeight = getHigh6(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHigh6(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHigh6(root.left), getHigh6(root.right)) + 1;
    }
}
