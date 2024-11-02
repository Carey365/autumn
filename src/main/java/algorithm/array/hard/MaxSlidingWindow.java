package algorithm.array.hard;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 *  239. 滑动窗口最大值
 */
public class MaxSlidingWindow {

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < 2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        // 遍历nums数组
        for(int i = 0;i < nums.length;i++){
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while(!queue.isEmpty() && nums[queue.getLast()] <= nums[i]){
                queue.removeLast();
            }
            // 添加当前值对应的数组下标
            queue.addLast(i);
            // 判断当前队列中队首的值是否有效
            if(queue.getFirst() <= i-k){
                queue.removeFirst();
            }
            // 当窗口长度为k时 保存当前窗口中最大值
            if(i+1 >= k){
                result[i+1-k] = nums[queue.getFirst()];
            }
        }
        return result;
    }

    public int[] maxSlidingWindowSolution2(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        Comparator<Integer> comparator = new Comparator<Integer>(){
            @Override
            public int compare(Integer o1,Integer o2){
                return o2-o1;
            }
        };
        PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        for(int i=0;i<k;i++){
            queue.add(nums[i]);
        }
        for(int i=0;i<ans.length-1;i++){
            ans[i] = queue.peek();
            queue.remove(nums[i]);
            queue.add(nums[i+k]);
        }
        ans[ans.length-1] = queue.peek();
        return ans;
    }
    public int[] maxSlidingWindowSolution3(int[] nums, int k) {
        int[] ans = new int[nums.length-k+1];
        for(int i=0;i<ans.length;i++){
            int max =Integer.MIN_VALUE;
            for(int j=0;j<k;j++){
                max=Math.max(max,nums[i+j]);
            }
            ans[i] =max;
        }
        return ans;
    }
}
