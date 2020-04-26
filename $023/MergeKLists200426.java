package $023;

/**
 * @author: suxun
 * @date: 2020/4/26 14:35
 * @description:
 */
public class MergeKLists200426 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (start == end) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        ListNode listNode1 = mergeKLists(lists, start, mid);
        ListNode listNode2 = mergeKLists(lists, mid + 1, end);
        return mergeTwoLinkedList(listNode1, listNode2);
    }

    public ListNode mergeTwoLinkedList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode(-1);
        ListNode prev = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                prev.next = l2;
                l2 = l2.next;
            } else {
                prev.next = l1;
                l1 = l1.next;
            }
            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
