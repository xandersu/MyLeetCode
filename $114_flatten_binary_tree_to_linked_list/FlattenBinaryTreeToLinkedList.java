package $114_flatten_binary_tree_to_linked_list;

import javax.xml.ws.soap.MTOM;
import java.util.LinkedList;

/**
 * @author suxun
 * @date 2020/8/2 14:50
 * @description
 */
public class FlattenBinaryTreeToLinkedList {

    public static void flatten(TreeNode root) {
        LinkedList<TreeNode> ll = new LinkedList<>();
        preOrder(root, ll);
        TreeNode node = root;
        for (int i = 1; i < ll.size(); i++) {
            node.left = null;
            node.right = ll.get(i);
            node = node.right;
        }
    }

    public static void preOrder(TreeNode node, LinkedList<TreeNode> ll) {
        if (node == null) {
            return;
        }
        ll.add(node);
        preOrder(node.left, ll);
        preOrder(node.right, ll);

    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 1;
        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 2;
        TreeNode treeNode3 = new TreeNode();
        treeNode3.val = 3;
        TreeNode treeNode4 = new TreeNode();
        treeNode4.val = 4;
        TreeNode treeNode5 = new TreeNode();
        treeNode5.val = 5;
        TreeNode treeNode6 = new TreeNode();
        treeNode6.val = 6;

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode5;
        treeNode2.left = treeNode3;
        treeNode2.right = treeNode4;
        treeNode5.right = treeNode6;

        flatten(treeNode1);

        System.out.println(treeNode1.toString());

        TreeNode treeNode0 = new TreeNode();
        treeNode0.val = 0;
        flatten(treeNode0);
        System.out.println(treeNode0.toString());

    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
