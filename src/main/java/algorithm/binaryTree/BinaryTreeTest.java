package algorithm.binaryTree;

import java.util.LinkedList;

public class BinaryTreeTest {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,2,6,8};
        TreeNode node = TreeNode.buildTree(nums,0);
        PreOrder preOrder = new PreOrder();
        InOrder inOrder = new InOrder();
        PostOrder postOrder = new PostOrder();
        LinkedList<TreeNode> list = new LinkedList<>();
        preOrder.execute(node,list);
        inOrder.execute(node,list);
        postOrder.execute(node,list);
        preOrder.showTree();
//        inOrder.showTree();
        postOrder.showTree();
    }
}
