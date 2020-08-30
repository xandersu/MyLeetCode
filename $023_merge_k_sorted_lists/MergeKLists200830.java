package $023_merge_k_sorted_lists;

import javax.xml.ws.soap.MTOM;

/**
 * @author suxun
 * @date 2020/8/30 16:00
 * @description
 */
public class MergeKLists200830 {
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKLists(ListNode[] lists, int l, int r) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (l == r) {
            return lists[l];
        }
        int mid = l + (r - l) / 2;
        ListNode lListNode = mergeKLists(lists, l, mid);
        ListNode rListNode = mergeKLists(lists, mid + 1, r);
        return merge2List(lListNode, rListNode);
    }


    public static ListNode merge2List(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummyHead = new ListNode();
        ListNode node = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                node.next = l1;
                l1 = l1.next;
            } else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        if (l1 != null) {
            node.next = l1;
        } else {
            node.next = l2;
        }
        return dummyHead.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l5 = new ListNode(5);
        ListNode l7 = new ListNode(7);
        l1.next = l3;
        l3.next = l5;
        l5.next = l7;

        ListNode l2 = new ListNode(2);
        ListNode l4 = new ListNode(4);
        ListNode l6 = new ListNode(6);
        ListNode l8 = new ListNode(8);
        l2.next = l4;
        l4.next = l6;
        l6.next = l8;

        System.out.println(merge2List(l1, l2));
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
