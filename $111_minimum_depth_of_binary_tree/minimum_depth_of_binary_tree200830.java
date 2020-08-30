package $111_minimum_depth_of_binary_tree;

import jdk.internal.org.objectweb.asm.ClassReader;

/**
 * @author suxun
 * @date 2020/8/30 19:10
 * @description
 */
public class minimum_depth_of_binary_tree200830 {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int length = Integer.MAX_VALUE;
        if (root.left != null) {
            length = minDepth(root.left);
        }
        if (root.right != null) {
            int r = minDepth(root.right);
            if (r < length) {
                length = r;
            }
        }
        return length + 1;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
