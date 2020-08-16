package $199_binary_tree_right_side_view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author suxun
 * @date 2020/8/16 18:12
 * @description 199. 二叉树的右视图
 */
public class binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> valList = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                tempList.add(poll);
            }
            valList.add(tempList.stream().map(item -> item.val).collect(Collectors.toList()));
            for (TreeNode treeNode : tempList) {
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
        return valList.stream().map(item -> item.get(item.size() - 1)).collect(Collectors.toList());
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
