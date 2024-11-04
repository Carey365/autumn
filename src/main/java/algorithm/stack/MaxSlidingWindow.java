package algorithm.stack;

import java.util.LinkedList;

/**
 *  239. 滑动窗口最大值
 */
public class MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=0;i<nums.length;i++){
            while(!list.isEmpty() && i-list.getFirst()>=k){
                list.removeFirst();
            }
            while(!list.isEmpty() && nums[list.getLast()]<=nums[i]){
                list.removeLast();
            }
            list.add(i);
            if(i>=k-1){
                ans[i-k+1]= nums[list.getFirst()];
            }
        }
        return ans;
    }
}
