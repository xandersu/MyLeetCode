package $206_reverse_linked_list;

/**
 * @author: suxun
 * @date: 2020/4/26 15:06
 * @description:
 */
public class ReverseList20042601 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return headNode;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
