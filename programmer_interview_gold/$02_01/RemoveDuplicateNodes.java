package programmer_interview_gold.$02_01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: suxun
 * @date: 2020/4/27 16:08
 * @description: 面试题 02.01. 移除重复节点
 */
public class RemoveDuplicateNodes {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (dummy != null && dummy.next != null) {
            int val = dummy.next.val;
            if (set.contains(val)) {
                dummy.next = dummy.next.next;
            } else {
                set.add(val);
                dummy = dummy.next;
            }
        }
        return head;
    }

}
