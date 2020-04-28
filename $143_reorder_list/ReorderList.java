package $143_reorder_list;

/**
 * @author: suxun
 * @date: 2020/4/28 15:56
 * @description: 143. 重排链表
 */
public class ReorderList {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode middle = getMiddle10(head);
        ListNode reverse = reverseList10(middle.next);
        middle.next = null;

        int i = 0;
        ListNode prev = new ListNode(0);
        while (head != null && reverse != null) {
            if (i % 2 == 0) {
                prev.next = head;
                head = head.next;
            } else {
                prev.next = reverse;
                reverse = reverse.next;
            }
            i++;
            prev = prev.next;
        }
        prev.next = head != null ? head : reverse;
    }

    public static ListNode reverseList10(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode temp = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }

    public static ListNode getMiddle10(ListNode head) {
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
}
