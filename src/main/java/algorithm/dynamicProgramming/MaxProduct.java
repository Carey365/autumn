package algorithm.dynamicProgramming;

/**
 * 152. 乘积最大子数组
 */
public class MaxProduct {
    public int maxProduct(int[] nums) {
        int ans=nums[0];
        int[] min=new int[nums.length];
        int[] max=new int[nums.length];
        min[0]=nums[0];
        max[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            max[i]=Math.max(nums[i],Math.max(nums[i]*max[i-1],nums[i]*min[i-1]));
            min[i]=Math.min(nums[i],Math.min(nums[i]*max[i-1],nums[i]*min[i-1]));
            ans=Math.max(ans,max[i]);
        }
        return ans;
    }
}
