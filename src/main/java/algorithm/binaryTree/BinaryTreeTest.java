package algorithm.binaryTree;

import java.util.LinkedList;

/**
 * 二叉树测试
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        //构建二叉树
        int[] nums = new int[]{1,4,2,6,8};
        TreeNode node = TreeNode.buildTree(nums,0);
        //初始化遍历算法
        PreOrder preOrder = new PreOrder();
        InOrder inOrder = new InOrder();
        PostOrder postOrder = new PostOrder();
        //初始化栈
        LinkedList<TreeNode> stack = new LinkedList<>();
        //执行二叉树的迭代遍历
        preOrder.execute(node,stack);
        inOrder.execute(node,stack);
        postOrder.execute(node,stack);
        //展示二叉树
        preOrder.showTree();
        inOrder.showTree();
        postOrder.showTree();
    }
}
