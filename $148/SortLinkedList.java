package $148;

/**
 * @author: suxun
 * @date: 2020/4/27 13:10
 * @description:
 */
public class SortLinkedList {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int x) {
            val = x;
        }
    }

    //3,链表排序
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode rightNode = sortList(middle.next);
        middle.next = null;
        ListNode leftNode = sortList(head);

        return mergeTwoList(leftNode, rightNode);
    }

    public static ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1 != null ? l1 : l2;
        return head.next;
    }

}
