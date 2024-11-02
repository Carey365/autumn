package algorithm.list;

/**
 * 链表
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode buildList(int[] nums) {
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        for (int i = 0; i < nums.length; i++) {
            cur.next = new ListNode(nums[i]);
            cur = cur.next;
        }
        return dummyHead.next;
    }


    public static int getLength(ListNode node) {
        int length = 0;
        while (node != null) {
            node = node.next;
            length++;
        }
        return length;
    }

    public static ListNode reverse(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void printList(ListNode node) {
        StringBuilder str = new StringBuilder();
        while (node != null) {
            str.append(node.val);
            str.append(" ");
            node = node.next;
        }
        System.out.println(str);
    }


}
