package $206_reverse_linked_list;

/**
 * @author suxun
 * @date 2020/8/30 18:16
 * @description
 */
public class ReverseList200830 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public static void main(String[] args) {

    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
