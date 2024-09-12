package algorithm.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public interface Itraversal {
    List<Integer> list = new ArrayList<>();

    void exectue(TreeNode node);

    void execute(TreeNode node, LinkedList<TreeNode> stack);

    default void showTree(){
        for (Integer n:list){
            System.out.println(n);
        }
    }
}
