package algorithm.array;

/**
 *  42. 接雨水
 */
public class Trap {
    public int trap(int[] height) {
        int left =0;
        int right =height.length-1;
        int cur = 0;
        int pre = 0;
        int ans =0;
        while(left<right){
            if(Math.min(height[left],height[right])>cur){
                pre = cur;
                cur = Math.min(height[left],height[right]);
                for(int i=left+1;i<=right-1;i++){
                    if(height[i]>=cur){
                        continue;
                    }
                    ans += Math.max(0,cur-Math.max(height[i],pre));
                }
            }
            if(height[left]<=height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return ans;
    }
}
