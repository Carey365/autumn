package algorithm.list;

import java.util.LinkedList;

public class Partition {
    public ListNode partition(ListNode head, int x) {
        LinkedList<Integer> leftQueue = new LinkedList<>();
        LinkedList<Integer> rightQueue = new LinkedList<>();
        ListNode cur = head;
        while(cur!=null){
            if(cur.val<x){
                leftQueue.add(cur.val);
            }
            else{
                rightQueue.add(cur.val);
            }
            cur = cur.next;
        }
        ListNode dummyHead = new ListNode();
        cur = dummyHead;
        while(!leftQueue.isEmpty()){
            cur.next = new ListNode(leftQueue.removeFirst());
            cur = cur.next;
        }
        while(!rightQueue.isEmpty()){
            cur.next = new ListNode(rightQueue.removeFirst());
            cur = cur.next;
        }
        return dummyHead.next;
    }

    public ListNode partition1(ListNode head, int x) {
        ListNode dummyLeft = new ListNode();
        ListNode dummyRight = new ListNode();
        ListNode curLeft = dummyLeft;
        ListNode curRight = dummyRight;
        ListNode cur = head;
        while(cur!=null){
            if(cur.val<x){
                curLeft.next = new ListNode(cur.val);
                curLeft=curLeft.next;
            }
            else{
                curRight.next = new ListNode(cur.val);
                curRight = curRight.next;
            }
            cur = cur.next;
        }
        curLeft.next = dummyRight.next;
        return dummyLeft.next;
    }
}
