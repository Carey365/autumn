package algorithm.list.easy;

import algorithm.list.ListNode;

/**
 * 160. 相交链表
 */
public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int a=getLength(headA);
        int b=getLength(headB);
        ListNode curA=headA;
        ListNode curB=headB;
        if(a>=b){
            for(int i=0;i<a-b;i++){
                curA=curA.next;
            }
            while(curA!=null){
                if(curA==curB){
                    return curA;
                }
                curA=curA.next;
                curB=curB.next;
            }
        }
        else{
            for(int i=0;i<b-a;i++){
                curB=curB.next;
            }
            while(curA!=null){
                if(curA==curB){
                    return curA;
                }
                curA=curA.next;
                curB=curB.next;
            }
        }
        return null;
    }
    public int getLength(ListNode node){
        ListNode cur=node;
        int ans=0;
        while(cur!=null){
            ans++;
            cur=cur.next;
        }
        return ans;
    }
}
