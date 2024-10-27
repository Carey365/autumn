package algorithm.binaryTree;

public class Test {
    static int sum = 0;
    public static void main(String[] args) {
        TreeNode root = TreeNode.buildTree(new int[]{1, 2, 2, 1, 4,1,4}, 0);
        helper(root);
        System.out.println(sum);
    }
    public static int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int count = 0;
        int l = root.left==null?-1:root.left.val;
        int r = root.right==null?-1:root.right.val;
        if(l!=-1 && root.val%2+l%2==1){
            count++;
        }
        if(r!=-1 && root.val%2+r%2==1){
            count++;
        }
        int ans = count+left+right;
        sum+= ans;
        return ans;
    }
}
