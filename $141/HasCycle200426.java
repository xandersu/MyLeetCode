package $141;

/**
 * @author: suxun
 * @date: 2020/4/26 18:45
 * @description:
 */
public class HasCycle200426 {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != null
                && fast != null
                && slow.next != null
                && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                break;
            }

        }
        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int x) {
            val = x;
        }
    }
}
