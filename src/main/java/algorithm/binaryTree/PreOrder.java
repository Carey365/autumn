package algorithm.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 前序遍历
 */
public class PreOrder implements Itraversal {

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
        list.add(node.val);
        exectue(node.left);
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
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.removeLast();
            list.add(cur.val);
            if (cur.right != null) {
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
        }
    }

    public void showTree() {
        System.out.println("前序遍历结果");
        Itraversal.super.showTree(list);
    }
}
