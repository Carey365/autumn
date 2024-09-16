package algorithm.binaryTree;

import java.util.LinkedList;
import java.util.List;

public interface Itraversal {

    void exectue(TreeNode node);

    void execute(TreeNode node, LinkedList<TreeNode> stack);

    default void showTree(List<Integer> list){
        StringBuilder str = new StringBuilder();
        for (Integer n:list){
            str.append(n);
            str.append(" ");
        }
        System.out.println(str);
    }
}
