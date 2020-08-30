package $206_reverse_linked_list;

/**
 * @author: suxun
 * @date: 2020/4/26 15:06
 * @description:
 */
public class ReverseList20042602 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
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

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
