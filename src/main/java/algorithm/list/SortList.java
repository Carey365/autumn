package algorithm.list;

/**
 * 148. 排序链表
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        ListNode next = dummyHead;
        while (next != null && next.next != null) {
            cur = cur.next;
            next = next.next.next;
        }
        next = cur.next;
        cur.next = null;
        ListNode node1 = sortList(dummyHead.next);
        ListNode node2 = sortList(next);

        return merge(node1, node2);

    }

    public ListNode merge(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.val <= node2.val) {
            node1.next = merge(node1.next, node2);
            return node1;
        }
        node2.next = merge(node2.next, node1);
        return node2;
    }
}
