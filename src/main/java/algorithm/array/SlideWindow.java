package algorithm.array;

/**
 * 209. 长度最小的子数组
 */
public class SlideWindow {
    public static int minSubArrayLen(int target, int[] nums) {
        int slow =0;
        int ans =Integer.MAX_VALUE;
        int sum =0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            while(sum-nums[slow]>=target ){
                sum-=nums[slow];
                slow++;
            }
            if(sum>=target){
                ans = Math.min(ans,i-slow+1);
            }
        }
        if(sum<target){
            return 0;
        }
        return ans;
    }

}
