package algorithm.list;

public class ListNodeTest {

    public static void main(String[] args) {
        //初始化链表
        int[] nums = new int[]{1,2,3,4,5,6};
        ListNode node = ListNode.buildList(nums);
        //打印链表长度
        System.out.println(ListNode.getLength(node));
        //打印链表
        ListNode.printList(node);
        //翻转链表
        ListNode reverse = ListNode.reverse(node);
        //打印翻转后的链表
        ListNode.printList(reverse);
    }
}
