package $701_InsertIntoABinarySearchTree;

/**
 * @author: suxun
 * @date: 2020/4/29 17:44
 * @description: 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 */
public class InsertIntoABinarySearchTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        }
        insertIntoBSTHelp(root, val);
        return root;
    }

    public static void insertIntoBSTHelp(TreeNode root, int val) {
        if (root == null) {
            return;
        }
        int rootVal = root.val;
        if (rootVal == val) {
            return;
        }
        if (root.left == null && val < rootVal) {
            root.left = new TreeNode(val);
        }
        if (root.right == null && val > rootVal) {
            root.right = new TreeNode(val);
        }
        if (val < rootVal) {
            insertIntoBSTHelp(root.left, val);
        }
        if (val > rootVal) {
            insertIntoBSTHelp(root.right, val);
        }
    }
}
