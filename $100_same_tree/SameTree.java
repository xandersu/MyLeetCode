package $100_same_tree;

/**
 * @author: suxun
 * @date: 2020/4/29 14:07
 * @description: 100. 相同的树
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class SameTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //100. 相同的树
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
