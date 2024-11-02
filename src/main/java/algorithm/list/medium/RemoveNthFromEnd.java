package algorithm.list.medium;

import algorithm.list.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = getLength(head);
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;
        for(int i=0;i<l-n;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummyHead.next;
    }
    public int getLength(ListNode head){
        int ans = 0;
        while(head!=null){
            ans++;
            head = head.next;
        }
        return ans;
    }
}
