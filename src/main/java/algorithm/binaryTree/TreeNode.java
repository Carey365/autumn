package algorithm.binaryTree;

/**
 * 二叉树
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    static TreeNode buildTree(int[] nums, int index) {
        if(index>=nums.length){
            return null;
        }
        TreeNode node = new TreeNode(nums[index]);
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        node.left = buildTree(nums, left);
        node.right = buildTree(nums, right);
        return node;
    }
}
