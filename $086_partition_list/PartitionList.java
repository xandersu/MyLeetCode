package $086_partition_list;

/**
 * @author: suxun
 * @date: 2020/4/28 16:26
 * @description: 86. 分隔链表
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * <p>
 * 你应当保留两个分区中每个节点的初始相对位置。
 */
public class PartitionList {

    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int x) {
            val = x;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallDummy = new ListNode(0);
        ListNode smallPrev = smallDummy;
        ListNode largeDummy = new ListNode(0);
        ListNode largePrev = largeDummy;

        while (head != null) {
            if (head.val < x) {
                smallPrev.next = head;
                smallPrev = smallPrev.next;
            } else {
                largePrev.next = head;
                largePrev = largePrev.next;
            }
            head = head.next;
        }
        smallPrev.next = largeDummy.next;
        largePrev.next = null;
        return smallDummy.next;
    }

}
