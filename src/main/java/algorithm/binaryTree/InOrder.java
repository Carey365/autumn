package algorithm.binaryTree;

import java.util.LinkedList;

public class InOrder implements Itraversal {
    @Override
    public void exectue(TreeNode node) {
        if (node == null) {
            return;
        }
        exectue(node.left);
        list.add(node.val);
        exectue(node.right);
    }

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
}
