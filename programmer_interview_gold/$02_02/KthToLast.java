package programmer_interview_gold.$02_02;

/**
 * @author: suxun
 * @date: 2020/4/27 13:50
 * @description:
 */
public class KthToLast {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int x) {
            val = x;
        }
    }

    public int kthToLast(ListNode head, int k) {
        if (head == null || k < 0) {
            return 0;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (k <= 0) {
                slow = slow.next;
            }
            fast = fast.next;
            k--;
        }
        if (k > 0) {
            return 0;
        }
        return slow.val;
    }
}
