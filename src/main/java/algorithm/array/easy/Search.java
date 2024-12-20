package algorithm.array.easy;

/**
 * 704. 二分查找
 */
public class Search {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int ans=-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(nums[mid]>target){
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                ans=mid;
                break;
            }
        }
        return ans;
    }
}
