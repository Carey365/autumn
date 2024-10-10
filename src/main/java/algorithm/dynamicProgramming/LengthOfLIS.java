package algorithm.dynamicProgramming;

/**
 * 300. 最长递增子序列
 */
public class LengthOfLIS {
    public int lengthOfLIS(int[] nums) {
        int ans=1;
        int[] dp=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ans=Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }
}
