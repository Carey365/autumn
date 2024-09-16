package algorithm.binaryTree;

import java.util.Collections;
import java.util.LinkedList;

public class PostOrder implements Itraversal{
    @Override
    public void exectue(TreeNode node) {
        if(node==null){
            return;
        }
        exectue(node.left);
        exectue(node.right);
        list.add(node.val);
    }

    @Override
    public void execute(TreeNode node, LinkedList<TreeNode> stack) {
        if (node == null) {
            return;
        }
        stack.add(node);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.removeLast();
            list.add(cur.val);
            if (cur.left != null) {
                stack.add(cur.left);
            }
            if (cur.right != null) {
                stack.add(cur.right);
            }
        }
        Collections.reverse(list);
    }
}
