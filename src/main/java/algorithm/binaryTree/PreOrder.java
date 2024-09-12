package algorithm.binaryTree;

import java.util.LinkedList;

public class PreOrder implements Itraversal {
    @Override
    public void exectue(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        exectue(node.left);
        exectue(node.right);
    }

    @Override
    public void execute(TreeNode node, LinkedList<TreeNode> stack) {
        if(node==null){
            return;
        }
        stack.add(node);
        while(!stack.isEmpty()){
            TreeNode cur = stack.removeLast();
            list.add(cur.val);
            if(cur.right!=null){
                stack.add(cur.right);
            }
            if(cur.left!=null){
                stack.add(cur.left);
            }
        }
    }
}
