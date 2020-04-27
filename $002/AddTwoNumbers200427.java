package $002;

/**
 * @author: suxun
 * @date: 2020/4/27 13:23
 * @description:
 */
public class AddTwoNumbers200427 {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int x) {
            val = x;
        }
    }

    //4.链表相加求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        if (l1 == null || l2 == null) {
            return dummyHead;
        }
        ListNode headNode = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            if (l1 != null) {
                l1Val = l1.val;
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.val;
            }
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;

            dummyHead.next = new ListNode(sum % 10);
            dummyHead = dummyHead.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            dummyHead.next = new ListNode(carry);
        }

        return headNode.next;
    }
}
