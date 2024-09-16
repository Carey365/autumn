package algorithm.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 中序遍历
 */
public class InOrder implements Itraversal {

    List<Integer> list = new ArrayList<>();
    /**
     * 递归遍历
     * @param node
     */
    @Override
    public void exectue(TreeNode node) {
        if (node == null) {
            return;
        }
        exectue(node.left);
        list.add(node.val);
        exectue(node.right);
    }

    /**
     * 迭代遍历
     * @param node
     * @param stack
     */
    @Override
    public void execute(TreeNode node, LinkedList<TreeNode> stack) {
        if (node == null) {
            return;
        }
        TreeNode cur = node;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.add(cur);
                cur = cur.left;
            } else {
                cur = stack.removeLast();
                list.add(cur.val);
                cur = cur.right;
            }
        }
    }

    public void showTree() {
        System.out.println("中序遍历结果：");
        Itraversal.super.showTree(list);
    }
}
