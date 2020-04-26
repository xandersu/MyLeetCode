package $002;

/**
 * @author: suxun
 * @date: 2020/4/26 17:02
 * @description:
 */
public class AddTwoNumbers {

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummyHead = new ListNode(0);
            ListNode prev = dummyHead;
            int carry = 0;

            while (l1 != null || l2 != null) {
                int val1 = l1 != null ? l1.val : 0;
                int val2 = l2 != null ? l2.val : 0;

                int temp = val1 + val2 + carry;
                carry = temp / 10;

                prev.next = new ListNode(temp % 10);
                prev = prev.next;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }
            if (carry > 0) {
                prev.next = new ListNode(carry);
            }
            return dummyHead.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
