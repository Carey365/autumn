package algorithm.list.medium;

public class MyLinkedList {
    ListNode head;
    ListNode tail;
    public class ListNode{
        int val;
        ListNode next;
        public ListNode(){}
        public ListNode(int val){
            this.val=val;
        }
        public ListNode(int val,ListNode next){
            this.val=val;
            this.next=next;
        }
    }

    public MyLinkedList() {
        head=new ListNode();
    }

    public int get(int index) {
        ListNode node=head.next;
        for(int i=0;i<index;i++){
            node=node.next;
            if(node==null){
                return -1;
            }
        }
        if(node==null){
            return -1;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        if(tail==null){
            tail=new ListNode(val);
            head.next=tail;
        }
        else{
            ListNode temp=head.next;
            head.next=new ListNode(val);
            head.next.next=temp;
        }

    }

    public void addAtTail(int val) {
        if(tail==null){
            tail=new ListNode(val);
            head.next=tail;
        }
        else{
            tail.next=new ListNode(val);
            tail=tail.next;
        }
    }

    public void addAtIndex(int index, int val) {
        ListNode node=head;
        for(int i=0;i<index;i++){
            node=node.next;
            if(node==null){
                return;
            }
        }
        if(tail==null){
            tail=new ListNode(val);
            head.next=tail;
        }
        else{
            ListNode temp=node.next;
            node.next=new ListNode(val);
            node.next.next=temp;
            if(temp==null){
                tail=node.next;
            }
        }

    }

    public void deleteAtIndex(int index) {
        ListNode node=head;
        for(int i=0;i<index;i++){
            node=node.next;
            if(node==null || node.next==null){
                return;
            }
        }
        node.next=node.next.next;
        if(node.next==null){
            tail=node;
        }
    }
}
