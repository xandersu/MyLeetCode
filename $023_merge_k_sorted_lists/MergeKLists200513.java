package $023_merge_k_sorted_lists;

/**
 * @author: suxun
 * @date: 2020/4/26 14:35
 * @description:
 */
public class MergeKLists200513 {
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode lNode = mergeKLists(lists, l, mid);
        ListNode rNode = mergeKLists(lists, mid + 1, r);


        return merge2Lists(lNode, rNode);
    }

    private ListNode merge2Lists(ListNode lNode, ListNode rNode) {
        if (lNode == null) {
            return rNode;
        }
        if (rNode == null) {
            return lNode;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while (lNode != null && rNode != null) {
            if (lNode.val < rNode.val) {
                pre.next = lNode;
                lNode = lNode.next;
            } else {
                pre.next = rNode;
                rNode = rNode.next;
            }
            pre = pre.next;
        }
        if (lNode != null) {
            pre.next = lNode;
        } else {
            pre.next = rNode;
        }
        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
