package $61_rotate_linked_list;

/**
 * @author: suxun
 * @date: 2020/4/28 13:23
 * @description: 9.旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 61. 旋转链表
 */
public class RotateList {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode lengthNode = head;
        int length = 0;
        while (lengthNode != null) {
            lengthNode = lengthNode.next;
            length++;
        }
        length = k % length;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;
        ListNode tail = dummyHead;

        for (int i = 0; i < length; i++) {
            head = head.next;
        }

        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }

        head.next = dummyHead.next;
        dummyHead.next = tail.next;
        tail.next = null;

        return dummyHead.next;
    }
}
