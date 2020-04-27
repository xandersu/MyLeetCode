package $019;

/**
 * @author: suxun
 * @date: 2020/4/27 13:52
 * @description: 19. 删除链表的倒数第N个节点
 */
public class RemoveNthFromEnd {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //6.删除链表倒数第n个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n < 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null) {
            if (n <= 0) {
                pre = slow;
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        if (n > 0) {
            return null;
        }
        if (pre == null) {
            return head.next;
        }
        pre.next = slow.next;

        return head;
    }
}
