package algorithm.array.easy;

/**
 * 977. 有序数组的平方
 */
public class sortedSquares {
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        int index=nums.length-1;
        int left=0;
        int right=nums.length-1;
        while(left <= right){
            if(nums[left]*nums[left] >= nums[right]*nums[right]){
                ans[index--]=nums[left]*nums[left];
                left++;
            }
            else{
                ans[index--]=nums[right]*nums[right];
                right--;
            }
        }
        return ans;
    }
}
