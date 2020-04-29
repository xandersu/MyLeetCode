package $589_n_ary_tree_preorder_traversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: suxun
 * @date: 2020/4/29 16:26
 * @description: 589. N叉树的前序遍历
 */
public class NAryTreePreorderTraversal {

    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    private void preorder(Node root, List<Integer> list) {
        if (root == null || root.children == null) {
            return;
        }
        list.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preorder(root.children.get(i), list);
        }
    }
}
