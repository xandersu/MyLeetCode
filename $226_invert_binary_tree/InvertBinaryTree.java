package $226_invert_binary_tree;

/**
 * @author: suxun
 * @date: 2020/4/29 14:30
 * @description: 226. 翻转二叉树
 * 翻转一棵二叉树。
 */
public class InvertBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode treeNode = new TreeNode(root.val);
        treeNode.left = invertTree(root.right);
        treeNode.right = invertTree(root.left);

        return treeNode;
    }
}
