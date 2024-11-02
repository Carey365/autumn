package algorithm.list.medium;

import algorithm.list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head=head.next;
        }
        return null;
    }
}
