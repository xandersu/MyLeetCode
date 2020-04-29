package $222_count_complete_tree_nodes;

/**
 * @author: suxun
 * @date: 2020/4/29 12:54
 * @description:
 */
public class CountCompleteTreeNodes {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
