package algorithm.list.easy;

import algorithm.list.ListNode;

/**
 * 203. 移除链表元素
 */
public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode node=new ListNode();
        ListNode ans=node;
        node.next=head;
        while(node.next!=null){
            if(node.next.val==val){
                node.next=node.next.next;
            }
            else{
                node=node.next;
            }
        }
        return ans.next;
    }
}
